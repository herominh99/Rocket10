package com.vti.entity;

public class Employee extends User {

	private String ProSkill;
	private int projectID;

	public Employee(int id, String fullName, String email, String password, String ProSkill, int projectID) {
		super(id, fullName, email, password, Role.EMPLOYEE);
		this.ProSkill = ProSkill;
		this.projectID = projectID;

	}

	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	

	public String getProSkill() {
		return ProSkill;
	}

	@Override
	public String toString() {
		return "Employee [ProSkill=" + ProSkill + ", projectID=" + projectID + ", getProjectID()=" + getProjectID()
				+ ", getProSkill()=" + getProSkill() + ", getId()=" + getId() + ", getFullName()=" + getFullName()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getRole()=" + getRole()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	

}
