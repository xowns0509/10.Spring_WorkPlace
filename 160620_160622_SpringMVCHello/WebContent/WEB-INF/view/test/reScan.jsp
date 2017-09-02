<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>reScan.jsp</title>
</head>
<body>

	안녕해? 나는 reScan.do에서 왔음

	<br />
	<br />AutoScanController에서 userId세션에 저장 후 여기서(reScan.jsp) 불러오기
	<br />${sessionScope.userId }
	<br />
	<br />AutoScanController에서 memberVo.getName()로 추출,
	<br />IdFromMemberVoGetName세션에 저장하여 여기서(reScan.jsp) 불러오기
	<br />${sessionScope.IdFromMemberVoGetName }

</body>
</html>