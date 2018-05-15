<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>テーマ設定</title>
	</head>

	<body>
		<h1>テーマ設定</h1>

		【テーマ期間】<br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type = "text" value = "2016/07/04">&nbsp;&nbsp;
						～&nbsp;&nbsp;<input type = "text" value = "2016/07/08"><br>
		<br>

		【テーマ】<br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		1.<input name="textfield" type="text" value="JavaScript" class="textField" id="tField3" list="combolist">
		<datalist id="combolist">
		<option value="JavaScript">JavaScript</option>
		<option value="HTML">HTML</option>
		<option value="フリー">フリー</option>
		</datalist><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

		2.<input name="textfield" type="text" value="HTML" class="textField" id="tField3" list="combolist">
		<datalist id="combolist">
		<option value="JavaScript">JavaScript</option>
		<option value="HTML">HTML</option>
		<option value="フリー">フリー</option>
		</datalist><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

		3.<input name="textfield" type="text" value="フリー" class="textField" id="tField3" list="combolist">
		<datalist id="combolist">
		<option value="JavaScript">JavaScript</option>
		<option value="HTML">HTML</option>
		<option value="フリー">フリー</option>
		</datalist><br><br><br>



		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type = "submit" value = "登録">
		<%-- <input type="button" class="bsize" value="ボタン" onclick="getText(3)">--%>
		&nbsp;&nbsp;
		<input type = "submit" value = "メニューに戻る">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<font size = "6"><b>OK</b></font>
		<br><br>

		<table border = 1>
			<tr>
				<td><div align = "center"><font size = "6"><b>開始期間</b></font></div></td>
				<td><div align = "center"><font size = "6"><b>終了期間</b></font></div></td>
				<td><div align = "center"><font size = "6"><b>テーマ1</b></font></div></td>
				<td><div align = "center"><font size = "6"><b>テーマ2</b></font></div></td>
				<td><div align = "center"><font size = "6"><b>テーマ3</b></font></div></td>
				<td><div align = "center"><font size = "6"><b>修正</b></font></div></td>
			</tr>
			<tr>
				<td><font size = "5">2016/07/04</font></td>
				<td><font size = "5">2016/07/08</font></td>
				<td><div align = "center"><font size = "5">JavaScript</font></div></td>
				<td><div align = "center"><font size = "5">HTML</font></div></td>
				<td><div align = "center"><font size = "5">フリー</font></div></td>
				<td><div align = "center"><input type = "submit" value = "修正"></div></td>
			</tr>
			<tr>
				<td><font size = "5">2016/07/11</font></td>
				<td><font size = "5">2016/07/15</font></td>
				<td><div align = "center"><font size = "5">JavaScript</font></div></td>
				<td><div align = "center"><font size = "5">HTML</font></div></td>
				<td><div align = "center"><font size = "5">フリー</font></div></td>
				<td><div align = "center"><input type = "submit" value = "修正"></div></td>
				</tr>
		</table>

	</body>

</html>