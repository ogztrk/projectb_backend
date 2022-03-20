package com.badibul.backend.service;

import com.badibul.backend.entity.User;
import com.badibul.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){

        return  userRepository.findAll();

    }

    public User getOneUser(Long id) {
        return  userRepository.findById(id).orElseThrow(null);
    }
}
