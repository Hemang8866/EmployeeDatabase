package com.axelor.RestEasyServices;

import java.util.List;

import com.axelor.Entities.Employees;
import com.google.inject.ImplementedBy;

@ImplementedBy(EmployeeImpl.class)
public interface EmployeeService {
//	public String welcomeUser(String name);
	public void createEmployee(Employees e);
	public List<Employees> displayEmployees();
	public String updateEmployee(Integer emp_id, String emp_name);
	public Employees deleteEmployee(int emp_id);
	public List<Employees> searchEmployees(String emp_name);
}
