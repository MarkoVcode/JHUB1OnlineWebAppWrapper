package org.jhub1.online.web.process.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jhub1.online.web.process.Processor;

public class PublicAPI extends Processor {

	public PublicAPI(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	@Override
	public void process() {
	
	}

}
