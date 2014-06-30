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
		<input type="submit" value="전송"><br>
	</form>
	
	<hr>
	
	<table>
		<tr>
			<td align="center">E-mail</td>
			<td align="center">내용</td>
			<td align="center">작성일/수정일</td>
			<td align="center">수정</td>
			<td align="center">삭제</td>
		</tr>
		<!-- result는 contoller의 addObject로 부터 가져온다. -->
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
						<input type="submit" value="수정">
					</td>
				</form>
					<td>
						<form action="/guestbook/delete" method="POST">
							<input type="hidden" name="no" value="${guestbook.no}">
							<input type="submit" value="삭제">
						</form>
					</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>