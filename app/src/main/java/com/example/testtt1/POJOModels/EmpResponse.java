package com.example.testtt1.POJOModels;

public class EmpResponse{


	/**
	 * id : 9372
	 * employee_name : testвамвам
	 * employee_salary : 555
	 * employee_age : 66
	 * profile_image :
	 */

	private String id;
	private String employee_name;
	private String employee_salary;
	private String employee_age;
	private String profile_image;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_salary() {
		return employee_salary;
	}

	public void setEmployee_salary(String employee_salary) {
		this.employee_salary = employee_salary;
	}

	public String getEmployee_age() {
		return employee_age;
	}

	public void setEmployee_age(String employee_age) {
		this.employee_age = employee_age;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
}