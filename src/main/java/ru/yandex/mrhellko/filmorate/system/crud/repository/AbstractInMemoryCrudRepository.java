package ru.yandex.mrhellko.filmorate.system.crud.repository;

import ru.yandex.mrhellko.filmorate.model.LongIdEntity;
import ru.yandex.mrhellko.filmorate.model.exception.NotFoundException;

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
        T entity = storage.get(id);
        if (entity == null) {
            throw new NotFoundException("Не найдена сущность с id = " + id);
        }
        return storage.get(id);
    }

    @Override
    public void save(T entity) {
        storage.put(entity.getId(), entity);
    }

    @Override
    public void delete(long id) {
        T prevValue = storage.remove(id);
        if (prevValue == null) {
            throw new NotFoundException("Не найдена сущность с id = " + id);
        }
    }
}
