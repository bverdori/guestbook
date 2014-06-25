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
		<tr>
			<td><p>${guestbook.email }</p></td>
			<td><p>${guestbook.text }</p></td>
			<td><p></p></td>
			<td><p></p></td>
		</tr>
	</tbody>
</table>

</body>
</html>
