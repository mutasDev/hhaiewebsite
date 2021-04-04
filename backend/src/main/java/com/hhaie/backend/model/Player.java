package com.hhaie.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Player{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foreName;

    private String lastName;

    private String nickName;

    private String pictureId;

    private String position;


}
