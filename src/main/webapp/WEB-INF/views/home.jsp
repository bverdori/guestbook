<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Guest Book!</title>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
</head>
<body>
	<h1>
		Guest Book!
	</h1>

<form action="addText" method="post">
	<input type="text" placeholder="E-mail" name="email">
	<input type="password" placeholder="Password" name="passwd">
	<input type="text" placeholder="Contents" name="text">
	<input type="submit" value="submit">
</form>

<table>
	<tbody>
		<c:forEach var="guestbook" items="${guestBookList}">
		<tr>
			<td><p>${guestbook.no}</p></td>
			<td><p>${guestbook.email}</p></td>
			<td><p>${guestbook.text}</p></td>
			<td><p>${guestbook.regdate}</p></td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>
