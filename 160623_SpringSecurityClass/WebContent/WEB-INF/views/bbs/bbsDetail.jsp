<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>bbsDetail.jsp</title>
<style type="text/css">
#bbsDetail {
	width: 550px;
	margin: auto
}

#bbsDetail table {
	width: 100%;
	border: 1px dotted #9900ff
}

#bbsDetail table .fd {
	width: 100px;
	background-color: #b9b9ff;
	font-weight: bold;
	text-align: center
}

#sub {
	width: 250px;
}
</style>
</head>
<body>
<%-- <c:choose> --%>
<%-- <c:when test="${pageContext.request.userPrincipal.name != null}"> --%>
<%-- <c:set var="writer" value="${pageContext.request.userPrincipal.name}"></c:set> --%>
<%-- </c:when> --%>
<%-- </c:choose> --%>
	<div id="bbsDetail">
		<table>
			<thead>
				<tr>
					<th colspan="2">Bbs View </th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="fd">�� ��</td>
					<td>${vo.sub}</td>
				</tr>
				<tr>
					<td class="fd">�� �� ��</td>
					<td>${vo.writer}</td>
				</tr>
				<tr>
					<td class="fd">�ۼ� ��¥</td>
					<td>${vo.regdate}</td>
				</tr>
				<tr>
					<td class="fd">�� ��</td>
					<td>${vo.cont}</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2"><input type="button" value="write"
						onclick="location='bbsForm'"> &nbsp; <input type="button"
						value="list" onclick="location='bbsList'"></th>
				</tr>
			</tfoot>
		</table>






		<form method="post" action="bbsComm">
			<input type="hidden" name="kcode" value="${vo.num}"> <input
				type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
			<table>
				<tr>
					<td>
						<!-- �� ��  --> <select name="cnt">
							<option value="5">�ڡڡڡڡ�</option>
							<option value="4">�ڡڡڡڡ�</option>
							<option value="3" selected="selected">�ڡڡڡ١�</option>
							<option value="2">�ڡڡ١١�</option>
							<option value="1">�ڡ١١١�</option>
					</select>
					</td>
					<td><input name="writer" size="15" value="${writer }"></td>
					<td><textarea rows="3" cols="30" name="comm"></textarea></td>
					<td><input type="submit" value="�ۼ�"></td>
				</tr>
			</table>
		</form>
		<table>
			<c:forEach var="coList" items="${cList}">
				<tr>
					<td><c:choose>
							<c:when test="${coList.cnt == 5}">�ڡڡڡڡ� </c:when>
							<c:when test="${coList.cnt == 4}">�ڡڡڡڡ� </c:when>
							<c:when test="${coList.cnt == 3}">�ڡڡڡ١� </c:when>
							<c:when test="${coList.cnt == 2}">�ڡڡ١١� </c:when>
							<c:when test="${coList.cnt == 1}">�ڡ١١١� </c:when>
						</c:choose></td>
					<td>${coList.comm}</td>
					<td>${coList.writer}</td>
					<td>${coList.regdate}/${coList.reip}</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>