package org.jhub1.online.web.process.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jhub1.online.web.http.UserManager;
import org.jhub1.online.web.http.UserManagerImpl;
import org.jhub1.online.web.process.Processor;

public class Login extends Processor {

	public Login(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	@Override
	public void process() {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String appType = request.getParameter("appType");
		
		UserManager um = new UserManagerImpl();
		Map<String, String> auth = um.authorizeUser(email, password, appType);
		
		if(null != auth.get("userKey")) {
            HttpSession session = request.getSession();
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            session.setAttribute("userKey", auth.get("userKey"));
            session.setAttribute("userSecret", auth.get("userSecret"));
			try {
				response.sendRedirect(PROP.getBasePath() + "/webapp.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
 //           https://www.safaribooksonline.com/library/view/java-servlet-programming/0596000405/ch04.html        
		} else {
			try {
				response.sendRedirect(PROP.getBasePath() + "/index.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
