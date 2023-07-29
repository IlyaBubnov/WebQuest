package com.ilyabubnov.webquest.model;

public enum GameStatus {
    WIN ("Win!"),
    LOSE("You lost!"),
    INTERIM("Nothing happened.");
    private final String meaning;
    GameStatus(String meaning) {
        this.meaning = meaning;
    }
    public String getString() {
        return meaning;
    }
}

