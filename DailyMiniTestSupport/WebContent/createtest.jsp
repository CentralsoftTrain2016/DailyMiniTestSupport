<%@page import="domain.value.id.TestID"%>
<%@page import="domain.value.Enum.IsSavedEnum"%>
<%@page import="domain.value.Enum.QuestionTypeEnum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="service.bean.CreateTestBean" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" >
		<!--
		function getAction( submitType ){
			document.form1.submitType.value = submitType;
			this.form1.submit();
			}
		//--＞
		</script>
		<title>テスト作成画面 </title>
</head>

	<body>
		<form name="form1" action="CreateTestAddChoiceServlet" method="post">
		<input type="hidden" name="<%=IsSavedEnum.class.getName()%>" value="<%=bean.isSaved().name() %>" >
		<input type="hidden" name="<%=TestID.class.getName()%>" value="<%=bean.getTest().getTestID().toString() %>" >
		<input type="hidden" name="submitType"  >
		<center>
			<h1>
				<font face="Magneto">－テスト作成画面－</font>
			</h1>
		</center>
		<h3><%=bean.getTest().getRegistrationDate().toString()%> テスト</h3>

			<table border = 1  width = "100%">
				<tr>
					<td width = "42%"><div align = "center"><h2>【問題】</h2></div></td>
					<td width = "42%"><div align = "center"><h2>【解説】</h2></div></td>
					<td width = "16%"><div align = "center"><h2>【設定】</h2></div></td>
				</tr>
				<tr>
					<td>
						<h2>問1</h2>
						<% domain.Question q0 =bean.getTest().get(0);
						   QuestionTypeEnum qType0 = q0.getQuestionTypeEnum(); %>
						<textarea name="question1" ><%=q0.getText().toString() %></textarea>

						<%int i =0; for(domain.Choice choice: q0) {%>
						<p>
							<% if(qType0 != QuestionTypeEnum.TEXT) {%>
							<input type="<%=qType0.getHtmlInputType() %>"
									name="choiceSelect1"  size="50" value="<%=i%>"
									<%=choice.getIsCorrect().getHtmlChecked() %>>
							<%} %>
							<input type = "text" name = "choice1" value = "<%=choice.getText().toString() %>">
							<% if(qType0 == QuestionTypeEnum.TEXT) break;%>
						</p>
						<% i++; }%>

						<h2>問2</h2>
						<% domain.Question q1 =bean.getTest().get(1);
						   QuestionTypeEnum qType1 = q1.getQuestionTypeEnum(); %>
						<textarea name="question2" ><%=q1.getText().toString() %></textarea>
						<% i =0; for(domain.Choice choice: q1) {%>
						<p>
							<% if(qType1 != QuestionTypeEnum.TEXT) {%>
							<input type="<%=qType1.getHtmlInputType() %>"
										name="choiceSelect2"  size="50" value="<%=i%>"
										<%=choice.getIsCorrect().getHtmlChecked()%>>
							<%} %>
							<input type = "text" name = "choice2" value = "<%=choice.getText().toString() %>">
							<% if(qType1 == QuestionTypeEnum.TEXT) break;%>
						</p>
						<% i++;}%>

						<h2>問3</h2>
						<% domain.Question q2 =bean.getTest().get(2);
						   QuestionTypeEnum qType2 = q2.getQuestionTypeEnum(); %>
						<textarea name="question3" ><%=q2.getText().toString() %></textarea>
						<% i =0; for(domain.Choice choice: q2) {%>
						<p>
							<% if(qType2 != QuestionTypeEnum.TEXT) {%>
							<input type="<%=qType2.getHtmlInputType() %>"
										name="choiceSelect3" size="50"
										value="<%=i%>"
										<%=choice.getIsCorrect().getHtmlChecked()%>>
							<% } %>
							<input type = "text" name = "choice3" value = "<%=choice.getText().toString() %>">
							<% if(qType2 == QuestionTypeEnum.TEXT) break;%>
						</p>
						<%  i++; }%>
					</td>

					<td>
						<h2>問1</h2>
						<textarea name = "comentary1"><%=q0.getCommentaryText().toString() %></textarea>

						<% for(domain.Choice choice: q0) {%>
							<p>
								<input type = "text" name = "choiceComentary1" size="50" value = "<%=choice.getCommentaryText().toString() %>">
							</p>
							<% if(qType0 == QuestionTypeEnum.TEXT) break;%>
						<% }%>

						<h2>問2</h2>
						<textarea name = "comentary2"><%=q1.getCommentaryText().toString() %></textarea>
						<%for(domain.Choice choice: q1) {%>
							<p>
								<input type = "text" name = "choiceComentary2" size="50" value = "<%=choice.getCommentaryText().toString() %>">
							</p>
							<% if(qType1 == QuestionTypeEnum.TEXT) break;%>
						<% }%>

						<h2>問3</h2>
						<textarea name = "comentary3"><%=q2.getCommentaryText().toString() %></textarea>
						<%for(domain.Choice choice: q2) {%>
							<p>
								<input type = "text" name = "choiceComentary3" size="50" value = "<%=choice.getCommentaryText().toString() %>">
							</p>
							<% if(qType2 == QuestionTypeEnum.TEXT) break;%>
						<% }%>
					</td>

					<td>
						<p>
							<SELECT name="theme1"  onchange='getAction("submitSave");'>
								<% i = 0;%>
								<% for( domain.Theme theme: bean.getTest().getThemePeriod()) {%>
									<OPTION value="<%=theme.getThemeID().toString() %>" <%=q0.isSelected(theme) %>><%=theme.getText() %></OPTION>
								<%i++;} %>
							</SELECT>
							<br>
							<SELECT name="questiontype1"  onchange='getAction("submitSave");'>
								<OPTION value="radio" 		<%=q0.isSelected(QuestionTypeEnum.RADIO_BUTTON) %>>ラジオボタン</OPTION>
								<OPTION value="checkbox" 	<%=q0.isSelected(QuestionTypeEnum.CHECK_BOX) %>>チェックボックス</OPTION>
								<OPTION value="text"		<%=q0.isSelected(QuestionTypeEnum.TEXT) %>>テキスト</OPTION>
							</SELECT>
							<% if(qType0 != QuestionTypeEnum.TEXT) {%>
							<input type="submit" name="submitAddChoice1" value="選択肢追加" />
							<input type="submit" name="submitDelChoice1" value="選択肢削除" />
							<%} %>
						</p>
						<br><br><br><br><br><br><br><br>
						<p>
							<SELECT name="theme2"  onchange='getAction("submitSave");'>
								<% i = 0;%>
								<% for( domain.Theme theme: bean.getTest().getThemePeriod()) {%>
									<OPTION value="<%=theme.getThemeID().toString() %>" <%=q1.isSelected(theme) %>><%=theme.getText() %></OPTION>
								<%i++;} %>
							</SELECT>
							<br>
							<SELECT name="questiontype2"   onchange='getAction("submitSave");'>
								<OPTION value="radio" 		<%=q1.isSelected(QuestionTypeEnum.RADIO_BUTTON) %>>ラジオボタン</OPTION>
								<OPTION value="checkbox" 	<%=q1.isSelected(QuestionTypeEnum.CHECK_BOX) %>>チェックボックス</OPTION>
								<OPTION value="text"		<%=q1.isSelected(QuestionTypeEnum.TEXT) %>>テキスト</OPTION>
							</SELECT>
							<% if(qType1 != QuestionTypeEnum.TEXT) {%>
							<input type="submit" name="submitAddChoice2" value="選択肢追加" />
							<input type="submit" name="submitDelChoice2" value="選択肢削除" />
							<%} %>
						</p>
						<br><br><br><br><br><br><br><br>
						<p>
							<SELECT name="theme3"  onchange='getAction("submitSave");'>
								<% i = 0;%>
								<% for( domain.Theme theme: bean.getTest().getThemePeriod()) {%>
									<OPTION value="<%=theme.getThemeID().toString() %>" <%=q2.isSelected(theme) %>><%=theme.getText() %></OPTION>
								<%i++;} %>
							</SELECT>
							<br>
							<SELECT name="questiontype3"  onchange='getAction("submitSave");'>
								<OPTION value="radio" 		<%=q2.isSelected(QuestionTypeEnum.RADIO_BUTTON) %>>ラジオボタン</OPTION>
								<OPTION value="checkbox" 	<%=q2.isSelected(QuestionTypeEnum.CHECK_BOX) %>>チェックボックス</OPTION>
								<OPTION value="text"		<%=q2.isSelected(QuestionTypeEnum.TEXT) %>>テキスト</OPTION>
							</SELECT>
							<% if(qType2 != QuestionTypeEnum.TEXT) {%>
							<input type="submit" name="submitAddChoice3" value="選択肢追加" />
							<input type="submit" name="submitDelChoice3" value="選択肢削除" />
							<%} %>
						</p>
					</td>
				</tr>
			</table>

		<p>
				<input type = "submit" name="submitReturn" value = "メニューに戻る"	onclick='return confirm("メニューに戻ります　よろしいですか？");'>
				<input type = "submit" name="submitSave" value = "保存" onclick='return confirm("保存します　よろしいですか？");'>
				<input type = "submit" name="submitRegist" value = "登録" onclick='return confirm("登録します。よろしいですか？");'>
		</p>
		</form>
	</body>

</html>