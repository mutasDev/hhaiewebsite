package com.hhaie.backend.service;

import com.hhaie.backend.model.Player;
import com.hhaie.backend.model.Team;
import com.hhaie.backend.model.enums.Game;
import com.hhaie.backend.repository.PlayerRepository;
import com.hhaie.backend.repository.TeamRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExcelParserService {


    private final TeamService teamService;

    public ExcelParserService(TeamRepository teamRepository, TeamService teamService, PlayerRepository playerRepository, PlayerService playerService) {
        this.teamService = teamService;
    }

    public void parseExcelSheet() throws IOException {
        FileInputStream file = new FileInputStream(new File("src/main/java/com/hhaie/backend/service/sample.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);
        parseSheet(workbook.getSheetAt(0), Game.LOL);
        parseSheet(workbook.getSheetAt(1), Game.RL);
    }

    private void parseSheet(Sheet sheet, Game game) {
        boolean rowNotEmpty = true;
        int i = 2;
        Team team = null;
        Player player;
        while (rowNotEmpty) {
            Row row = sheet.getRow(i);
            if (isCellEmpty(row.getCell(2))) {
                rowNotEmpty = false;
                if(team != null) {
                    teamService.createTeam(team);
                }
            }
            else {
                //check teamname
                if (!isCellEmpty(row.getCell(0))) {
                    // non-empty, so create new team
                    if (team != null) {
                        teamService.createTeam(team);
                    }
                    team = new Team();
                    team.setName(row.getCell(0).getRichStringCellValue().getString());
                    team.setGame(game);
                }
                if (!isCellEmpty(row.getCell(1))) {
                    if (team != null) {
                        team.setLeague(row.getCell(1).getRichStringCellValue().getString());
                    }
                }
                player = new Player();
                if (!isCellEmpty(row.getCell(2))) {
                    player.setForeName(row.getCell(2).getRichStringCellValue().getString());
                }

                if (!isCellEmpty(row.getCell(3))) {
                    player.setNickName(row.getCell(3).getRichStringCellValue().getString());

                }
                if (!isCellEmpty(row.getCell(4))) {
                    player.setLastName(row.getCell(4).getRichStringCellValue().getString());

                }
                if (!isCellEmpty(row.getCell(5))) {
                    player.setPosition(row.getCell(5).getRichStringCellValue().getString());

                }


                List<Player> players = team.getPlayers();
                players.add(player);
                team.setPlayers(players);
            }

            i++;
        }
    }

    public boolean isCellEmpty(Cell cell) {
        if(cell == null) {
            return true;
        }
        return cell.getCellTypeEnum().equals(CellType.BLANK);
    }
}


