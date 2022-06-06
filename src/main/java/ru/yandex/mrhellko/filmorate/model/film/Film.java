package ru.yandex.mrhellko.filmorate.model.film;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import ru.yandex.mrhellko.filmorate.model.LongIdEntity;
import ru.yandex.mrhellko.filmorate.system.validation.After;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
public class Film implements LongIdEntity {

    private Long id;

    @NotBlank
    private String name;

    @Size(max = 200)
    private String description;

    @After(value = "1895-12-27", message = "Должно быть не раньше 1895-12-28")
    private LocalDate releaseDate;

    @Positive
    private long duration;

    private Set<Long> whoLiked;
}
