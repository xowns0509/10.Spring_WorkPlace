<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ü</title>
</head>
<body>

	<form method="post" action="transfer.do">
	
		������ ��� :<input type="text" name="send_num" value="111-11-1111"><br/>
		������ ���� :<input type="text" name="send_customer" value="ȫ�浿"><br/>
		�ݾ� : <input type="text" name="amount"><br/>
		
		�޴� ��� : <input type="text" name="recv_num" value="999999-999"><br/>
		�޴� ���� : <input type="text" name="recv_customer" value="����"><br/>
		
		    <input type="submit">
	</form>
	
</body>
</html>