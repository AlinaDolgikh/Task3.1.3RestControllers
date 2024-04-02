package ru.itmentor.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.exception_handing.NoSuchUserException;
import ru.itmentor.spring.boot_security.demo.exception_handing.UserIncorrectData;
import ru.itmentor.spring.boot_security.demo.servise.UserService;
import ru.itmentor.spring.boot_security.demo.models.User;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    private final UserService userService;

    @Autowired
    public MyRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> showAllUsers() {
        List<User> users = userService.findAllUsers();
        return users;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        User user = userService.findUserById(id);
        if (user.getId() == null) {
            throw new NoSuchUserException("There is no user with Id = " + id + " in Database");
        }
        return user;
    }
    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        System.out.println("delete");
        User user = userService.findUserById(id);
        if (user == null) {
            throw new NoSuchUserException("There is no user with Id = " + id + " in Database");
        }
        userService.deleteUser(id);
        return "User with Id = " + id + " was deleted";
    }
}
