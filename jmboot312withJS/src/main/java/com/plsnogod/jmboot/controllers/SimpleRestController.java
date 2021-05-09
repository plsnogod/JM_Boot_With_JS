package com.plsnogod.jmboot.controllers;

import com.plsnogod.jmboot.model.User;
import com.plsnogod.jmboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class SimpleRestController {

    @Autowired
    UserService userService;

    @GetMapping("/all_users")
    public List<User> list_users () {
        return userService.showAllUsers();
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "/new_user")
    public User addUser(@RequestBody User user){
        User newUser =user;
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userService.addUser(newUser);
    }
    @PutMapping(value = "/edit")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable long id){
         userService.deleteUser(id);
    }
}
