package com.vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.Utils.JdbcUltils;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.Role;
import com.vti.entity.User;

public class UserRepository implements IUserRepository {
	private JdbcUltils jdbcUtils;
	private Connection connection;

	public List<Manager> getListManagers() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<Manager> users = new ArrayList<>();
		try {
			// get connect
			connection = jdbcUtils.connect();

			// Create a statment object
			Statement statement = connection.createStatement();

			// Execute query
			String listUser = "SELECT * FROM User\n"
					+ "WHERE User.`Role` = 'Manager' ";
			ResultSet resultSet = statement.executeQuery(listUser);

			// Handling result set
			while (resultSet.next()) {
				int userID = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String password = resultSet.getString("Password");
				Role role = Role.valueOf(resultSet.getString("Role"));
				int expInYear = resultSet.getInt("expInYear");
				Manager user = new Manager(userID, fullName, email, password, role, expInYear);
				users.add(user);
			}
			return users;

		} finally {
			connection.close();
		}

	}


	public User getUserByProjectId(int id) throws SQLException, ClassNotFoundException {
		List<User> users = new ArrayList<>();
		try {
			// Step 2: get connect
			connection = jdbcUtils.connect();

			// Step 3: Create a statement object
			String sql = " SELECT * From User\n"
					+ "INNER JOIN\n"
					+ "Project ON Project.UserID = User.UserID\n"
					+ "WHERE Project.ProjectID = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);

			// Step 4: Execute SQL query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set
			while (resultSet.next()) {
				int userId = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String password = resultSet.getString("Password");
				Role role = Role.valueOf(resultSet.getString("Role"));
				int expInYear = resultSet.getInt("ExpInYear");
				String proSkill = resultSet.getString("ProSkill");
				int projectID = resultSet.getInt("ProjectID");

				if (role.equals("Employee")) {
					Employee user = new Employee(userId, fullName, email, password, proSkill, projectID);
					users.add(user);
				} 
				else if (role.equals("Manager")) {
					Manager user = new Manager(userId, fullName, email, password, role, expInYear);
					users.add(user);
					
				}
				

			}
			

		} finally {
			connection.close();
		}
		return (User) users;
	}


	

	public boolean isProjectIdExits(int id) throws SQLException, ClassNotFoundException {
		try {

			// step 2: get connect
			connection = jdbcUtils.connect();

			// Step 3: Create a statement object

			String sql = "SELECT * FROM ProjectManager.Project " + " WHERE ProjectID = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);

			// Step 4: Execute Query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set

			if (resultSet.next()) {

				return true;
			}

			return false;
		} finally {
			connection.close();
		}
	}

}
