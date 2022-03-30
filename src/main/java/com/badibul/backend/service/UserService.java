package com.badibul.backend.service;

import com.badibul.backend.entity.User;
import com.badibul.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public User createNew(User NewUser){
        return  userRepository.save(NewUser);
    }


    public  User updateUser(Long id, User newUser) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setName(newUser.getName());
            foundUser.setEmail(newUser.getEmail());
            userRepository.save(foundUser);
            return foundUser;
        }else{
            return null;
        }

    }

    public  void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}

