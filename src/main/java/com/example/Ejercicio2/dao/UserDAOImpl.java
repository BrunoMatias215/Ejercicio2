package com.example.Ejercicio2.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Ejercicio2.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private EntityManager entityManager;
	
	public List<User> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);

		Query<User> theQuery = currentSession.createQuery("from User", User.class);
		
		List<User> users = theQuery.getResultList();
		
		return users;

	}

	public User findById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);

		User user = currentSession.get(User.class, id);
		
		return user;
		
	}

	public void save(User user) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(user);	
		
	}

	public void deleteById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);

		Query<User> theQuery = currentSession.createQuery("delete from User where id=:idUser");
		
		theQuery.setParameter("idUser", id);
		
		theQuery.executeUpdate();
	
	}
	
}