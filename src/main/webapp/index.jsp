<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id='login' action='/web/webapp/login' method='post' accept-charset='UTF-8'>
<fieldset >
<legend>Login</legend>
<input type='hidden' name='submitted' id='submitted' value='1'/>
 
<label for='username' >email:</label>
<input type='text' name='email' id='email'  maxlength="50" value="wsx_my@email.com" />
 
<label for='password' >Password:</label>
<input type='password' name='password' id='password' maxlength="50" value="wsx_password"/>

<label for='password' >App type:</label>
<input type='text' name='appType' id='appType' maxlength="50" value="webapp" />
 
<input type='submit' name='Submit' value='Submit' />
 
</fieldset>
</form>
</body>
</html>