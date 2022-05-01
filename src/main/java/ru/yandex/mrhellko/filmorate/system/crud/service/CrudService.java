package ru.yandex.mrhellko.filmorate.system.crud.service;

import ru.yandex.mrhellko.filmorate.model.LongIdEntity;

import java.util.Collection;

public interface CrudService<T extends LongIdEntity> {
    void save(T entity);

    Collection<T> getAll();
}
