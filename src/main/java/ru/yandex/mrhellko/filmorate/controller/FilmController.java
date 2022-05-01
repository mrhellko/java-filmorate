package ru.yandex.mrhellko.filmorate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.mrhellko.filmorate.model.Film;
import ru.yandex.mrhellko.filmorate.service.FilmService;
import ru.yandex.mrhellko.filmorate.system.IdProvider;
import ru.yandex.mrhellko.filmorate.system.crud.controller.AbstractCrudController;

@RestController
@RequestMapping(value = "/films")
public class FilmController extends AbstractCrudController<Film, FilmService> {

    private final FilmService filmService;
    private final IdProvider idProvider;

    @Autowired
    public FilmController(FilmService filmService, IdProvider idProvider) {
        this.filmService = filmService;
        this.idProvider = idProvider;
    }

    @Override
    protected FilmService getService() {
        return filmService;
    }

    @Override
    protected IdProvider getIdProvider() {
        return idProvider;
    }
}
