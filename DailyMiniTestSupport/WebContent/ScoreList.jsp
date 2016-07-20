<%@page import="domain.User"%>
<%@page import="domain.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="service.bean.ScoreListBean" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>点数一覧</title>
	</head>

	<body>
		<h1>点数一覧</h1>

		<form method = "POST" action = "ScoreListSerchServlet">
			<SELECT name = "name" style="margin:0px; float:left;">
				<% for(User user : bean.getUserList()){ %>
					<OPTION value = <%= user.getUserid() %>><%= user.getUsername() %></OPTION>
				<% } %>
				<OPTION value = "全て">全て</OPTION>
			</SELECT>
			<input type = "submit" value = "検索">
			<input type = "hidden" value = <%= bean.getNowPage() %> name = "nowpage">
		</form>
		<br><br>

		<table border = 1>
			<tr>
				<td>
					<div align = "center">
						<font size = "6" style="margin:0px; float:left;">
							<b>日付</b>
						</font>
						<form method = "POST" action = "ScoreListServlet">
							<input type = "image"  src="Img/降順.jpg" width = "30" height = "30"  style="margin:0px; float:left;">
							<input type="hidden" value = "dateSortDesc" name = "sort">
						</form>
						<form method = "POST" action = "ScoreListServlet">
							<input type = "image"  src="Img/昇順.jpg" width = "30" height = "30" style="margin:0px; float:left;">
							<input type="hidden" value = "dateSortAsc" name = "sort">
						</form>
					</div>
				</td>
				<td>
					<div align = "center">
						<font size = "6" style="margin:0px; float:left;">
							<b>名前</b>
						</font>
						<form method = "POST" action = "ScoreListServlet">
							<input type = "image"  src="Img/降順.jpg" width = "30" height = "30"  style="margin:0px; float:left;">
							<input type="hidden" value = "nameSortDesc" name = "sort">
						</form>
						<form method = "POST" action = "ScoreListServlet">
							<input type = "image"  src="Img/昇順.jpg" width = "30" height = "30">
							<input type="hidden" value = "nameSortAsc" name = "sort">
						</form>
					</div>
				</td>
				<td><div align = "center"><font size = "6"><b>点数</b></font></div></td>
				<td><div align = "center"><font size = "6"><b>回答解説へ</b></font></div></td>
			</tr>

			<% for(Result result : bean){ %>
				<tr>
					<td>
						<font size = "5">
							<%= result.getAnswerDate() %>
						</font>
					</td>
					<td>
						<font size = "5">
							<%= result.getUser().getUsername() %>
						</font>
					</td>
					<td>
						<div align = "right">
							<font size = "5">
								<%= result.getScore() %>
							</font>
						</div>
					</td>
					<td>
						<div align = "center">
							<form method = POST action = "CommentaryServlet">
								<input type = "image"  src="Img/ling.png" width = "30" height = "30">
								<input type = "submit" value = "回答">
							</form>
						</div>
					</td>
				</tr>
			<% } %>
		</table>
		<br>

		<form method = POST action = "TestListServlet">
		&lt;
		<%= bean.getBeforePage(bean.getNowPage(), "ScoreListServlet") %>
		<%= bean.getSelectPage(bean.getNowPage(), bean.getAllPage(), "ScoreListServlet") %>
		<%= bean.getNextPage(bean.getNowPage(), bean.getAllPage(), "ScoreListServlet") %>
		&gt;
		</form><br><br>

		<form method = POST action = "MenuServlet">
			<input type = "submit" value = "メニューに戻る">
		</form>
	</body>

</html>