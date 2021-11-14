package com.microsystem.UserService.Controllers;

import javax.ws.rs.core.MediaType;

import com.microsystem.UserService.Request.RegisterProviderForm;
import com.microsystem.UserService.Request.RegisterTouristForm;
import com.microsystem.UserService.Exceptions.UserNotFoundException;
import com.microsystem.UserService.Model.ProviderDTO;
import com.microsystem.UserService.Model.TouristDTO;
import com.microsystem.UserService.Model.User;
import com.microsystem.UserService.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthController authController;

    @Autowired
    Environment environment;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }



    @RequestMapping(
        value = "/status",
        produces = MediaType.APPLICATION_JSON
    )
    public String getStatus(){
        String port = environment.getProperty("local.server.port");
        return "Server is up on port " + port;
    }

    @GetMapping(value = "/{username}")
    public User getUserByUsername(@PathVariable String username){
        User user = userRepository.findByUsername(username);
        if(user==null){
            throw new UserNotFoundException(username);
        }
        return user;
    }

    @PostMapping(value = "/tourists")
    public TouristDTO registerTourist(@RequestBody RegisterTouristForm form){
        User user = new User(0,form.getUsername(), form.getPassword());
        String password = authController.encodePassword(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
        TouristDTO touristRequest = new TouristDTO(form.getUsername(), form.getName(), form.getAge(), form.getPhoto(), form.getDescription());
        // Tourist server conection
        TouristDTO touristResponse = restTemplate.postForObject("http://tourists-service/tourists/", touristRequest, TouristDTO.class);
        return touristResponse;
    }

    @DeleteMapping(value = "/tourists/{username}")
    public void deleteTourist(@PathVariable String username){
        User user = getUserByUsername(username);
        userRepository.delete(user);
        restTemplate.delete("http://tourists-service/tourists/{username}", username);
    }


    @PostMapping(value = "/providers")
    public ProviderDTO registerProvider(@RequestBody RegisterProviderForm form){
        User user = new User(0,form.getUsername(), form.getPassword());
        String password = authController.encodePassword(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
        ProviderDTO providerRequest = new ProviderDTO(form.getUsername(), form.getName(), form.getAge(), form.getPhoto(), form.getPhoneNumber(), form.getWebPage(), form.getSocialNetwork(), form.getDescription());
        // Tourist server conection
        ProviderDTO providerResponse = restTemplate.postForObject("http://providers-service/providers/", providerRequest, ProviderDTO.class);
        return providerResponse;
    }

    @DeleteMapping(value = "/providers/{username}")
    public void deleteProvider(@PathVariable String username){
        User user = getUserByUsername(username);
        userRepository.delete(user);
        restTemplate.delete("http://providers-service/providers/{username}", username);
    }


}
