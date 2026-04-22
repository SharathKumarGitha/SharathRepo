package com.task.entity.service;

import java.util.List;

import com.task.dto.TaskDto;

public interface TaskService {

	public TaskDto saveTask(Long id, TaskDto dto);

	public List<TaskDto> getAllTaskWithUid(Long id);
	
	
	public TaskDto getSpecificTaskWithUIdAndTid(Long uid ,Long tid);
	
	public String deleteTask(Long uid ,Long tid);

}
