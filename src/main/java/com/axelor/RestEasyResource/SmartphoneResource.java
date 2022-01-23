package com.axelor.RestEasyResource;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.axelor.RestEasyServices.SmartphoneService;
import com.google.inject.Inject;

@Path("Smartphones")
public class SmartphoneResource {
	
	@Inject
	public SmartphoneService ss;

	@POST
	@Path("/addSmarts")
	public void addEmplSmarts(@Context HttpServletRequest req , @Context HttpServletResponse res) throws ServletException, IOException {
		int sid = Integer.parseInt(req.getParameter("sid"));
		String sName = req.getParameter("name");
		ss.addSmarts(sName, sid);
//		req.setAttribute("sid", sid);
		res.sendRedirect(req.getContextPath()+"/Employees/dis_Employees");
	}
	
	@POST
	@Path("/updateSmart")
	public void updateSmart(@Context HttpServletRequest req , @Context HttpServletResponse res) throws IOException {
		int sid = Integer.parseInt(req.getParameter("sid"));
		String sName= req.getParameter("name");
		ss.updateSmart(sid, sName);
		res.sendRedirect(req.getContextPath()+"/Employees/dis_Employees");
		
	}
	
	
	@GET
	@Path("/deleteSmart")
	public void deleteSmart(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		int sid = Integer.parseInt(req.getParameter("sid"));
		ss.deleteSmart(sid);
		res.sendRedirect(req.getContextPath()+"/Employees/dis_Employees");
	}
	
}
