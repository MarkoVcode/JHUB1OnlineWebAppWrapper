package org.jhub1.online.web.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jhub1.online.web.config.Properties;

public abstract class Processor {
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected static final Properties PROP = Properties.getInstance();
	
	protected Processor(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	public abstract void process();
}
