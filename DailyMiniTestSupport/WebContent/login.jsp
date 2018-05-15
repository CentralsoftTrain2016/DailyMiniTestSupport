<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="service.bean.LoginBean" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ログイン</title>
	</head>

	<body bgcolor="#FFFFFF" text="#000000" link="#0000ff" vlink="#800080" alink="#ff0000">
		<br>
		<form  method="POST" action="LoginLoginServlet">
			<Div Align="center">
				ID：<input name="<%= domain.value.LoginUserName.class.getName() %>" type="text" ><br>
			</Div>

			<Div Align="center">
				PW：<input name="<%= domain.value.Password.class.getName() %>" type="password" ><br>
			</Div>

			<center>
				<%= bean.getMessage() %><br>
				<input type="submit" value="ログイン"><br>
			</center>
		</form>
		<br>

		<form  method="POST" action="LoginCreateServlet">
			<Div Align="center">
				<input type="submit" value="新規登録">
			</Div>
		</form>
		<br>
	</body>

</html>