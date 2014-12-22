package org.jhub1.online.web.http;

import java.util.HashMap;
import java.util.Map;

import org.jhub1.online.web.config.Properties;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.scribe.model.Verb;

public class UserManagerImpl implements UserManager {
	
	private Properties prop;
	
	public UserManagerImpl() {
		prop = Properties.getInstance();
	}
	
	@Override
	public Map<String, String> authorizeUser(String email, String password,
			String appType) {
		JSONStringer js = new JSONStringer();
		try {
			js.object();
			js.key("email").value(email);
			js.key("password").value(password);
			js.key("appType").value(appType);
			js.endObject();
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		Proxy proxy = new ProxyImpl();
		String jsonString = proxy.fetch(Verb.POST, prop.getAPILoginURIAddress(), js.toString());
		Map<String, String> result = new HashMap<String, String>();
		try {
			JSONObject jsonObj = new JSONObject(jsonString);
			result.put("userKey", jsonObj.getString("userKey"));
			result.put("userSecret", jsonObj.getString("userSecret"));
			result.put("userID", jsonObj.getString("userID"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean registerUser(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
