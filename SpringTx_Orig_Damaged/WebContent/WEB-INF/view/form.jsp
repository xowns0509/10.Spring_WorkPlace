<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>입력폼</title>
</head>
<body>
	
	<form method="post" action="transfer.do">
	
		*ID (unique): <input type="text" name="id"><br/>
		PWD:  <input type="text" name="password"><br/>
		NAME:   <input type="text" name="name"><br/>
		ADDR :<input type="text" name="address"><br/>		    
		*SSN (unique):<input type="text" name="ssn"><br/>
		
		    <input type="submit">
	</form>
</body>
</html>