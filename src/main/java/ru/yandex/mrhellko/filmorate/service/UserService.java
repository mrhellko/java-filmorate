package ru.yandex.mrhellko.filmorate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.mrhellko.filmorate.model.User;
import ru.yandex.mrhellko.filmorate.repository.user.UserRepository;
import ru.yandex.mrhellko.filmorate.system.crud.service.AbstractCrudService;
import ru.yandex.mrhellko.filmorate.system.crud.service.CrudService;

@Service
public class UserService extends AbstractCrudService<User, UserRepository> implements CrudService<User> {

    private final UserRepository userStorage;

    @Autowired
    public UserService(UserRepository filmStorage) {
        this.userStorage = filmStorage;
    }

    @Override
    protected UserRepository getRepository() {
        return userStorage;
    }

}
