package com.ilyabubnov.webquest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;


//Чтобы не забыть:
//@JsonIdentityInfo используется для указания того, что идентификатор объекта должен использоваться при
//сериализации/десериализации значений — например, для решения проблем типа бесконечной рекурсии.
//https://nsergey.com/jackson-annotations/
//https://sky.pro/media/beskonechnaya-rekursiya-s-jackson-json-i-hibernate-jpa/
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="value", scope=Entity.class)
public class Entity {
    private int value;
    @NonNull
    private GameStatus gameStatus;
    @NonNull
    private String phrase;
    @NonNull
    private String choice;
    private Entity firstOpportunity;
    private Entity secondOpportunity;

    private Entity() {
    }
}
