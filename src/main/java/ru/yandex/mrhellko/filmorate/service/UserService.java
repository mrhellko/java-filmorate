package ru.yandex.mrhellko.filmorate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.mrhellko.filmorate.model.User;
import ru.yandex.mrhellko.filmorate.repository.user.UserRepository;
import ru.yandex.mrhellko.filmorate.system.crud.service.AbstractCrudService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    void addFriend(long userId1, long userId2) {
        User user1 = userRepository.findById(userId1);
        User user2 = userRepository.findById(userId2);
        user1.getFriends().add(user2.getId());
        user2.getFriends().add(user1.getId());
        userRepository.save(user1);
        userRepository.save(user2);
    }

    void deleteFriend(long userId1, long userId2) {
        User user1 = userRepository.findById(userId1);
        User user2 = userRepository.findById(userId2);
        user1.getFriends().remove(user2.getId());
        user2.getFriends().remove(user1.getId());
        userRepository.save(user1);
        userRepository.save(user2);
    }

    List<User> intersectFriends(long userId1, long userId2) {
        User user1 = userRepository.findById(userId1);
        User user2 = userRepository.findById(userId2);
        Set<Long> intersection = new HashSet<>(user1.getFriends());
        intersection.retainAll(user2.getFriends());
        return intersection.stream().map(userRepository::findById).toList();
    }

}