<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.guest.app.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>결과창</title>
</head>
<body>

	<table>
		<tr>
			<td width="50px" align="center">no</td>
			<td align="center">email</td>
			<td align="center">password</td>
			<td align="center">text</td>
			<td align="center">regdate</td>
		</tr>
		<!-- result는 contoller의 addObject로 부터 가져온다. -->
		<c:forEach items="${result}" var="guestbook">
			<tr>
				<td>${guestbook.no}</td>
				<td>${guestbook.email}</td>
				<td>${guestbook.passwd}</td>
				<td>${guestbook.txt}</td>
				<td>${guestbook.regdate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>