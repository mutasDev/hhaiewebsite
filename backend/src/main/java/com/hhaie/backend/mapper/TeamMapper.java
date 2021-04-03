package com.hhaie.backend.mapper;

import com.hhaie.backend.model.Team;
import com.hhaie.backend.model.dto.TeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(uses = PlayerMapper.class, componentModel = "spring")
public interface TeamMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "game", target = "game")
    @Mapping(source = "league", target = "league")
    @Mapping(source = "players", target = "players")
    Team map(TeamDto dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "game", target = "game")
    @Mapping(source = "league", target = "league")
    @Mapping(source = "players", target = "players")
    TeamDto map(Team team);
}
