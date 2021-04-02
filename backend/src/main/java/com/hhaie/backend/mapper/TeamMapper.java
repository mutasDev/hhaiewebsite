package com.hhaie.backend.mapper;

import com.hhaie.backend.model.Team;
import com.hhaie.backend.model.dto.TeamDto;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(uses = PlayerMapper.class, componentModel = "spring")
public interface TeamMapper {

    Team map(TeamDto dto);

    TeamDto map(Team team);
}
