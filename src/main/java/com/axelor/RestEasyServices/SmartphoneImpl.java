package com.axelor.RestEasyServices;


import javax.persistence.EntityManager;

import com.axelor.Entities.Employees;
import com.axelor.Entities.Smartphones;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

public class SmartphoneImpl implements SmartphoneService{
	
	@Inject
	public Provider<EntityManager> smp;
	
	@Override
	@Transactional
	public void addSmarts(String sm_name , int emp_id) {
		EntityManager em =  smp.get();
		Smartphones s = new Smartphones(sm_name);
		Employees e = em.find(Employees.class, emp_id);
		e.addEmplSmarts(s);
	}
	
	@Override
	@Transactional
	public String updateSmart(int sm_id, String sm_name) {
		EntityManager em =  smp.get();
		Smartphones s = em.find(Smartphones.class, sm_id);
		 s.setSm_name(sm_name);
		 return s.getSm_name();
		
	}
	
	
	@Override
	@Transactional
	public void deleteSmart(int sm_id) {
		EntityManager em =  smp.get();
		Smartphones s = em.find(Smartphones.class, sm_id);
		Employees e =  s.getEmployees();
		e.deleteSmart(s);
		
	}

	
}
