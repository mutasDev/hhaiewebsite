package com.hhaie.backend.model.dto;

import lombok.Data;

@Data
public class PlayerDto {
    private Long id;

    private String foreName;

    private String lastName;

    private String nickName;

    private String pictureId;

    private String position;
}
