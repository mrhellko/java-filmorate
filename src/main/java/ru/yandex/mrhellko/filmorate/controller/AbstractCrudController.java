package ru.yandex.mrhellko.filmorate.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.yandex.mrhellko.filmorate.model.LongIdEntity;
import ru.yandex.mrhellko.filmorate.system.IdProvider;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class AbstractCrudController<T extends LongIdEntity> {
    protected final Map<Long, T> repository = new HashMap<>();
    protected final IdProvider idProvider = new IdProvider();

    @PostMapping()
    public void create(@Valid @RequestBody T entity) {
        entity.setId(idProvider.next());
        repository.put(entity.getId(), entity);
        log.info("Сущность {} добавлена с id={}", entity.getClass(), entity.getId());
    }

    @PutMapping()
    public void update(@Valid @RequestBody T entity) {
        if (entity.getId() == null) {
            entity.setId(idProvider.next());
        }
        repository.put(entity.getId(), entity);
        log.info("Сущность {} с id={} изменена", entity.getClass(), entity.getId());
    }

    @GetMapping()
    public Collection<T> list() {
        return repository.values();
    }
}
