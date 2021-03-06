package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.Utils.ScannerUtils;
import com.vti.entity.Role;
import com.vti.entity.User;

public class Program {

	public static void main(String[] args)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		menuLogin();

	}

	private static void menuLogin() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
//		Function function = new Function();
//		System.out.println("MỜI BẠN LOGIN");
//		User user = function.login();
		System.out.println("Login successfull!");
		menuAdmin();
	}

	private static void menuAdmin() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Function function = new Function();
		System.out.println("Moi ban nhap chuc nang muon su dung:\n" + "1: In ra danh sách các Manager\n"
				+ "2: Tìm user theo Project ID\n" + "3: Thoat khoi chuong trinh\n ");

		while (true) {
			System.out.print("Moi ban nhap chuc nang: ");
			int choose = ScannerUtils.inputFunction(1, 3, "Ban chi duoc chon tu 1 --> 3. Mời nhập lại!");

			switch (choose) {
			case 1:
				function.getListManagers();
				break;
			case 2:
				function.getUserByProjectId();
				break;
			case 3:
//				function.deleteUser();
				System.out.println("Ban da thoat khoi chuong trinh!");
				break;
			}
		}
	}

}
