<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="service.bean.TestListBean" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>テスト一覧</title>
	</head>

	<body>
		<h1>テスト一覧</h1>
		<table border = 1>
			<tr>
				<td><div align = "center"><font size = "4"><b>日付</b></font></div></td>
				<td><div align = "center"><font size = "4"><b>テーマ</b></font></div></td>
				<td><div align = "center"><font size = "4"><b>作成者</b></font></div></td>
				<td><div align = "center"><font size = "4"><b>実施</b></font></div></td>
			</tr>
			<% for(service.bean.TestListItem tli : bean.getTestListItemList()){ %>
				<tr>
					<td><%= tli.getTest().getRegistrationDate() %></td>
					<td><%= tli.getTest().getThemeListString() %></td>
					<td><%= tli.getTest().getCreateUser().getUsername() %></td>
					<% if(tli.getResult() != null){ %>
						<td>
							<form action = "CommentaryServlet">
								<input type = "submit" value = "済">
							</form>
						</td>
					<% } %>

					<% if(tli.getResult() == null){ %>
						<td>
							<form action = "TestServlet">
								<input type = "submit" value = "未">
							</form>
						</td>
					<% } %>
				</tr>
			<% } %>
		</table>
		<br>

		<form method = POST action = "TestListServlet">
		&lt;
		<%= bean.getBeforePage(bean.getNowPage(), "TestListServlet") %>
		<%= bean.getSelectPage(bean.getNowPage(), bean.getAllPage(), "TestListServlet") %>
		<%= bean.getNextPage(bean.getNowPage(), bean.getAllPage(), "TestListServlet") %>
		&gt;
		</form><br><br>

		<form method = POST action = "MenuServlet">
			<input type = "submit" value = "メニューに戻る">
		</form>
	</body>

</html>