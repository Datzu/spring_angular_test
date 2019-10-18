package com.example.demo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.api.model.UserNotFoundException;
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
	public User getUser(@PathVariable Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
}