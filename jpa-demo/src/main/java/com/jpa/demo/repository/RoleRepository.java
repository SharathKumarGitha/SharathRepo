package com.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.demo.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	
}
