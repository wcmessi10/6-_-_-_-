<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../default/header.jsp" %>
<h1>Login</h1>
<div>
	<form action="userCheck" method="post">
		ID <input type="text" name="id" ><br>
		PW <input type="text" name="pw" ><br>
		<input type="submit" value="Login" >
		<button onclick="location href='/root/members/register'">회원가입</button><br>
	</form>	
</div>
</body>
</html>