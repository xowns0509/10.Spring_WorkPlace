<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Login Page</title>
<style type="text/css">
	#loginWrap { width: 500px; margin: auto;}
	#loginWrap table{width: 100%; border: 1px dotted #9900ff}
	#loginWrap table thead {
		background-color: #b9b9ff; 
	}
</style>
</head>
<body>
<div id="loginWrap">
	<h3>Login with UserID and Password</h3>
	<c:url var="loginUrl" value="/j_spring_security_check"></c:url>
	
	<form action="${loginUrl}" method="POST">
		<table>
			<tr>
				<td>User ID:</td>
				<td><input type='text' name='username' /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>