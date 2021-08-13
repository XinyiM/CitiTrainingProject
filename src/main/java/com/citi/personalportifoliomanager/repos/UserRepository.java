package com.citi.personalportifoliomanager.repos;

import com.citi.personalportifoliomanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, Integer> {

}
