package com.hhaie.backend.mapper;

import com.hhaie.backend.model.Player;
import com.hhaie.backend.model.dto.PlayerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    Player map(PlayerDto dto);

    PlayerDto map(Player player);
}
