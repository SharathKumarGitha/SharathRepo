package com.task.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

	public List<Task> findByUsersId(Long userid);

}
