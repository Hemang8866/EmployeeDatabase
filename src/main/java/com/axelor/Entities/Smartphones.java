package com.axelor.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Smartphones {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="Smartphone_id")
private int sm_id;
@Column(name="Smartphone_name")
private String sm_name;

@ManyToOne
private Employees employees;

public Smartphones() {
	super();
}
public Smartphones(String sm_name) {
	super();
	this.sm_name = sm_name;
}
public int getSm_id() {
	return sm_id;
}
public void setSm_id(int sm_id) {
	this.sm_id = sm_id;
}
public String getSm_name() {
	return sm_name;
}
public void setSm_name(String sm_name) {
	this.sm_name = sm_name;
}
public Employees getEmployees() {
	return employees;
}
public void setEmployees(Employees employees) {
	this.employees = employees;
}
@Override
public String toString() {
	return "Smartphones [sm_id=" + sm_id + ", sm_name=" + sm_name + ", employees=" + employees + "]";
}

}
