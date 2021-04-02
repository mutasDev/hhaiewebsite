package com.hhaie.backend.controller;

import com.hhaie.backend.mapper.PlayerMapper;
import com.hhaie.backend.model.dto.PlayerDto;
import com.hhaie.backend.service.PlayerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/player")
public class PlayerController {

    private final PlayerMapper playerMapper;

    private final PlayerService playerService;

    public PlayerController(PlayerMapper playerMapper, PlayerService playerService) {
        this.playerMapper = playerMapper;
        this.playerService = playerService;
    }


    @PostMapping(value = "/add")
    private PlayerDto addPlayer(@RequestBody PlayerDto player){
       PlayerDto dto =  playerMapper.map(playerService.addPlayer(playerMapper.map(player)));
        return dto;
    }
}
