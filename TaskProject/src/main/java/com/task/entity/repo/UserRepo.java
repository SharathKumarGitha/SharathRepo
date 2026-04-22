package com.task.entity.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.Users;
@Repository
public interface UserRepo  extends JpaRepository<Users, Long>{

	Optional<Users> findByEmail(String email);

}
