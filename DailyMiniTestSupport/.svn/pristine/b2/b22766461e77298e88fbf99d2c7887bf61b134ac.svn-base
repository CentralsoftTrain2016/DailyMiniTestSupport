<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="service.bean.MenuBean" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>メニュー</title>
	</head>

	<body>

		<%-- 表の中に入れ込む形式で記述してます --%>
		<center>
			<h1>
				<font face="Magneto">－メニュー画面－</font>
			</h1>
		</center>

		<%-- ログインユーザ名・回数・平均点を表示 --%>
		<%= bean.getUser().getLoginusername() %>
		<br><br>

		回数:<%= bean.getUser().getTestCount() %><br>
		平均点:<%= bean.getUser().getAveragescore() %>
		<br>
		<br><br>

		<form method="POST" action="TestListServlet" >
			<input type="submit" value="テスト実施"style="font-size:28px;font-weight:bold;width:150px;height:100px;margin-left:15px; float:left;">
		</form>

		<form method="POST" action="ScoreListServlet">
			<input type="submit" value="点数一覧"style="font-size:28px;font-weight:bold;width:150px;height:100px;margin-left:15px; float:left;">
		</form>

		<form method="POST" action="CreateTestServlet">
			<input type="submit" value="テスト作成" style="font-size:28px;font-weight:bold;width:150px;height:100px;margin-left:15px; float:left;">
			<input type="hidden" value="<%=bean.isExistUnRease().toString() %>" name="isExistUnrerease">
		</form>

		<form method="POST" action="ThemeConfigurationServlet">
			<input type="submit" value="テーマ設定" style="font-size:28px;font-weight:bold;width:150px;height:100px;margin-left:15px; float:left;">
		</form>

		<%-- 仮 --%>
		<br><br><br><br><br><br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%= bean.getMessage() %>

	</body>

</html>