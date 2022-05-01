package ru.yandex.mrhellko.filmorate.repository.film;

import org.springframework.stereotype.Component;
import ru.yandex.mrhellko.filmorate.model.Film;
import ru.yandex.mrhellko.filmorate.system.crud.repository.AbstractInMemoryCrudRepository;

import java.util.HashMap;

@Component
public class InMemoryFilmRepository extends AbstractInMemoryCrudRepository<Film> implements FilmRepository {
    public InMemoryFilmRepository() {
        this.storage = new HashMap<>();
    }
}
