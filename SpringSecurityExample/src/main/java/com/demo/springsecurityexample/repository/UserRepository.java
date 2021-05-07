package com.demo.springsecurityexample.repository;

import com.demo.springsecurityexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User u where u.userName = ?1")
    Optional<User> findUserByUserName(String userName);
}
