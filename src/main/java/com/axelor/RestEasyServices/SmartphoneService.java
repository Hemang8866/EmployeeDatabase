package com.axelor.RestEasyServices;


import com.google.inject.ImplementedBy;

@ImplementedBy(SmartphoneImpl.class)
public interface SmartphoneService {

	public void addSmarts(String sm_name,int sm_id);
	public String updateSmart(int sm_id, String sm_name);
	public void deleteSmart(int sm_id);
		
}
