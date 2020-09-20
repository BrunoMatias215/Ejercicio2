package com.example.Ejercicio2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ejercicio2.entity.User;
import com.example.Ejercicio2.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/Ejercicio2")
@EnableSwagger2
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users") // Obtiene una notacion JSON de las tuplas de la tabla usuario
	public List<User> findAll(){
		
		return userService.findAll();
		
	}
	
	@GetMapping("/users/{userId}") // Obtiene un usuario por id
	public User getUser(@PathVariable int userId){
		
		User user = userService.findById(userId);
		
		if(user == null) {
			
			throw new RuntimeException("Usuario no encontrado -"+userId);
			
		}
		
		return user;
		
	}
	
	@PostMapping("/users") // Agrega a un usuario
	public User addUser(@RequestBody User user) {
		
		user.setId(0);
		
		userService.save(user);
		
		return user;
		
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) { // Actualiza a un usuario. NO LO HACE.
		
		userService.save(user);
		
		return user;
		
	}
	
	@DeleteMapping("users/{userId}") // Elimina a un usuario por id. NO LO HACE.
	public String deleteUser(@PathVariable int userId) {
		
		/* Intenté remover ciertas lineas de codigo y agregar otras para obtener un comportamiento distinto 
			y sigue sin funcionar
		 * La consola del entorno de desarrollo al momento de ejecucion continua mostrando una excepcion
		 * 
		 */
	
		User user = userService.findById(userId);
		
		if(user == null) {
			
			throw new RuntimeException("Usuario no encontrado -"+userId);
			
		}
	
		userService.deleteById(userId);
			
		return "Usuario eliminado - "+userId;
					
	}
	
}
