package ru.yandex.mrhellko.filmorate.repository.user;

import org.springframework.stereotype.Component;
import ru.yandex.mrhellko.filmorate.model.User;
import ru.yandex.mrhellko.filmorate.system.crud.repository.AbstractInMemoryCrudRepository;

import java.util.HashMap;

@Component
public class InMemoryUserRepository extends AbstractInMemoryCrudRepository<User> implements UserRepository {
    public InMemoryUserRepository() {
        this.storage = new HashMap<>();
    }
}
