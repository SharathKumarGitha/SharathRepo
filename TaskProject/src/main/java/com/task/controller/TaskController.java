package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.dto.TaskDto;
import com.task.entity.service.TaskService;

@RestController
@RequestMapping("/api/tc")
public class TaskController {

	@Autowired
	private TaskService service;

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/{userid}/tasks")
	@ResponseBody
	public ResponseEntity<TaskDto> saveTask(@PathVariable("userid") Long id, @RequestBody TaskDto dto) {
		return new ResponseEntity<>(service.saveTask(id, dto), HttpStatus.CREATED);
	}

	@GetMapping("/{userid}/tasks")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<TaskDto>> getTaskWithUserId(@PathVariable("userid") Long id) {
		return new ResponseEntity<>(service.getAllTaskWithUid(id), HttpStatus.OK);

	}

	@GetMapping("/{userid}/tasks/{taskid}")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<TaskDto> getTaskWithUserIdAndTaskId(@PathVariable("userid") Long id,
			@PathVariable("taskid") Long taskid) {
		return new ResponseEntity<>

		(service.getSpecificTaskWithUIdAndTid(id, taskid), HttpStatus.OK);

	}

	@DeleteMapping("/{userid}/tasks/{taskid}")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteTask(@PathVariable("userid") Long id, @PathVariable("taskid") Long taskid) {
		return new ResponseEntity<>

		(service.deleteTask(id, taskid), HttpStatus.OK);

	}

	@GetMapping("/debug")
	public String debug(Authentication authentication) {
		return authentication.getAuthorities().toString();
	}

}
