package ru.yandex.mrhellko.filmorate.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.mrhellko.filmorate.model.User;
import ru.yandex.mrhellko.filmorate.system.IdProvider;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
@Slf4j
public class UserController {
    private final Map<Long, User> repository = new HashMap<>();
    private final IdProvider idProvider = new IdProvider();

    @PostMapping()
    public void createUser(@Valid @RequestBody User user) {
        user.setId(idProvider.next());
        repository.put(user.getId(), user);
        log.info("Новый фильм добавлен, его id={}", user.getId());
    }

    @PutMapping()
    public void updateUser(@Valid @RequestBody User user) {
        if (user.getId() == null) {
            user.setId(idProvider.next());
        }
        repository.put(user.getId(), user);
        log.info("Фильм с id={} изменен", user.getId());
    }

    @GetMapping()
    public Collection<User> listUsers() {
        return repository.values().stream().peek(user -> {
            if (user.getName() == null || user.getName().isBlank()) {
                user.setName(user.getLogin());
            }
        }).toList();
    }
}
