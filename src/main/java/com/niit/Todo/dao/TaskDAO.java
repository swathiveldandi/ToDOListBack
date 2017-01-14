package com.niit.Todo.dao;

import java.util.List;

import com.niit.Todo.model.Task;

public interface TaskDAO {
	
	public boolean saveOrUpdate(Task task);
	
	/*public Task gettask(int id);
	public List<Task> list();*/
public List<Task> getTasks();
	
	
	public boolean deleteTask(Task task);
	
	
	public Task getTask(int taskid);

	

	
}
