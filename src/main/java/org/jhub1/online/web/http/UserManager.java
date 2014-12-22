package org.jhub1.online.web.http;

import java.util.Map;

public interface UserManager {

	Map<String, String> authorizeUser(String email, String password, String appType);
	
	boolean registerUser(String email, String password);
	
}
