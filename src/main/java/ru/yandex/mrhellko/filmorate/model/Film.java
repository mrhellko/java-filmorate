package ru.yandex.mrhellko.filmorate.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import ru.yandex.mrhellko.filmorate.system.validation.After;

import java.time.LocalDate;

@Data
public class Film {
    private Long id;

    @NotBlank
    private String name;

    @Size(max = 200)
    private String description;

    @After(value = "1895-12-27", message = "Должно быть не раньше 1895-12-28")
    private LocalDate releaseDate;

    @Positive
    private long duration;

    public Film(String name, String description, LocalDate releaseDate, long duration) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }
}
