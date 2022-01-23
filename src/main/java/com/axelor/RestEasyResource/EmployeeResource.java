package com.axelor.RestEasyResource;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import com.axelor.Entities.Employees;
import com.axelor.RestEasyServices.EmployeeService;
import com.google.inject.Inject;


@Path("Employees")
public class EmployeeResource {
	
//Default Home Page Response
//	@GET
//	public Response getResponse() {
//		return Response.ok("Response Successfully Received").build();
//	}
	
//	public RestEasyService welcome;

	
//	@Inject
//	public RestEasyResource(RestEasyService welcome) {
//		this.welcome = welcome;
//	}
	
	@Inject
	public EmployeeService emps;
	
//Welcome User
//	@GET
//	@Path("/{name}")
//	public String welcomeString(@PathParam("name") final String name) {
//		return welcome.welcomeUser(name);
//	}
//	
	@POST
	@Path("/add_Employee")
	public void createEmployee(@Context HttpServletRequest req, @Context HttpServletResponse res)
			throws ServletException, IOException {

		Employees e = new Employees(req.getParameter("name"));
		emps.createEmployee(e);
		res.sendRedirect(req.getContextPath()+"/Employees/dis_Employees");

	}
	
	@GET
	@Path("/dis_Employees")
	public void displayEmployees(@Context HttpServletRequest req, @Context HttpServletResponse res)
			throws ServletException, IOException {
		List<Employees> empl = emps.displayEmployees();
		req.setAttribute("emp_list", empl);
		req.getRequestDispatcher("../index.jsp").forward(req, res);
		
}
	
	@POST
	@Path("/upd_Employee")
	public void updateEmployee(@Context HttpServletRequest req, @Context HttpServletResponse res)
			throws ServletException, IOException {
		int eid = Integer.parseInt(req.getParameter("eid"));
		emps.updateEmployee(eid, req.getParameter("name"));
		res.sendRedirect(req.getContextPath()+"/Employees/dis_Employees");
	}
	
	@GET
	@Path("/delt_Employee")
	public void deleteEmployee(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		emps.deleteEmployee(Integer.parseInt(req.getParameter("eid")));
		res.sendRedirect(req.getContextPath()+"/Employees/dis_Employees");
	}
	
	@GET
	@Path("/searchEmployees")
	public void searchEmployees(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		String name =  req.getParameter("name");
		List<Employees> e = emps.searchEmployees(name);
		req.setAttribute("emp_list", e);
		req.getRequestDispatcher("../index.jsp").forward(req, res);
		
		
	}
	
}
