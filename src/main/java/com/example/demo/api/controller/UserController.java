package com.example.demo.api.controller;

import java.security.Principal;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.model.UserNotFoundException;
import com.example.demo.api.model.User;
import com.example.demo.api.model.UserLogin;
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

    @RequestMapping("/login")
    public boolean login(@RequestBody UserLogin user) {
    	System.out.println("### user: " + user.toString());
        return user.getUsername().equals("user") && user.getPassword().equals("password");
    }

    @GetMapping("/user")
    public Principal user(HttpServletRequest request) {
    	System.out.println("### logged");
        String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
        System.out.println(authToken);
        return () ->  new String(Base64.getDecoder().decode(authToken)).split(":")[0];
    }

}