package com.trxjster.todobackend.service;

import com.trxjster.todobackend.model.User;
import com.trxjster.todobackend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User create(User user){
        return userRepo.save(user);
    }

    public User getUserById(String id){
        return userRepo.findUserById(id).orElseThrow(() -> new IllegalStateException("User with id " + id + " not found"));
    }

    public User updateUser( User user){
        return userRepo.save(user);
    }


}
