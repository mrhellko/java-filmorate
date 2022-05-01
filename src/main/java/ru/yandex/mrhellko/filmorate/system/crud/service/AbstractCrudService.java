package ru.yandex.mrhellko.filmorate.system.crud.service;

import ru.yandex.mrhellko.filmorate.model.LongIdEntity;
import ru.yandex.mrhellko.filmorate.system.crud.repository.CrudRepository;

import java.util.Collection;

public abstract class AbstractCrudService<T extends LongIdEntity, R extends CrudRepository<T>> implements CrudService<T> {

    protected abstract R getRepository();

    @Override
    public void save(T entity) {
        getRepository().save(entity);
    }

    @Override
    public Collection<T> getAll() {
        return getRepository().getAll();
    }
}
