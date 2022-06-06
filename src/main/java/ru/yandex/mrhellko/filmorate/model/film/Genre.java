package ru.yandex.mrhellko.filmorate.model.film;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.yandex.mrhellko.filmorate.model.LongIdEntity;

@Getter
@Setter
@AllArgsConstructor
public class Genre implements LongIdEntity {
    private Long id;
    private String name;
}
