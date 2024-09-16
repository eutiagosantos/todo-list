package com.example.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.todolist.entity.User;
import com.example.todolist.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> createUsers(User user) {
        userRepository.save(user);
        return listUsers();
    }

    public List<User> listUsers() {
        Sort sort = Sort.by("name").ascending();
        return userRepository.findAll(sort);
    }

    public List<User> updateUsers(User user) {
        userRepository.save(user);
        return listUsers();
    }

    public List<User> deleteUser(Long id) {
        userRepository.deleteById(id);
        return listUsers();
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findUserByName(String name) {
        return userRepository.findByName(name);
    }
}