package ru.yandex.mrhellko.filmorate.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.mrhellko.filmorate.model.User;

import java.util.Collection;
@RestController
@RequestMapping(value = "/users")
public class UserController extends AbstractCrudController<User> {

    @Override
    @GetMapping()
    public Collection<User> list() {
        return repository.values().stream().peek(user -> {
            if (user.getName() == null || user.getName().isBlank()) {
                user.setName(user.getLogin());
            }
        }).toList();
    }
}
