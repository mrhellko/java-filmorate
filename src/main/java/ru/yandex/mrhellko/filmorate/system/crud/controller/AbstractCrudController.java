package ru.yandex.mrhellko.filmorate.system.crud.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.yandex.mrhellko.filmorate.model.LongIdEntity;
import ru.yandex.mrhellko.filmorate.system.crud.service.AbstractCrudService;
import ru.yandex.mrhellko.filmorate.system.crud.service.CrudService;
import ru.yandex.mrhellko.filmorate.system.IdProvider;

import java.util.Collection;

@Slf4j
public abstract class AbstractCrudController<T extends LongIdEntity, S extends AbstractCrudService<T, ?>> {

    protected abstract S getService();
    protected abstract IdProvider getIdProvider();

    @PostMapping()
    public void create(@Valid @RequestBody T entity) {
        entity.setId(getIdProvider().next());
        getService().save(entity);
        log.info("Сущность {} добавлена с id={}", entity.getClass(), entity.getId());
    }

    @PutMapping()
    public void update(@Valid @RequestBody T entity) {
        if (entity.getId() == null) {
            entity.setId(getIdProvider().next());
        }
        getService().save(entity);
        log.info("Сущность {} с id={} изменена", entity.getClass(), entity.getId());
    }

    @GetMapping()
    public Collection<T> list() {
        return getService().getAll();
    }
}
