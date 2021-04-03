package com.hhaie.backend.controller;

import com.hhaie.backend.mapper.PlayerMapper;
import com.hhaie.backend.model.dto.PlayerDto;
import com.hhaie.backend.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public List<PlayerDto> getPlayers() {
        return new ArrayList<>();
    }


    @PostMapping(value = "/add")
    public PlayerDto addPlayer(@RequestBody PlayerDto player){
       PlayerDto dto =  playerMapper.map(playerService.addPlayer(playerMapper.map(player)));
        return dto;
    }
}
