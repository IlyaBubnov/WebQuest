package com.ilyabubnov.webquest.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilyabubnov.webquest.exceptions.IllegalDataFileException;
import com.ilyabubnov.webquest.model.Entity;
import com.ilyabubnov.webquest.model.Game;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Getter
@Log4j2
public class DataFromJson {
    //Конструктор класса загружает данные для игры из файла JSON и создает объект Game на основе этих данных.
    //Метод readGameStatusFromJson использует библиотеку ObjectMapper для чтения данных из JSON-файла.
    //Он принимает путь к файлу как параметр и возвращает список объектов (Entity), которые представляют
    //состояния игры. Также проводим проверку на наличие данных в файле и выбрасываем исключение
    //IllegalDataFileException, если файл не содержит данных. В случае возникновения ошибки в чтении файла
    //выбрасываем исключение RuntimeException. Если при загрузке данных игры возникает исключение NullPointerException,
    //то в лог записывается сообщение об ошибке и исключение повторно выбрасывается.
    //В итоге, после выполнения конструктора класса DataFromJson, поле game будет содержать объект класса Game,
    //созданный на основе данных игры из JSON-файла.

    @NonNull
    private final Game game;
     public DataFromJson() {
        try {
            String pathToJFile = String.valueOf(getClass().getResource("/source.json"));
            //String pathToFile = getClass().getResource("C:\\Users\\User\\Desktop\\Web quest\\src\\main\\resources\\source.json").getPath();
            //String pathToFile = Objects.requireNonNull(getClass().getResource("C:\\Users\\User\\Desktop\\Web quest\\src\\main\\resources\\source.json")).getPath();
            //String pathToFile = getClass().getResource("/source.json").getPath();
            //String pathToFile = Objects.requireNonNull(getClass().getResource(/source.json")).getPath();
            List <Entity> gameStatus = readGameStatusFromJson(pathToJFile);
            Entity begin = gameStatus.get(0);
            game = new Game(begin);
        } catch (NullPointerException e) {
            log.error("Didn't find path to game file. " + e.getMessage());
            throw e;
        }
    }

    private static List <Entity> readGameStatusFromJson (@NonNull String pathToFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        File gameFile = new File(pathToFile);
        try {
            List <Entity> entities = objectMapper.readValue(gameFile, new TypeReference<>(){});
            log.info("Read data from file.");
            if (entities.size() == 0) {
                log.error(IllegalDataFileException.message);
                throw new IllegalDataFileException();
            }
            return entities;
        } catch (IOException e) {
            log.error("Can't read data from file. " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
