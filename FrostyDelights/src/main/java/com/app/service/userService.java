package com.app.service;

import com.app.dto.LoginRequestDTO;
import com.app.dto.UserDTO;
import com.app.dto.UserSendDTO;
import com.app.pojos.User;

public interface userService {

	 User addUserDetails(UserDTO transientUser);

	UserSendDTO authenticateUser(LoginRequestDTO dto);
	

}
