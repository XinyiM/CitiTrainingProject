package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    Collection<User> findAllUser();
    User findUserById(int id);
}
