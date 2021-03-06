package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.Utils.ScannerUtils;
import com.vti.backend.presentation.UserController;
import com.vti.entity.Manager;
import com.vti.entity.User;

public class Function {
	private UserController userController;

	public Function() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userController = new UserController();
	}

	public void getListManagers() throws ClassNotFoundException, SQLException {
		List<Manager> users = userController.getListUsers();
		System.out.printf("%-15s %-25s %-25s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password", "Role");
		for (Manager user : users) {
			System.out.printf("%-15s %-25s %-25s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullName(),
					"*********",user.getRole(), user.getExpInYear());
		}
	}
	
	
	public void getUserByProjectId() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.print("Mời bạn nhập vào id: ");
			int id = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương! Mời nhập lại");

			if (userController.isProjectIdExits(id)) {
				System.out.println(userController.getUserByProjectId(id));
				return;
			} else {
				System.err.println("id khong ton tai! Vui long nhap lai! ");
			}
		}
	}

}
