package com.vti.entity;

public class Manager extends User {
	
	private int expInYear;
	
	public Manager(int id, String fullName, String email, String password, Role role, int expInYear) {
		super(id, fullName, email, password, role.MANAGER);
		this.expInYear = expInYear;
		// TODO Auto-generated constructor stub
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	@Override
	public String toString() {
		return "Manager [expInYear=" + expInYear + ", getExpInYear()=" + getExpInYear() + ", getId()=" + getId()
				+ ", getFullName()=" + getFullName() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getRole()=" + getRole() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	

	

	

}
