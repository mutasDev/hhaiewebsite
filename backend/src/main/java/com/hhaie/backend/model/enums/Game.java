package com.hhaie.backend.model.enums;

public enum Game {
    LOL("League of Legends"),
    RL("Rocket League"),
    CSGO("Counters-Strike GO"),
    OW("Overwatch"),
    R6("Rainbow Six: Siege"),
    HS("Hearthstone"),
    SSBU("Super Smash Bros. Ultimate"),
    VL("Valorant"),
    FIFA("FIFA"),
    LOR("Legends of Runeterra"),
    ;

    public final String name;


    Game(String s) {
        this.name = s;
    }
}
