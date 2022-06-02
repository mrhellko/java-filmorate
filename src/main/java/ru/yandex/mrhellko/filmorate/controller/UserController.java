package ru.yandex.mrhellko.filmorate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.mrhellko.filmorate.model.user.User;
import ru.yandex.mrhellko.filmorate.service.UserService;
import ru.yandex.mrhellko.filmorate.system.IdProvider;
import ru.yandex.mrhellko.filmorate.system.crud.controller.AbstractCrudController;

import java.util.List;

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

    @PutMapping("/{id}/friends/{friendId}")
    public void addFriend(@PathVariable Long id, @PathVariable Long friendId) {
        userService.addFriend(id, friendId);
    }

    @DeleteMapping("/{id}/friends/{friendId}")
    public void deleteFriend(@PathVariable Long id, @PathVariable Long friendId) {
        userService.deleteFriend(id, friendId);
    }

    @GetMapping("/{id}/friends")
    public List<User> userFriends(@PathVariable Long id) {
        return userService.userFriends(id);
    }

    @GetMapping("/{id}/friends/common/{otherId}")
    public List<User> commonFriends(@PathVariable Long id, @PathVariable Long otherId) {
        return userService.intersectFriends(id, otherId);
    }
}
