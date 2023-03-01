package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.CustomException.ResourceNotFoundException;
import com.app.dto.LoginRequestDTO;
import com.app.dto.UserDTO;
import com.app.dto.UserSendDTO;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.repository.userRepository;

@Service
@Transactional
public class userServiceImpl implements userService {
	
	@Autowired
	public userRepository userRepo; 
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public User addUserDetails(UserDTO transientUser) {
		
		
		     String encPassword = passwordEncoder.encode(transientUser.getPassword());
		     transientUser.setPassword(encPassword);
		   
		     User tempUser = mapper.map(transientUser, User.class);
		     System.out.println(tempUser);
		
			return userRepo.save(tempUser);
	}

	@Override
	public UserSendDTO authenticateUser(LoginRequestDTO dto) {
		
		
		User user= userRepo.findByEmail(dto.getEmail());
		System.out.println(user);
		String rawPassword = dto.getPassword();
		if(user!=null && passwordEncoder.matches(rawPassword, user.getPassword()))
		return mapper.map(user, UserSendDTO.class);
		else throw new ResourceNotFoundException("Error in email or password");
	
	}
	
	
	
	
		 }

