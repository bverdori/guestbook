<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.guest.app.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Guest Book</title>
</head>
<body>
	<h1>Guest Book</h1>
	<form action="/guestbook/insert" method="POST">
		<label>E-mail&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="email"><br>
		<label>Password&nbsp;</label><input type="password" name="passwd"><br>
		<label>Message&nbsp;&nbsp;</label><input type="text" name="txt">
		<input type="submit" value="����"><br>
	</form>
	
	<hr>
	
	<table>
		<tr>
			<td align="center">E-mail</td>
			<td align="center">����</td>
			<td align="center">�ۼ���/������</td>
			<td align="center">����</td>
			<td align="center">����</td>
		</tr>
		<!-- result�� contoller�� addObject�� ���� �����´�. -->
		<c:forEach items="${result}" var="guestbook">
			<tr>
				<form action="/guestbook/update" method="POST">
					<input type="hidden" name="no" value="${guestbook.no}">
					<td>${guestbook.email}</td>
					<td>${guestbook.txt}</td>
					<td>
						${guestbook.regdate}<br>
						${guestbook.modified}
					</td>
					<td>
						<input type="text" name="txt">
						<input type="password" name="passwd">
						<input type="submit" value="����">
					</td>
				</form>
					<td>
						<form action="/guestbook/delete" method="POST">
							<input type="hidden" name="no" value="${guestbook.no}">
							<input type="submit" value="����">
						</form>
					</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>