package ru.yandex.mrhellko.filmorate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.mrhellko.filmorate.model.Film;
import ru.yandex.mrhellko.filmorate.repository.film.FilmRepository;
import ru.yandex.mrhellko.filmorate.system.crud.service.AbstractCrudService;
import ru.yandex.mrhellko.filmorate.system.crud.service.CrudService;

@Service
public class FilmService extends AbstractCrudService<Film, FilmRepository> implements CrudService<Film> {

    private final FilmRepository filmStorage;

    @Autowired
    public FilmService(FilmRepository filmStorage) {
        this.filmStorage = filmStorage;
    }

    @Override
    protected FilmRepository getRepository() {
        return filmStorage;
    }
}