package ru.yandex.mrhellko.filmorate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.mrhellko.filmorate.model.Film;
import ru.yandex.mrhellko.filmorate.model.User;
import ru.yandex.mrhellko.filmorate.repository.film.FilmRepository;
import ru.yandex.mrhellko.filmorate.system.crud.service.AbstractCrudService;

import java.util.Comparator;
import java.util.List;

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

    public void like(long userId, long filmId) {
        Film film = filmRepository.findById(filmId);
        film.getWhoLiked().add(userId);
        filmRepository.save(film);
    }

    public void unlike(long userId, long filmId) {
        Film film = filmRepository.findById(filmId);
        film.getWhoLiked().remove(userId);
        filmRepository.save(film);
    }

    public List<Film> top(Integer count) {
        if (count == null) {
            count = 10;
        }
        return filmRepository.getAll().stream()
                .sorted(Comparator.comparingInt(film -> film.getWhoLiked().size()))
                .toList()
                .subList(0, count);
    }
}