package com.task.entity.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dto.TaskDto;
import com.task.entity.Task;
import com.task.entity.Users;
import com.task.entity.repo.TaskRepo;
import com.task.entity.repo.UserRepo;
import com.task.entity.service.TaskService;
import com.task.exception.ApiException;
import com.task.exception.TaskNotFound;
import com.task.exception.UserNotFound;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepo repo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public TaskDto saveTask(Long userid, TaskDto dto) {

		Users user = userRepo.findById(userid)
				.orElseThrow(() -> new UserNotFound(String.format("user not found with %d id", userid)));

		Task task = mapper.map(dto, Task.class);

		task.setUsers(user);

		return mapper.map(repo.save(task), TaskDto.class);

	}

	@Override
	public List<TaskDto> getAllTaskWithUid(Long id) {

		Users user = userRepo.findById(id)
				.orElseThrow(() -> new UserNotFound(String.format("User not found with id %d", id)));

		List<Task> getAllTaskWithUserId = repo.findByUsersId(user.getId());

		return getAllTaskWithUserId.stream().map(task -> mapper.map(task, TaskDto.class)).collect(Collectors.toList());
	}

	@Override
	public TaskDto getSpecificTaskWithUIdAndTid(Long uid, Long tid) {

		Users user = userRepo.findById(uid)
				.orElseThrow(() -> new UserNotFound(String.format("User not found with id %d", uid)));

		Task task = repo.findById(tid)
				.orElseThrow(() -> new TaskNotFound(String.format("task not found with id %d", tid)));

		if (user.getId() != task.getUsers().getId()) {
			throw new ApiException(String.format("task id %d not belongs to user id %d ", tid, uid));

		}

		return mapper.map(task, TaskDto.class);
	}

	@Override
	public String deleteTask(Long uid, Long tid) {

		Users user = userRepo.findById(uid)
				.orElseThrow(() -> new UserNotFound(String.format("User not found with id %d", uid)));

		Task task = repo.findById(tid)
				.orElseThrow(() -> new TaskNotFound(String.format("task not found with id %d", tid)));

		if (user.getId() != task.getUsers().getId()) {
			throw new ApiException(String.format("task id %d not belongs to user id %d ", tid, uid));

		}

		repo.deleteById(tid);

		return "task deleted successfully";
	}

}
