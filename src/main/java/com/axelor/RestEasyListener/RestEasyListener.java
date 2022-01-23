package com.axelor.RestEasyListener;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.axelor.RestEasyModule.RestEasyModule;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

public class RestEasyListener extends GuiceResteasyBootstrapServletContextListener {
	@Override
	protected List<? extends Module> getModules(ServletContext context) {
		return Arrays.asList(new JpaPersistModule("emp_details"), new RestEasyModule());
	}
	
	@Override
	protected void withInjector(Injector injector) {
		injector.getInstance(PersistService.class).start();
	
	}
}
