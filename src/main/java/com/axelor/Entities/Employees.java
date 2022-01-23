package com.axelor.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Employees {
	@Id
	@Column(name="Employee_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer emp_id;
	@Column(name="Employee_Name")
	private String emp_name;
	
	@OneToMany(mappedBy = "employees", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Smartphones> sm;
	
	public List<Smartphones> getSm() {
		return sm;
	}
	public void setSm(List<Smartphones> sm) {
		this.sm = sm;
	}
	
	public Employees() {
		super();
	}
	public Employees(String emp_name) {
		super();
		this.emp_name = emp_name;				
	}
	
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	@Override
	public String toString() {
		return "Employees [emp_id=" + emp_id + ", emp_name=" + emp_name + ", sm=" + sm + "]";
	}
	
	public Employees addEmplSmarts(Smartphones s) {
		sm.add(s);
		s.setEmployees(this);
		return this;
	}
	public Employees deleteSmart(Smartphones s) {
		sm.remove(s);
		s.setEmployees(null);
		return this;
		
	}
	
	
}
