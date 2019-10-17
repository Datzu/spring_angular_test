package com.example.demo.api.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.model.User;
import com.example.demo.api.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8000")
public class UserController {
 
    // standard constructors

	@Autowired
    private final UserRepository userRepository;
	
	public UserController() {
		super();
		this.userRepository = null;
	}
 
    public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
 
    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
    
    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable String id) {
    	try {
    		System.out.println("ID: " + id);
        	return userRepository.findById(Long.parseLong(id));
    	} catch (Exception e) {
			return null;
		}

    }
}