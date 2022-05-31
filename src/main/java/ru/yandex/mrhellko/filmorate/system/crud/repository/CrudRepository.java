package ru.yandex.mrhellko.filmorate.system.crud.repository;

import ru.yandex.mrhellko.filmorate.model.LongIdEntity;

import java.util.Collection;
import java.util.List;

public interface CrudRepository<T extends LongIdEntity> {
    T findById(long id);

    List<T> getAll();

    void save(T entity);

    void delete(long id);
}
