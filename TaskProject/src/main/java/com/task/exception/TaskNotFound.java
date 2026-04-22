package com.task.exception;

public class TaskNotFound extends RuntimeException {

	private String message;

	public TaskNotFound(String message) {
		super(message);
		this.message = message;
	}

}
