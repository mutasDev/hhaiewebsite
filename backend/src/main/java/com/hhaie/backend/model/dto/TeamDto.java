package com.hhaie.backend.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamDto {

    private Long id;

    private String name;

    private String league;

    private List<PlayerDto> players;
}
