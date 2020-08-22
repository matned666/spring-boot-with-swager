package eu.mrndesign.matned.restSpringBootDemo.service;

import eu.mrndesign.matned.restSpringBootDemo.exceptions.UserNotFoundException;
import eu.mrndesign.matned.restSpringBootDemo.exceptions.WithRollbackException;
import eu.mrndesign.matned.restSpringBootDemo.model.User;
import eu.mrndesign.matned.restSpringBootDemo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> users;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> addAll(List<User> list){
        return this.userRepository.saveAll(list);
    }

    public User getUserByName(String name){
        return getUserByNameOptional(name)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    private Optional<User> getUserByNameOptional(String name){
        return userRepository.findUserByName(name);
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User add(User user) {
        return userRepository.save(user);
    }

    @Transactional(rollbackFor = WithRollbackException.class)
    public User addUserWithRollback(User user) throws WithRollbackException {
        User newUser = userRepository.save(user);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>   zapisałem");
        throw new WithRollbackException("No roll back");
    }

    public boolean deleteUser(Long id) {
        users.remove(users.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found")));
        return users.stream()
                .noneMatch(v->v.getId().equals(id));
    }
}
