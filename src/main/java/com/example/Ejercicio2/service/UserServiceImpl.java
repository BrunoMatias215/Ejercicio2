package com.example.Ejercicio2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ejercicio2.dao.UserDAO;
import com.example.Ejercicio2.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public List<User> findAll() {
		
		List<User> listUsers= userDAO.findAll();
		
		return listUsers;
		
	}

	public User findById(int id) {
		
		User user = userDAO.findById(id);
		
		return user;
		
	}

	public void save(User user) {
		
		userDAO.save(user);

	}

	public void deleteById(int id) {
		
		userDAO.deleteById(id);
		
	}

}