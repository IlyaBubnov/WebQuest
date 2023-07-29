package com.ilyabubnov.webquest.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EntityTest {

    private final int value = 1;
    private final GameStatus gameStatus = GameStatus.INTERIM;
    private final String phrase = "Phrase";
    private final String choice = "Choice";
    private final Entity firstOpportunity = null;
    private final Entity secondOpportunity = null;

    //Проверяю, что при передаче корректных параметров в конструктор Entity, создается объект Entity и его значения
    //совпадают с переданными параметрами.
    @Test
    public void checkWhenPassingCorrectParametersToConstructor () {
        Entity entity = new Entity(value, gameStatus, phrase, choice, firstOpportunity, secondOpportunity);
        assertEquals (entity, new Entity(value, gameStatus, phrase, choice, firstOpportunity, secondOpportunity));
    }

    //Далее проверяю, что при передаче null в качестве параметров в конструктор Entity, выбрасываются
    //исключения NullPointerException. Проверка для полей класса gameStatus, Phrase & choice.

    @Test
    public void checkWhenPassingGameStatusNullExceptionAreThrown () {
        assertThrows(NullPointerException.class,
                () -> new Entity(value, null, phrase, choice, null, null));
    }

    @Test
    public void checkWhenPassingPhraseNullExceptionAreThrown () {
        assertThrows(NullPointerException.class,
                () -> new Entity(value, gameStatus, null, choice, firstOpportunity, secondOpportunity));
    }

    @Test
    public void checkWhenPassingChoiceNullExceptionAreThrown () {
        assertThrows(NullPointerException.class,
                () -> new Entity(value, gameStatus, choice, null, firstOpportunity, secondOpportunity));
    }
}
