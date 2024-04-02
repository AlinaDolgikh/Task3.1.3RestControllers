package ru.itmentor.spring.boot_security.demo.servise;

import ru.itmentor.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    boolean saveUser(User user);

    User updateUser(User user);

    User findUserById(Long id);

    void deleteUser(Long id);

    User getUserAndRoles(User user, String[] roles);
}
