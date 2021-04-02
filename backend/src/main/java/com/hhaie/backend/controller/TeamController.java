package com.hhaie.backend.controller;

import com.hhaie.backend.mapper.TeamMapper;
import com.hhaie.backend.service.TeamService;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "team")
public class TeamController {

    private final TeamMapper teamMapper;

    private final TeamService teamService;


    public TeamController(TeamMapper teamMapper, TeamService teamService) {
        this.teamMapper = teamMapper;
        this.teamService = teamService;
    }
}
