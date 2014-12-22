package org.jhub1.online.web.http;

import javax.servlet.http.HttpSession;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Request;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class ProxyImpl implements Proxy {

	@Override
	public String fetch(Verb method, String resource, String payload) {
		Request request = new Request(method, resource);
		request.addHeader("Accept", "application/json");
		if(!method.equals(Verb.GET)) {
			request.addHeader("Content-Type", "application/json");
		}
		request.addPayload(payload);
		Response response = request.send();
	//	System.out.println(response.getBody());
		return response.getBody();
	}

	@Override
	public String fetchOauth(HttpSession session, Verb method, String resource,
			String payload) {		
		OAuthService service = new ServiceBuilder()
		   .provider(DummyAPIProvider.class)
		   .apiKey((String)session.getAttribute("userKey"))
		   .apiSecret((String)session.getAttribute("userSecret"))
		   .build();
		OAuthRequest request = new OAuthRequest(method, resource);
		Token accessToken = new Token("", "");
		service.signRequest(accessToken, request);
		request.addHeader("Accept", "application/json");
		if(!method.equals(Verb.GET)) {
			request.addHeader("Content-Type", "application/json");
		}
		request.addPayload(payload);
		Response response = request.send();
//		System.out.println(response.getBody());
		return response.getBody();
	}

}
