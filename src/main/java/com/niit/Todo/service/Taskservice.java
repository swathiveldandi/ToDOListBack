package com.niit.Todo.service;

import java.util.List;

import com.niit.Todo.model.Task;

public interface Taskservice {
	
	/*public void createTask(Task task,HttpSession session);*/
	
	public boolean saveOrUpdate(Task task);
	/*public boolean delete( Task task);*/
	/*public List<Task> getSingleTask(int taskid);*/
	public String getAllTasks();
	public Task editTask(int taskid);

	
	public boolean deleteTask(int taskid);
}
	
