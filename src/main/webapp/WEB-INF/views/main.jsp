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
// ���� �Է¿� ���� Ŭ���̾�Ʈ �� �Է°� üũ
$(document).ready(function() {
	$("form#form_insert").bind("submit", function () {
		email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
		
		// E-mail, ��й�ȣ, ���� �Է� Ȯ�� (������ ��� ���â ����)
		if ($("input#email").val().trim() == "") {
			alert("�̸����ּҸ� �Է��� �ּ���.");
			$("input#email").focus();
			return false;
		} else if ($("input#passwd").val().trim() == "") {
			alert("��й�ȣ�� �Է��� �ּ���.");
			$("input#passwd").focus();
			return false;
		} else if ($("input#txt").val().trim() == "") {
			alert("������ �Է��� �ּ���.");
			$("input#txt").focus();
			return false;
		} 
		// E-mail ���� üũ (���� ����ġ�� ��� ���â ����)
		else if(!email_regex.test($("input#email").val().trim())){
			alert("�̸��� ������ ���� �ּ���.");
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
		<h3>���� �Է�</h3>
		<label>E-mail&nbsp;&nbsp;&nbsp;</label><input type="text" name="email" id="email"><br>
		<label>��й�ȣ&nbsp;</label><input type="password" name="passwd" id="passwd"><br>
		<label>����&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="txt" id="txt" size="100">
		<input type="submit" value="����"><br>
	</form>
	
	<hr>
	
	<table style="border:1px gray solid;">
		<tr>
			<td align="center" style="border:1px gray solid;">E-mail</td>
			<td align="center" style="border:1px gray solid;">����</td>
			<td align="center" style="border:1px gray solid;">�ۼ���/������</td>
			<td align="center" style="border:1px gray solid;">����</td>
			<td align="center" style="border:1px gray solid;">����</td>
		</tr>
		<!-- result�� contoller�� addObject�� ���� �����´�. -->
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
						<input type="text" name="txt" placeholder="������ ������ �Է��ϼ���">
						<input type="password" name="passwd" placeholder="��й�ȣ�� �Է��ϼ���">
						<input type="submit" value="����">
					</form>
				</td>
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