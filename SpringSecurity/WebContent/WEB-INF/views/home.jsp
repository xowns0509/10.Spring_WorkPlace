<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<title>Home</title>
<style type="text/css">
	#homeWrap { width: 500px; margin: auto;}
	#homeWrap table{width: 100%; border: 1px dotted #9900ff}
	#homeWrap table thead {
		background-color: #b9b9ff; 
	}
</style>
</head>
<body>
	<div id="homeWrap">
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>

	<p>
		<a href="emp/get/20">관리자 모드</a>
	</p>
    <p>
		<a href="bbsList">회원용 게시판</a>
	</p>
	</div>
</body>
</html>
