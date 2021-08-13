package com.citi.personalportifoliomanager.rest;


import com.citi.personalportifoliomanager.entities.User;
import com.citi.personalportifoliomanager.repos.UserRepository;
import com.citi.personalportifoliomanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class TestController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Collection<User> getUsers(){
        return userService.findAllUser();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public User getCdById(@PathVariable("id") int id) {
        return userService.findUserById(id);
    }
}
