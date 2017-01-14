package com.niit.Todo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Todo.model.Task;

@SuppressWarnings("deprecation")
@Repository
public class TaskDAOImpl implements TaskDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	public TaskDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	public boolean saveOrUpdate(Task task) {
		try {
			Session session=sessionFactory.openSession();	
			Transaction tx=session.beginTransaction();
			session.saveOrUpdate(task);
			tx.commit();
			/*sessionFactory.getCurrentSession().saveOrUpdate(task);*/
			System.out.println("save");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public List<Task> getTasks() {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Task.class);
		List<Task> list=c.list();
		return list;
	}

	/*Delete single Task object*/
	@Transactional
	public boolean deleteTask(Task task) {
		sessionFactory.getCurrentSession().delete(task);
		return false;
	}

	/*Fetch single Task object based on Taskid*/
	@Transactional
	public Task getTask(int taskid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Task.class);
		c.add(Restrictions.eq("id", taskid));
		Task task=(Task) c.uniqueResult();
		return task;
	}

}
