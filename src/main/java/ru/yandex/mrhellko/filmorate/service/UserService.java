package ru.yandex.mrhellko.filmorate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.mrhellko.filmorate.model.User;
import ru.yandex.mrhellko.filmorate.repository.user.UserRepository;
import ru.yandex.mrhellko.filmorate.system.crud.service.AbstractCrudService;

@Service
public class UserService extends AbstractCrudService<User, UserRepository> {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected UserRepository getRepository() {
        return userRepository;
    }

}
