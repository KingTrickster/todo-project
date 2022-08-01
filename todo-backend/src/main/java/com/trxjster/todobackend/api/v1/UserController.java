package com.trxjster.todobackend.api.v1;

import com.trxjster.todobackend.model.User;
import com.trxjster.todobackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/Users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable String userId, @RequestBody User user){
        userService.updateUser(user);
    }

}
