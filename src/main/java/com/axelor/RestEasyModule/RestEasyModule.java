package com.axelor.RestEasyModule;

import com.axelor.RestEasyResource.EmployeeResource;
import com.axelor.RestEasyResource.SmartphoneResource;
import com.axelor.RestEasyServices.EmployeeImpl;
import com.axelor.RestEasyServices.EmployeeService;
import com.axelor.RestEasyServices.SmartphoneImpl;
import com.axelor.RestEasyServices.SmartphoneService;
import com.google.inject.AbstractModule;

public class RestEasyModule extends AbstractModule {
	@Override
	protected void configure() {

		bind(SmartphoneService.class).to(SmartphoneImpl.class);
		bind(EmployeeService.class).to(EmployeeImpl.class);
		bind(EmployeeResource.class);
		bind(SmartphoneResource.class);
	}
}
