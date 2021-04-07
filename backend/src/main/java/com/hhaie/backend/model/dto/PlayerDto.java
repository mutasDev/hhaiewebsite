package com.hhaie.backend.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerDto implements Serializable {
    private Long id;

    private String foreName;

    private String lastName;

    private String nickName;

    private String pictureId;

    private String position;

}
