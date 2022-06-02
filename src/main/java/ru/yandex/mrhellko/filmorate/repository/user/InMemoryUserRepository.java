package ru.yandex.mrhellko.filmorate.repository.user;

import org.springframework.stereotype.Component;
import ru.yandex.mrhellko.filmorate.model.User;
import ru.yandex.mrhellko.filmorate.system.crud.repository.AbstractInMemoryCrudRepository;

import java.util.HashMap;
import java.util.HashSet;

@Component
public class InMemoryUserRepository extends AbstractInMemoryCrudRepository<User> implements UserRepository {
    public InMemoryUserRepository() {
        this.storage = new HashMap<>();
    }

    @Override
    public void save(User entity) {
        if (entity.getFriends() == null) {
            entity.setFriends(new HashSet<>());
        }
        super.save(entity);
    }
}
