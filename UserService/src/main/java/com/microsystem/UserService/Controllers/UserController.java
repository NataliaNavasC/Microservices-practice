package com.microsystem.UserService.Controllers;

import com.microsystem.UserService.Model.User;
import com.microsystem.UserService.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "{username}")
    public User getUserByUsername(@PathVariable String username){
        return userRepository.findByUsername(username);
    }

    
    @PostMapping
    public User registerUser(@RequestBody User user){
        return userRepository.save(user);
    }


}
