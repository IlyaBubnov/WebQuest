package com.ilyabubnov.webquest.model;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import java.util.Objects;

@Setter
@EqualsAndHashCode
@Log4j2
public class Game {

    @NonNull
    private Entity actualGameStatus;

    public Game(@NonNull Entity actualGameStatus) {
        this.actualGameStatus = actualGameStatus;
        log.info("Created new game.");
    }

    public boolean gameOver() {
        return !GameStatus.INTERIM.equals(actualGameStatus.getGameStatus());
    }
    public String getPhrase() {
        return actualGameStatus.getPhrase();
    }

    public String getMessageFromFirstOpportunity() {
        if (actualGameStatus.getFirstOpportunity() == null) {
            return "";
        }
        return actualGameStatus.getFirstOpportunity().getChoice();
    }

    public String getMessageFromSecondOpportunity() {
        if (actualGameStatus.getSecondOpportunity() == null) {
            return "";
        }
        return actualGameStatus.getSecondOpportunity().getChoice();
    }

    public Entity getFirstOpportunity() {
        return actualGameStatus.getFirstOpportunity();
    }

    public Entity getSecondOpportunity() {
        return actualGameStatus.getSecondOpportunity();
    }

    public GameStatus getGameStatus() {
        return actualGameStatus.getGameStatus();
    }
}
