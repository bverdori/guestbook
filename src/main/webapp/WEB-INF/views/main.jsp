<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.guest.app.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<title>Guest Book</title>
</head>

<script>
// 방명록 입력에 대한 클라이언트 측 입력값 체크
$(document).ready(function() {
	$("form#form_insert").bind("submit", function () {
		email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
		
		// E-mail, 비밀번호, 내용 입력 확인 (공백일 경우 경고창 생성)
		if ($("input#email").val().trim() == "") {
			alert("이메일주소를 입력해 주세요.");
			$("input#email").focus();
			return false;
		} else if ($("input#passwd").val().trim() == "") {
			alert("비밀번호를 입력해 주세요.");
			$("input#passwd").focus();
			return false;
		} else if ($("input#txt").val().trim() == "") {
			alert("내용을 입력해 주세요.");
			$("input#txt").focus();
			return false;
		} 
		// E-mail 형식 체크 (형식 불일치의 경우 경고창 생성)
		else if(!email_regex.test($("input#email").val().trim())){
			alert("이메일 형식을 맞춰 주세요.");
			$("input#email").focus();
			return false;
		}
		return true;  
	});
});
</script>

<body>
	<h1>Guest Book</h1>
	<hr>
	<form action="/guestbook/insert" method="POST" id="form_insert">
		<h3>방명록 입력</h3>
		<label>E-mail&nbsp;&nbsp;&nbsp;</label><input type="text" name="email" id="email"><br>
		<label>비밀번호&nbsp;</label><input type="password" name="passwd" id="passwd"><br>
		<label>내용&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="txt" id="txt" size="100">
		<input type="submit" value="전송"><br>
	</form>
	
	<hr>
	
	<table style="border:1px gray solid;">
		<tr>
			<td align="center" style="border:1px gray solid;">E-mail</td>
			<td align="center" style="border:1px gray solid;">내용</td>
			<td align="center" style="border:1px gray solid;">작성일/수정일</td>
			<td align="center" style="border:1px gray solid;">수정</td>
			<td align="center" style="border:1px gray solid;">삭제</td>
		</tr>
		<!-- result는 contoller의 addObject로 부터 가져온다. -->
		<c:forEach items="${result}" var="guestbook">
			<tr>
				<td>${guestbook.email}</td>
				<td>${guestbook.txt}</td>
				<td>
					${guestbook.regdate}<br>
					${guestbook.modified}
				</td>
				<td>
					<form action="/guestbook/update" method="POST">
						<input type="hidden" name="no" value="${guestbook.no}">
						<input type="text" name="txt" placeholder="수정할 내용을 입력하세요">
						<input type="password" name="passwd" placeholder="비밀번호를 입력하세요">
						<input type="submit" value="수정">
					</form>
				</td>
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