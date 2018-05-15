<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="service.bean.NewUserBean" scope="request" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新規登録</title>
</head>
<body bgcolor="#FFFFFF">
<center><h1><font face="Magneto">－新規登録－</font></h1></center>
<br>
<form  method="POST" action="NewUserCreateServlet">
<center>	ID：<input name="<%=domain.value.LoginUserName.class.getName()%>" type="text" ></center> <%=bean.getIDErrorMessage().toString() %>
<center>    名前：<input name="<%=domain.value.UserName.class.getName()%>" type="text" ></center> <%=bean.getNameErrorMessage().toString() %>
<center>    PASS：<input name="<%=domain.value.Password.class.getName()%>" type="password" ></center>  <%=bean.getPasswordErrorMessage().toString() %>
<center>	<input type="submit" value="登録" style="width:120px; height:60px"></center>
</form>
<br>
<form  method="POST" action="LoginServlet">
<Div Align="center">	<input type="submit" value="ログイン画面へ戻る"></Div>
</form>
</body>
</html>