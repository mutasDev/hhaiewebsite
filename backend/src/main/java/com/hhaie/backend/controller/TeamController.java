package com.hhaie.backend.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.hhaie.backend.mapper.PlayerMapper;
import com.hhaie.backend.mapper.TeamMapper;
import com.hhaie.backend.model.Player;
import com.hhaie.backend.model.Team;
import com.hhaie.backend.model.dto.PlayerDto;
import com.hhaie.backend.model.dto.TeamDto;
import com.hhaie.backend.model.enums.Game;
import com.hhaie.backend.service.ExcelParserService;
import com.hhaie.backend.service.TeamService;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("team")
public class TeamController {

    private final TeamMapper teamMapper;
    private final PlayerMapper playerMapper;


    private final TeamService teamService;

    private final ExcelParserService excelParserService;


    public TeamController(TeamMapper teamMapper, TeamService teamService, ExcelParserService excelParserService, PlayerMapper playerMapper) {
        this.teamMapper = teamMapper;
        this.teamService = teamService;
        this.excelParserService = excelParserService;
        this.playerMapper = playerMapper;
    }

    @GetMapping
    @CrossOrigin
    public List<TeamDto> getAllTeams() {
        List<TeamDto> collect = this.teamService.getAllTeams().stream().map(teamMapper::map).collect(Collectors.toList());
        return collect;
    }

    @GetMapping("/game/{game}")
    @CrossOrigin
    public List<TeamDto> getTeamsOfGame(@PathVariable String game) {
        return this.teamService.getTeamsOfGame(Game.valueOf(game)).stream().map(teamMapper::map).collect(Collectors.toList());
    }

    @GetMapping("/update")
    @CrossOrigin
    public List<TeamDto> updateTeams() throws IOException {
        this.teamService.clearTeams();
        excelParserService.parseExcelSheet();
        return getAllTeams();
    }

    @PostMapping("/add/{teamId}/{playerId}")
    @CrossOrigin
    public TeamDto addPlayerToTeam(@PathVariable Long teamId, @PathVariable Long playerId) {
        return teamMapper.map(teamService.addPlayerToTeam(teamId, playerId));
    }

    @PostMapping
    @CrossOrigin
    public TeamDto createTeam(@RequestBody TeamDto dto) {
        Team team = teamMapper.map(dto);
        return teamMapper.map(teamService.createTeam(team));
    }

    @PostMapping("/edit/{teamId}")
    @CrossOrigin
    public TeamDto removePlayersFromTeam(@PathVariable Long teamId, @RequestBody List<PlayerDto> dto)
    {
        //test
        for(PlayerDto play : dto)
        {
            System.out.println(play);
        }
        System.out.println("test\n" + dto);
        List<Player> playerList = new ArrayList<Player>();
        return teamMapper.map(teamService.editTeam(teamId, playerList));
    }


}
