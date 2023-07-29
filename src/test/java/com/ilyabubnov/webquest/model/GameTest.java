package com.ilyabubnov.webquest.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private final Entity firstOpportunity = new Entity
            (2, GameStatus.WIN, "Win", "First opportunity", null, null);
    private final Entity secondOpportunity = new Entity
            (3, GameStatus.LOSE, "Lose", "Second opportunity", null, null);
    private final int value = 1;
    private final GameStatus gameStatus = GameStatus.INTERIM;
    private final String phrase = "Your choice?";
    private final String choice = "";
    private final Entity start = new Entity(value, gameStatus, phrase, choice, firstOpportunity, secondOpportunity);

    //Проверяею, что созданный экземпляр Game совпадает с ожидаемым экземпляром, созданным с помощью конструктора.
    @Test
    public void checkWhenPassingCorrectParametersToConstructor () {
       Game game = new Game(start);
       assertEquals(game, new Game(start));
    }

    //Проверяю, что при передаче null в конструктор Game, будет выброшено исключение NullPointerException.
    @Test
    public void checkWhenPassingGameNullExceptionAreThrown () {
        assertThrows(NullPointerException.class, () -> new Game(null));
    }

    //Проверяю, что метод gameOver возвращает ожидаемое значение. Метод создает экземпляр Game и проверяет, что метод
    //gameOver возвращает правильное значение в зависимости от состояния экземпляра.
    @Test
    public void invokeGameOver () {
        Game game = new Game(start);
        boolean gameOver = start.getGameStatus() != GameStatus.INTERIM;
        assertEquals(gameOver, game.gameOver());
        game = new Game(firstOpportunity);
        assertTrue(game.gameOver());
    }
}
