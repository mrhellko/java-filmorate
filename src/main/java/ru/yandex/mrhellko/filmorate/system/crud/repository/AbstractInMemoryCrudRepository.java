package ru.yandex.mrhellko.filmorate.system.crud.repository;

import ru.yandex.mrhellko.filmorate.model.LongIdEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractInMemoryCrudRepository<T extends LongIdEntity> implements CrudRepository<T> {
    protected Map<Long, T> storage;

    @Override
    public List<T> getAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public T findById(long id) {
        return storage.get(id);
    }

    @Override
    public void save(T entity) {
        storage.put(entity.getId(), entity);
    }

    @Override
    public void delete(long id) {
        storage.remove(id);
    }
}
