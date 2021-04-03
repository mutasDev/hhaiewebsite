package com.hhaie.backend.controller;

import com.hhaie.backend.mapper.TeamMapper;
import com.hhaie.backend.model.Team;
import com.hhaie.backend.model.dto.TeamDto;
import com.hhaie.backend.model.enums.Game;
import com.hhaie.backend.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("team")
public class TeamController {

    private final TeamMapper teamMapper;

    private final TeamService teamService;


    public TeamController(TeamMapper teamMapper, TeamService teamService) {
        this.teamMapper = teamMapper;
        this.teamService = teamService;
    }

    @GetMapping("/game/{game}")
    public List<TeamDto> getTeamsOfGame(@PathVariable Game game) {
        return this.teamService.getTeamsOfGame(game).stream().map(teamMapper::map).collect(Collectors.toList());
    }

    @PostMapping("/add/{teamId}/{playerId}")
    public TeamDto addPlayerToTeam(@PathVariable Long teamId, @PathVariable Long playerId) {
        return teamMapper.map(teamService.addPlayerToTeam(teamId, playerId));
    }

    @PostMapping
    public TeamDto createTeam(@RequestBody TeamDto dto) {
        Team team = teamMapper.map(dto);
        return teamMapper.map(teamService.createTeam(team));
    }
}
