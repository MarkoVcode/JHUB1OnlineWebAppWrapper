package org.jhub1.online.web.process.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jhub1.online.web.http.Proxy;
import org.jhub1.online.web.http.ProxyImpl;
import org.jhub1.online.web.process.Processor;
import org.jhub1.online.web.uri.URITranslateHelper;
import org.scribe.model.Verb;

public class UserAPI extends Processor {
	
	private Proxy pxy;

	private URITranslateHelper uriTranslate;
	
	public UserAPI(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		pxy = new ProxyImpl();	
		uriTranslate = new URITranslateHelper();
	}

	@Override
	public void process() {
		response.addHeader("Content-Type", "application/json");
		String payload = null;
		String apiResourcePath = uriTranslate.translateToAPI(request.getRequestURI());
		if(request.getMethod().equalsIgnoreCase("GET")) {
			payload = pxy.fetchOauth(request.getSession(), Verb.GET, apiResourcePath, null);
		} else if(request.getMethod().equalsIgnoreCase("POST")) {
			payload = pxy.fetchOauth(request.getSession(), Verb.POST, apiResourcePath, "");
		} else {
			//procesing error - perhaps other methods need to be implemented too
		}
			//set payload to response	
		
	}

}
