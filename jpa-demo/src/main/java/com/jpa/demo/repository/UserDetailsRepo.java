package com.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.demo.entity.UserDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails, Long>{

}
