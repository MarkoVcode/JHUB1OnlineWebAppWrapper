package org.jhub1.online.web.http;

import javax.servlet.http.HttpSession;

import org.scribe.model.Verb;

public interface Proxy {

	String fetch(Verb method, String resource, String payload);
	
	String fetchOauth(HttpSession session, Verb method, String resource, String payload);
	
}
