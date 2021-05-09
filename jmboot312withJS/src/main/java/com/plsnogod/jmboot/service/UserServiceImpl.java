package com.plsnogod.jmboot.service;


import com.plsnogod.jmboot.model.User;
import com.plsnogod.jmboot.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public User getUserById(long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    @Transactional
    public User getUserByName(String name) {
        return userRepository.getUserByName(name);
    }
}
