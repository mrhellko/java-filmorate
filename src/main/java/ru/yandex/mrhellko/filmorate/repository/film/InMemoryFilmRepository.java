package ru.yandex.mrhellko.filmorate.repository.film;

import org.springframework.stereotype.Component;
import ru.yandex.mrhellko.filmorate.model.film.Film;
import ru.yandex.mrhellko.filmorate.system.crud.repository.AbstractInMemoryCrudRepository;

import java.util.HashMap;
import java.util.HashSet;

@Component
public class InMemoryFilmRepository extends AbstractInMemoryCrudRepository<Film> implements FilmRepository {
    public InMemoryFilmRepository() {
        this.storage = new HashMap<>();
    }

    @Override
    public void save(Film entity) {
        if (entity.getWhoLiked() == null) {
            entity.setWhoLiked(new HashSet<>());
        }
        super.save(entity);
    }
}
