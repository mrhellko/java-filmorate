package ru.yandex.mrhellko.filmorate.system.crud.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;
import ru.yandex.mrhellko.filmorate.model.LongIdEntity;
import ru.yandex.mrhellko.filmorate.model.exception.NotFoundException;
import ru.yandex.mrhellko.filmorate.system.crud.service.AbstractCrudService;
import ru.yandex.mrhellko.filmorate.system.crud.service.CrudService;
import ru.yandex.mrhellko.filmorate.system.IdProvider;

import java.util.Collection;
import java.util.Map;

@Slf4j
public abstract class AbstractCrudController<T extends LongIdEntity, S extends AbstractCrudService<T, ?>> {

    protected abstract S getService();

    protected abstract IdProvider getIdProvider();

    @PostMapping()
    public T create(@Valid @RequestBody T entity) {
        entity.setId(getIdProvider().next());
        getService().save(entity);
        log.info("Сущность {} добавлена с id={}", entity.getClass(), entity.getId());
        return entity;
    }

    @PutMapping()
    public T update(@Valid @RequestBody T entity) {
        //Проверим есть ли такой id
        getService().getEntityById(entity.getId());
        getService().save(entity);
        log.info("Сущность {} с id={} изменена", entity.getClass(), entity.getId());
        return entity;
    }

    @GetMapping()
    public Collection<T> list() {
        return getService().getAll();
    }

    @GetMapping("/{id}")
    public T getOne(@PathVariable Long id) {
        return getService().getEntityById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        getService().delete(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleHappinessOverflow(NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
