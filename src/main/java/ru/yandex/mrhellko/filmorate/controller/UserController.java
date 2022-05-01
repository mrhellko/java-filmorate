package ru.yandex.mrhellko.filmorate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.mrhellko.filmorate.model.User;
import ru.yandex.mrhellko.filmorate.service.UserService;
import ru.yandex.mrhellko.filmorate.system.IdProvider;
import ru.yandex.mrhellko.filmorate.system.crud.controller.AbstractCrudController;

@RestController
@RequestMapping(value = "/users")
public class UserController extends AbstractCrudController<User, UserService> {

    private final UserService userService;
    private final IdProvider idProvider;

    @Autowired
    public UserController(UserService userService, IdProvider idProvider) {
        this.userService = userService;
        this.idProvider = idProvider;
    }

    @Override
    protected UserService getService() {
        return userService;
    }

    @Override
    protected IdProvider getIdProvider() {
        return idProvider;
    }
}
