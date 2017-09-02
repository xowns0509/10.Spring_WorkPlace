<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>multiInsert.jsp</title>
</head>
<body>
	나는 multiInsert.do에서 왔음

	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>AGE</th>
		</tr>

		<c:if test="${memberVOList!=null}">

			<c:forEach items="${memberVOList.list}" var="memb">

				<c:if test="${memb.state == true}">

					<tr>
						<td>${memb.id}</td>
						<td>${memb.name}</td>
						<td>${memb.age}</td>
					</tr>
				</c:if>
			</c:forEach>
		</c:if>

		<c:forEach var='vo' items='memberVOList.list'>
		<!--  memberVOList 이건 MemberVOList란 클래스명에서 스프링이 앞의 글자만 소문자로 자동으로 바꿔서 객체 생성한다 했잖아. 이 페이지 전의 컨트롤 -->
		<!-- memberVOList.getList로, get함수가 불려져야 하는 데,
		 그걸 그냥 .list로 써도 된다고 -->
			<tr>
				<c:if test="${vo.state}">
					<td>${vo.id}</td>
					<td>${vo.name}</td>
					<td>${vo.age}</td>
				</c:if>
			</tr>
		</c:forEach>


	</table>



</body>
</html>