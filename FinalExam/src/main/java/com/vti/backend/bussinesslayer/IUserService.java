package com.vti.backend.bussinesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Manager;
import com.vti.entity.User;

public interface IUserService {
	List<Manager> getListManagers() throws SQLException, ClassNotFoundException;
	User getUserByProjectId(int id) throws SQLException, ClassNotFoundException;
	boolean isProjectIdExits(int id) throws SQLException, ClassNotFoundException;

}
