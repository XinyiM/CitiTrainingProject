package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.User;
import com.citi.personalportifoliomanager.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public Collection<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(int id) {
        Optional<User> user =  userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        else return null;
    }

}
