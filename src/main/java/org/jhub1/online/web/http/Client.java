package org.jhub1.online.web.http;


import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Request;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class Client {
	public static void main(String[] argv) throws JSONException, IOException {
		working2();
	}
	private static void working3() throws IOException, JSONException {
		
	}
	
	
	private static void working2() throws IOException, JSONException {
		
		JSONStringer jsRequest = new JSONStringer();
		JSONStringer js = new JSONStringer();
		try {
			js.object();
			//jsRequest.object();
			js.key("email").value("wsx_my@email.com");
			js.key("password").value("wsx_password");
			js.key("appType").value("webapp");
			//jsRequest.endObject();
			//js.key("request").value(jsRequest);
			js.endObject();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		System.out.println(jsRequest.toString());
		System.out.println(js.toString());
		
		OAuthService service = new ServiceBuilder()
		   .provider(DummyAPIProvider.class)
		   .apiKey("wsx_this-is-my-user-key")
		   .apiSecret("wsx_this-is-my-user-secret-key")
		   .build();
		
	//	OAuthRequest request = new OAuthRequest(Verb.POST, "http://localhost:8189/api/v1/webauth");
	//	OAuthRequest request = new OAuthRequest(Verb.GET, "http://localhost:8088/api/v1/users/U-284832c8-e216-4e51-9998-e2cab1638b25-25684/agents/A-6a2220d5-076f-4428-a78b-8484c0b08598-41995");
		Request request = new Request(Verb.POST, "http://localhost:8189/api/v1/webauth");
		//	OAuthRequest request = new OAuthRequest(Verb.GET, "http://localhost:8081/agents");
		// new Request()
		Token accessToken = new Token("", "");
	//	service.signRequest(accessToken, request);
		request.addHeader("Accept", "application/json");
		request.addHeader("Content-Type", "application/json");
		request.addPayload(js.toString());
		Response response = request.send();
		System.out.println(response.getBody());
	}
	
	private static void working1() throws IOException, JSONException {
		JSONStringer jsRequest = new JSONStringer();
		JSONStringer js = new JSONStringer();
		try {
			js.object();
			//jsRequest.object();
			js.key("email").value("wsx_my@email.com");
			js.key("password").value("wsx_password");
			js.key("appType").value("webapp");
			//jsRequest.endObject();
			//js.key("request").value(jsRequest);
			js.endObject();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		System.out.println(jsRequest.toString());
		System.out.println(js.toString());
		ClientResource requestResource = new ClientResource(
				"http://localhost:8189/api/v1/webauth");
		Representation rep;
		rep = new JsonRepresentation(js);
		rep.setMediaType(MediaType.APPLICATION_JSON);
		Representation reply = requestResource.post(rep);
		String replyText = reply.getText();
		System.out.println("Reply Text:" + replyText);
		System.out.println("Reply Media Type:" + reply.getMediaType());
		reply.write(System.out);
		if (reply.getMediaType().equals(new MediaType("application/json"))) {
			JSONObject jsObj = new JSONObject(replyText);
			String code = jsObj.getString("CODE");
			String desc = jsObj.getString("DESC");
			System.out.println("Code:" + code + ",DESC:" + desc);
		}
		reply.release();	
	}
}
