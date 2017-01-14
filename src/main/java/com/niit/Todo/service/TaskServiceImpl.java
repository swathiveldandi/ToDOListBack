package com.niit.Todo.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.niit.Todo.dao.TaskDAO;
import com.niit.Todo.model.Task;



@Service
public class TaskServiceImpl implements Taskservice{
	
	@Autowired
	private TaskDAO taskDAO;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
@Override
public boolean saveOrUpdate(Task task) {
		
	 return taskDAO.saveOrUpdate(task);
}

@Transactional
@SuppressWarnings("deprecation")
public List<Task> list() {
	Criteria c=sessionFactory.getCurrentSession().createCriteria(Task.class);
	@SuppressWarnings("unchecked")
	List<Task> list=c.list();
	return list;
}
public String  getAllTasks() 
{
	List<Task> list=taskDAO.getTasks();
	Gson gson=new Gson();
	String data=gson.toJson(list);
	return data;
}
public Task editTask(int taskid)
{
	 return taskDAO.getTask(taskid);
}
@Override
public boolean deleteTask(int taskid) 
{
	Task task= taskDAO.getTask(taskid);
	return false;

	}
}
	
	
/*@Override
public boolean delete(Task task) {	
	
		return taskDAO.delete(task);
	}
*/	
	
