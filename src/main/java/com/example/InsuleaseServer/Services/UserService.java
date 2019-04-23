package com.example.InsuleaseServer.Services;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.InsuleaseServer.Models.User;
import com.example.InsuleaseServer.Repositories.UserRepository;

import java.util.List;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://insulease.herokuapp.com/"}, allowCredentials = "true", allowedHeaders = "*")

public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("api/login")
	public User login(	@RequestBody User credentials,
	HttpSession session) {
		System.out.println("attempting to log in user with un: " +credentials.getUsername() + " and pw: " + credentials.getPassword());
		List<User> users = (List<User>) userRepository.findAll();
		for (User user : users) {
			if( user.getUsername().equals(credentials.getUsername())
					&& user.getPassword().equals(credentials.getPassword())) {
			    session.setAttribute("currentUser", user);
			    System.out.println("Successfully logged in user " + session.getAttribute("currentUser").toString());
			    return user;
			  }
	 }
	 System.out.println("could not find user");
	 return null;
	}
	
	/**
	 * Return the currently logged in user
	 * @param session
	 * @return
	 */
	@PostMapping("/api/profile")
	public User profile(HttpSession session) {
		User currentUser = (User)session.getAttribute("currentUser");
		boolean current = session.getAttribute("currentUser") ==null;
		System.out.println(current);
		if (!current) {
			System.out.println("From profile: current user is " + session.getAttribute("currentUser"));
		}
		if (currentUser == null) {
			System.out.println("From profile: Current user is null");
			return null;
		}
		return currentUser;
	}
	
	@PostMapping("/api/logout")
	public void logout (HttpSession session) {
		System.out.println("User logged out");
		session.invalidate();
	}
	
	/**
	 * Handles GET request to return a specific user
	 * @param id is the unique userId
	 * @return the user with the given ID
	 */
	@GetMapping("/api/user/{userId}")
	public User findUserById(
			@PathVariable("userId") Integer id) {
		User user = (User)userRepository.findById(id).get();
		return user;
	}

}
