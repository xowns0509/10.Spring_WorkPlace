<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>autoScan.jsp</title>
</head>
<body>
	이 페이지가 autoScan임. 여기가 불려요
	
	<hr />
	memberVO로 불렸을 때
	<br /> 아이디: ${memberVO.id }
	<br /> 이름: ${memberVO.name }
	<br /> 나이: ${memberVO.age }

	<hr />
	mVO로 불렸을 때
	<br /> 아이디: ${mVO.id }
	<br /> 이름: ${mVO.name }
	<br /> 나이: ${mVO.age }

	<hr />
	param로 불렸을 때.
	<br /> 아이디: ${param.id }
	<br /> 이름: ${param.name }
	<br /> 나이: ${param.age }
</body>
</html>