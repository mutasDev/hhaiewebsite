package com.hhaie.backend.controller;

import com.hhaie.backend.mapper.TeamMapper;
import com.hhaie.backend.model.Team;
import com.hhaie.backend.model.dto.TeamDto;
import com.hhaie.backend.model.enums.Game;
import com.hhaie.backend.service.ExcelParserService;
import com.hhaie.backend.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("team")
public class TeamController {

    private final TeamMapper teamMapper;

    private final TeamService teamService;

    private final ExcelParserService excelParserService;


    public TeamController(TeamMapper teamMapper, TeamService teamService, ExcelParserService excelParserService) {
        this.teamMapper = teamMapper;
        this.teamService = teamService;
        this.excelParserService = excelParserService;
    }

    @GetMapping
    @CrossOrigin
    public List<TeamDto> getAllTeams() {
        return this.teamService.getAllTeams().stream().map(teamMapper::map).collect(Collectors.toList());
    }

    @GetMapping("/game/{game}")
    @CrossOrigin
    public List<TeamDto> getTeamsOfGame(@PathVariable String game) {
        return this.teamService.getTeamsOfGame(Game.valueOf(game)).stream().map(teamMapper::map).collect(Collectors.toList());
    }

    @GetMapping("/update")
    public List<TeamDto> updateTeams() throws IOException {
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
}
