package com.vti.backend.presentation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.bussinesslayer.IUserService;
import com.vti.backend.bussinesslayer.UserService;
import com.vti.entity.Manager;
import com.vti.entity.User;

public class UserController {
	private IUserService userService;

	public UserController() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userService = new UserService();
	}

	public List<Manager> getListUsers() throws SQLException, ClassNotFoundException {

		return userService.getListManagers();
	}
	
	public User getUserByProjectId(int id) throws SQLException, ClassNotFoundException {
		return userService.getUserByProjectId(id);
	}
	
	public boolean isProjectIdExits(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return userService.isProjectIdExits(id);
	}


}
