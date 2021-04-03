package com.hhaie.backend.controller;

import com.hhaie.backend.mapper.PlayerMapper;
import com.hhaie.backend.model.dto.PlayerDto;
import com.hhaie.backend.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("player")
public class PlayerController {

    private final PlayerMapper playerMapper;

    private final PlayerService playerService;

    public PlayerController(PlayerMapper playerMapper, PlayerService playerService) {
        this.playerMapper = playerMapper;
        this.playerService = playerService;
    }


    @GetMapping(value = "")
    @CrossOrigin
    public List<PlayerDto> getPlayers() {
        return playerService.getAllPlayers().stream().map(playerMapper::map).collect(Collectors.toList());
    }


    @PostMapping(value = "/add")
    @CrossOrigin
    public PlayerDto addPlayer(@RequestBody PlayerDto player) {
        PlayerDto dto = playerMapper.map(playerService.addPlayer(playerMapper.map(player)));
        return dto;
    }
}
