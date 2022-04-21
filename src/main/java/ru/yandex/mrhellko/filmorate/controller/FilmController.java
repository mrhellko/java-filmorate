package ru.yandex.mrhellko.filmorate.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.mrhellko.filmorate.model.Film;
import ru.yandex.mrhellko.filmorate.system.IdProvider;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/films")
@Slf4j
public class FilmController {
    private final Map<Long, Film> repository = new HashMap<>();
    private final IdProvider idProvider = new IdProvider();

    @PostMapping()
    public void createFilm(@Valid @RequestBody Film film) {
        film.setId(idProvider.next());
        repository.put(film.getId(), film);
        log.info("Новый фильм добавлен, его id={}", film.getId());
    }

    @PutMapping()
    public void updateFilm(@Valid @RequestBody Film film) {
        if (film.getId() == null) {
            film.setId(idProvider.next());
        }
        repository.put(film.getId(), film);
        log.info("Фильм с id={} изменен", film.getId());
    }

    @GetMapping()
    public Collection<Film> listFilms() {
        return repository.values();
    }
}
