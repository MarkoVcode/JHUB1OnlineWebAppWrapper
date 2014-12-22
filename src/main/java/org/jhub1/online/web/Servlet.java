package org.jhub1.online.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jhub1.online.web.config.Properties;
import org.jhub1.online.web.process.Processor;
import org.jhub1.online.web.process.ServingStrategy;


public class Servlet extends HttpServlet {

	private static final long serialVersionUID = -5596872945550495569L;
	
	private ServingStrategy ss;

	private Properties prop;
	
	public void init() throws ServletException {
		prop = Properties.getInstance();
		ss = new ServingStrategy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		Processor p = ss.getProcessor(request, response);
		if(null == p) {
			response.sendRedirect(prop.getBasePath() + "/index.jsp");
		} else {
			p.process();
		}
		// Actual logic goes here. prop.getBasePath() + 
	//	PrintWriter out = response.getWriter();
	//	out.println("<h1>" + message + request.getMethod() + "</h1>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		response.setContentType("text/html");
		Processor p = ss.getProcessor(request, response);
		if(null == p) {
			response.sendRedirect(prop.getBasePath() + "/index.jsp");
		} else {
			p.process();
		}		
	}
	
	public void destroy() {
		// do nothing.
	}

}