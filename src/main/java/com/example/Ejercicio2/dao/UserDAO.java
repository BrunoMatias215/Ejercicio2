package com.example.Ejercicio2.dao;

import java.util.List;

import com.example.Ejercicio2.entity.User;

public interface UserDAO {
	
	public List<User> findAll();
	
	public User findById(int id);
	
	public void save(User user);
	
	public void deleteById(int id);
	
}