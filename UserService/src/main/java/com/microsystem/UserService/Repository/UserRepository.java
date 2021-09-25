package com.microsystem.UserService.Repository;

import com.microsystem.UserService.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    
    public User findByUsername(String username);
}
