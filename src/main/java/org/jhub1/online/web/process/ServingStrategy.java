package org.jhub1.online.web.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jhub1.online.web.config.Properties;
import org.jhub1.online.web.process.impl.Login;
import org.jhub1.online.web.process.impl.PublicAPI;
import org.jhub1.online.web.process.impl.Register;
import org.jhub1.online.web.process.impl.UserAPI;
/**
 * 
 * @author developer
 *		//normalWeb
		// /web/webapp/login
		// /web/webapp/register
		
		//API
		// /web/webapp/restapiv1
 */
public class ServingStrategy {
	public Processor getProcessor(HttpServletRequest request, HttpServletResponse response) {
		
		Properties prop = Properties.getInstance();

		if(request.getRequestURI().startsWith(prop.getAuthenticatedAPIPath()))
		{
			Processor p = new UserAPI(request, response);
			return p;
		} 
		else if(request.getRequestURI().startsWith(prop.getPublicAPIPath()))
		{
			Processor p = new PublicAPI(request, response);
			return p;
		}
		else if(request.getRequestURI().startsWith(prop.getLoginEntryPath())) 
		{
			if(request.getMethod().equalsIgnoreCase("POST")) {
				Processor p = new Login(request, response);
				return p;
			}
		}
		else if(request.getRequestURI().startsWith(prop.getRegisterEntryPath()))
		{
			if(request.getMethod().equalsIgnoreCase("POST")) {
				Processor p = new Register(request, response);
				return p;
			}
		}
		return null;
	}
}
