package com.badibul.backend.controller;

import com.badibul.backend.entity.User;
import com.badibul.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAll(){
        return  userService.getAll();
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable Long id){
        //Custom Exception ekle
        return userService.getOneUser(id);
    }
    @PostMapping
    public User createNewUser(@RequestBody User NewUser){
        return  userService.createNew(NewUser);
    }

    @PutMapping("/{id}")

    public  User updateOneUser(@PathVariable Long id,@RequestBody User newUser) {
        return  userService.updateUser(id, newUser);
    }
    @DeleteMapping("/{id}")
    public  void deleteOneUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
