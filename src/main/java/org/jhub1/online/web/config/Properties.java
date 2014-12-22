package org.jhub1.online.web.config;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.DefaultConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Properties {

	private Configuration config;
	private static Properties instance;
	private static Logger log = LoggerFactory.getLogger(Properties.class);

	private Properties() {
		DefaultConfigurationBuilder factory = null;
		try {
			factory = new DefaultConfigurationBuilder("/home/developer/projects/workspace/JHUB1OnlineWebAppWrapper/src/main/resources/org/jhub1/online/web/config/config.xml");
			config = factory.getConfiguration();
		} catch (ConfigurationException e) {
			log.error("Cant read the configuration files: " + e.getMessage());
		}
	}
	
	public static synchronized Properties getInstance() {
		if(null == instance)
			instance = new Properties();
		return instance;
	}
	
	public String getBasePath()
	{
		return config.getString("base.path","/web");
	}

	public String getServletPath()
	{
		
		return getBasePath() + config.getString("base.servlet.path", "/webapp");
	}
	
	public String getLoginEntryPath()
	{
		return getServletPath() + config.getString("servlet.processor.login.entry.path", "/login");
	}

	public String getRegisterEntryPath()
	{
		return getServletPath() + config.getString("servlet.processor.register.entry.path", "/register");
	}
	
	public String getAPIEntryPath()
	{
		return getServletPath() + config.getString("servlet.processor.api.entry.path", "/restapiv1");
	}
	
	public String getAPIPath()
	{
		return config.getString("servlet.processor.api.target.path", "/api/v1");
	}
	
	public String getAPIAddress()
	{
		return config.getString("servlet.processor.api.target.address", "http://localhost:8088") + getAPIPath();
	}
	
	public String getAPILoginURIAddress()
	{
		return getAPIAddress() + config.getString("servlet.processor.api.noauth.uri.prefix", "/public") + config.getString("servlet.processor.api.noauth.login", "/authenticate");
	}

	public String getAPIRegisterURIAddress()
	{
		return getAPIAddress() + config.getString("servlet.processor.api.noauth.uri.prefix", "/public") + config.getString("servlet.processor.api.noauth.register", "/register");	}
	
	public String getAPILoginURI()
	{
		return getPublicAPIPath() + config.getString("servlet.processor.api.noauth.login", "/authenticate");
	}
	
	public String getAPIRegisterURI()
	{
		return getPublicAPIPath() + config.getString("servlet.processor.api.noauth.register", "/register");
	}
	
	public String getAuthenticatedAPIPath()
	{
		return getAPIEntryPath() + config.getString("servlet.processor.api.auth.uri.prefix", "/users");
	}
	
	public String getPublicAPIPath()
	{
		return getAPIEntryPath() + config.getString("servlet.processor.api.noauth.uri.prefix", "/public");
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("getBasePath(): ").append(getBasePath()).append("\n");
		sb.append("getServletPath(): ").append(getServletPath()).append("\n");
		sb.append("getLoginEntryPath(): ").append(getLoginEntryPath()).append("\n");
		sb.append("getRegisterEntryPath(): ").append(getRegisterEntryPath()).append("\n");
		sb.append("getAPIEntryPath(): ").append(getAPIEntryPath()).append("\n");
		sb.append("getAPIPath(): ").append(getAPIPath()).append("\n");
		sb.append("getAPIAddress(): ").append(getAPIAddress()).append("\n");
		sb.append("getAPILoginURI(): ").append(getAPILoginURI()).append("\n");
		sb.append("getAPIRegisterURI(): ").append(getAPIRegisterURI()).append("\n");
		sb.append("getAuthenticatedAPIPath(): ").append(getAuthenticatedAPIPath()).append("\n");
		sb.append("getPublicAPIPath(): ").append(getPublicAPIPath()).append("\n");
		sb.append("getAPILoginURIAddress(): ").append(getAPILoginURIAddress()).append("\n");
		sb.append("getAPIRegisterURIAddress(): ").append(getAPIRegisterURIAddress()).append("\n");
		return sb.toString();
	}
}