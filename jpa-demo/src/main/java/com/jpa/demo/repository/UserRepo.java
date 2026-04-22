package com.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.demo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
