package ru.yandex.mrhellko.filmorate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.mrhellko.filmorate.model.Film;
import ru.yandex.mrhellko.filmorate.repository.film.FilmRepository;
import ru.yandex.mrhellko.filmorate.system.crud.service.AbstractCrudService;

@Service
public class FilmService extends AbstractCrudService<Film, FilmRepository> {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    protected FilmRepository getRepository() {
        return filmRepository;
    }
}