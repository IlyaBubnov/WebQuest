package com.ilyabubnov.webquest.services;

import com.ilyabubnov.webquest.exceptions.IllegalChoiceValueException;
import com.ilyabubnov.webquest.exceptions.NullGameStatusException;
import com.ilyabubnov.webquest.model.Entity;
import com.ilyabubnov.webquest.model.Game;
import com.ilyabubnov.webquest.model.GameStatus;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WorkingWithDataFromJson {

    @NonNull
    private final Game game;

    //В конструкторе класса создаем новый объект класса DataFromJson, который будет использоваться для получения
    //объекта класса Game. Текущий объект game инициализируется вызовом метода getGame() у объекта dataFromJson.
    public WorkingWithDataFromJson () {
        DataFromJson dataFromJson = new DataFromJson();
        this.game = dataFromJson.getGame();
    }

    //проверяю, окончена ли игра
    public boolean gameOver () {
        return game.gameOver();
    }

    //Метод возвращает текст предложения из объекта game, преобразуя все символы новой строки в тег "<br>"
    //для отображения в HTML.
    public String getPhrase () {
        return game.getPhrase().replace("\n", "<br>");
    }

    //Методы getMessageFromFirstOpportunity и getMessageFromSecondOpportunity возвращают текст первого и второго
    //варианта выбора из объекта game.
    public String getMessageFromFirstOpportunity() {
        return game.getMessageFromFirstOpportunity();
    }

    public String getMessageFromSecondOpportunity () {
        return game.getMessageFromSecondOpportunity();
    }

    //Метод choiceOfOption(int option), для удобства и наглядности делаем через switch, принимает вариант выбора
    // от пользователя и изменяет состояние объекта game в соответствии с выбранным вариантом. Если выбранный вариант
    //равен 1, то текущее состояние объекта game устанавливается равным первому варианту выбора. Если выбранный вариант
    //равен 2, то текущее состояние объекта game устанавливается равным второму варианту выбора. Если выбранный вариант
    //не равен ни 1, ни 2, то выбрасывается исключение.

    public void choiceOfOption(int option) {
        switch (option) {
            case 1 -> {
                        Entity firstOpportunity = game.getFirstOpportunity();
                        if (firstOpportunity == null) {
                            log.error(NullGameStatusException.message);
                            throw new NullGameStatusException();
                        }
                        game.setActualGameStatus(firstOpportunity);
            }
            case 2 -> {
                        Entity secondOpportunity = game.getSecondOpportunity();
                        if (secondOpportunity == null) {
                            log.error(NullGameStatusException.message);
                            throw new NullGameStatusException();
                        }
                        game.setActualGameStatus(secondOpportunity);
            }
            default -> {
                        log.error("value: " + option + IllegalChoiceValueException.message);
                        throw new IllegalChoiceValueException();
            }
        }
    }

    //Метод getGameStatus возвращает текущее состояние объекта game.
    public GameStatus getGameStatus () {
        return game.getGameStatus();
    }

    //Метод getGameResult возвращает текст результата выполнения игры из объекта game.
    public String getGameResult () {
        return  game.getGameStatus().getString();
    }
}
