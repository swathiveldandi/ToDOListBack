package com.niit.Todo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Todo.dao.TaskDAO;
import com.niit.Todo.model.Task;
import com.niit.Todo.service.Taskservice;

@RestController
public class TaskController {
	
	@Autowired 
	private Taskservice taskservice;
	@Autowired 
	private TaskDAO taskDAO;
	
	@PostMapping(value="/createTask")
	
	public ResponseEntity<Task> createTask(@RequestBody Task task,HttpSession session)
	{
		//int id=(Integer) session.getAttribute("id");
		taskservice.saveOrUpdate(task);
		return new ResponseEntity<Task>(task,HttpStatus.OK);
	}
	
	@GetMapping("/getAllTasks")
	public String getAllTasks()
	{
		return taskservice.getAllTasks();
	}	
	
	@DeleteMapping("/deleteTask/{taskid}")
	public void deleteTask(@PathVariable("taskid") int taskid)
	{
		taskservice.deleteTask(taskid);
	}
	
	@GetMapping("/editTask/{taskid}")
	public ResponseEntity<Task> editTask(@PathVariable("taskid") int taskid)
	{
		Task task=taskservice.editTask(taskid);
  		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
}
