package com.sportseventapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportseventapplication.DTO.CredentialDto;
import com.sportseventapplication.DTO.UserDTO;
import com.sportseventapplication.entity.User;
import com.sportseventapplication.exception.UsernameAlreadyExistsException;
import com.sportseventapplication.response.ResponseApi;
import com.sportseventapplication.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;


	@PostMapping("/register")
	public ResponseEntity<ResponseApi> createUser(@RequestBody User user) {
		
		System.err.println(user.getPassword());
		try {
			UserDTO userDto = userService.createUser(user);
			return ResponseEntity.ok(new ResponseApi("User Registered", userDto));
		} catch (UsernameAlreadyExistsException e) {
			return ResponseEntity.ok(new ResponseApi(e.getMessage(), null));
		}

	}

	@PostMapping("/login")
	public UserDTO login(@RequestBody CredentialDto credential) {
		return userService.verify(credential);
	}

	@GetMapping("/{id}")
	public User getMethodName(@PathVariable Long id) {
		return userService.getUser(id);
	}

	@GetMapping("/getAll")
	public List<User> getMethodName() {
		return userService.getAllUser();
	}

	@PutMapping("/{id}")
	public UserDTO putMethodName(@PathVariable Long id, @RequestBody User user) {

		return userService.updateUser(user, id);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	@GetMapping("/profile")
	public User getProfile(HttpServletRequest request)
	{
		 return userService.getProfile(request);
		 
	}
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
}
