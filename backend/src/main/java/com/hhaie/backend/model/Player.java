package com.hhaie.backend.model;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String foreName;

    @Column
    private String lastName;

    @Column
    private String nickName;

    @Column
    private String pictureId;

    @Column
    private String position;

}
