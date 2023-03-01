package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.dto.*;
import com.app.service.userService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")

public class UserController {
	
	public UserController() {
		
	}

	@Autowired
	public userService users;
	
	@PostMapping
	public User saveEmpDetails(@RequestBody UserDTO transientUser)
	{
		//System.out.println("in save emp "+transientUser+" id "+transientUser.getUserId());
		return users.addUserDetails(transientUser);
		
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> validateEmployee(@RequestBody LoginRequestDTO dto)
	{
		System.out.println("in emp signin "+dto);
		try {
		UserSendDTO user =users.authenticateUser(dto);
		
			return ResponseEntity.ok(user);
		}
		catch(RuntimeException e)
		{
			System.out.println("in err emp controller");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
				
			
	}
	}
