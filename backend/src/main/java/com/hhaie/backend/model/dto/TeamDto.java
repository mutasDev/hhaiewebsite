package com.hhaie.backend.model.dto;

import com.hhaie.backend.model.enums.Game;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TeamDto implements Serializable {

    private Long id;

    private String name;

    private String league;

    private Game game;

    private List<PlayerDto> players;
}
