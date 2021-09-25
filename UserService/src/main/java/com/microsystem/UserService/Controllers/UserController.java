package com.microsystem.UserService.Controllers;

import com.microsystem.UserService.Model.User;
import com.microsystem.UserService.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthController authController;

    @GetMapping(value = "/{username}")
    public User getUserByUsername(@PathVariable String username){
        return userRepository.findByUsername(username);
    }

    
    @PostMapping
    public User registerUser(@RequestBody User user){
        String password = authController.encodePassword(user.getPassword());
        user.setPassword(password);
        return userRepository.save(user);
    }


}
