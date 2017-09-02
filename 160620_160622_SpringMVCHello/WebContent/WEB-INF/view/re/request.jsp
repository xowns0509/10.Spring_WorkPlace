<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>c.jsp</title>
</head>
<body>
	이것이 바로 request.jsp
	<br /> 아이디: ${vo.id}
	<br /> 이름: ${vo.name}
	<br /> 나이: ${vo.age}

	<br /> 아이디: ${param.id}
	<br /> 이름: ${param.name}
	<br /> 나이: ${param.age}

	<br /> 아이디: ${memberVO.id}
	<br /> 이름: ${memberVO.name}
	<br /> 나이: ${memberVO.age}

	<br /> 아이디: ${srs.id}
	<br /> 이름: ${srs.name}
	<br /> 나이: ${srs.age}
</body>
</html>