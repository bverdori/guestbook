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

<table>
	<thead>
		<tr>
			<td><input type="text" placeholder="E-mail"></td>
			<td><input type="password" placeholder="Password"></td>
			<td><input type="text" placeholder="Contents"></td>
			<td><input type="button" value="submit"></td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><p>E-mail</p></td>
			<td><p>contents</p></td>
			<td><p>update</p></td>
			<td><p>delete</p></td>
		</tr>
	</tbody>
</table>
</body>
</html>
