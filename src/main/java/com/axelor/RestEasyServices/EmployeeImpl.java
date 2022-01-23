package com.axelor.RestEasyServices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.axelor.Entities.Employees;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

@Singleton
public class EmployeeImpl implements EmployeeService{
//	@Override
//	public String welcomeUser(String name) {
//		return "Hello User: "+name;
//	}
	
	@Inject
	public Provider<EntityManager> pr;
	
	@Transactional
	public void createEmployee(Employees e) {
		pr.get().persist(e);
		
	}
	
	@Override
	@Transactional
	public List<Employees> displayEmployees(){
		EntityManager em = pr.get();
		Query qr = em.createQuery("from Employees order by emp_id");
		@SuppressWarnings("unchecked")
		List<Employees> empl = qr.getResultList();
		return empl;
	}
	
	@Override
	@Transactional
	public String updateEmployee(Integer emp_id , String emp_name) {
		EntityManager em =  pr.get();
		Employees e = em.find(Employees.class, emp_id);
		e.setEmp_name(emp_name);
		String nm = e.getEmp_name();
		return nm;
	}
	
	@Override
	@Transactional
	public Employees deleteEmployee(int emp_id) {
		EntityManager em =  pr.get();
		Employees e = em.find(Employees.class, emp_id);
		em.remove(e);
		return e;
	}

	@Override
	public List<Employees> searchEmployees(String emp_name) {
		EntityManager em =  pr.get();
		Query qr = em.createQuery("from Employees where emp_name like '%"+emp_name+"%'");
		@SuppressWarnings("unchecked")
		List<Employees> e = qr.getResultList();
		return e;
	}

}
