<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>bbsList.jsp</title>
<style type="text/css">
	#bbsList { width: 500px; margin: auto;}
	#bbsList table{width: 100%; border: 1px dotted #9900ff}
	#bbsList table thead {
		background-color: #b9b9ff; 
	}
</style>
</head>
<body>

<%-- <c:choose> --%>
<%-- 	<c:when test="${pageContext.request.userPrincipal.name != null}"> --%>
<%-- 	<c:url var="logoutAction" value="/j_spring_security_logout"></c:url> --%>
<%-- 	${principal}  --%>
<%-- 	<form action="${logoutAction}" method="post"> --%>
<!-- 		<input type="submit" value="Logout" /> -->
<!-- 	</form> -->
		
<%-- 	</c:when> --%>
<%-- 	<c:otherwise> --%>
<%-- 	<c:url var="logoutAction" value="/login"></c:url> --%>
<%-- 		<form action="${logoutAction}" method="post"> --%>
<!-- 		<input type="submit" value="Login" /> -->
<!-- 	</form> -->
<%-- 	</c:otherwise> --%>
<%-- </c:choose> --%>
	<div id="bbsList">
		<table>
			<thead>
				<tr><th colspan="5"> Bbs List </th></tr>
				<tr>
					<td>��ȣ</td><td>����</td><td>�ۼ���</td>
					<td>��ȸ��</td><td>�ۼ���¥</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="listv" items="${list}">
				<tr>
				<td>${listv.num}</td>
				<td><a href="bbsDetail?num=${listv.num}">${listv.sub}</a></td>
				<td>${listv.writer}</td>
				<td>${listv.hit}</td>
				<td>${listv.regdate}</td>
				</tr>
			</c:forEach>	
			</tbody>
			<tfoot>
			
			<!-- ����¡ -->
			<!-- shoplist.kosta�� �ϰ������� bbs1List�� �ٲ� -->
			
			<tr>
					<td colspan="6" style="text-align: center">
						<%--Page ���� ������ ���� --%> <c:choose>
							<c:when test="${searchType == null}">
								<c:choose>
									<c:when test="${pageInfo.currentBlock eq 1}">
                    ��
                           </c:when>
									<c:otherwise>
										<a
											href="bbsList?page=
         ${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock }">
											��</a>
									</c:otherwise>
								</c:choose>

								<%--Page  ������ ���� --%>
								<c:choose>
									<c:when test="${pageInfo.currentBlock ne pageInfo.totalBlocks}">
										<c:forEach begin="1" end="${pageInfo.pagesPerBlock}"
											varStatus="num">
                        [<a
												href="bbsList?page=${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">
												${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a>]
                       </c:forEach>
									</c:when>
									<c:otherwise>
										<c:forEach
											begin="${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock + 1}"
											end="${pageInfo.totalPages}" varStatus="num">
                        [<a
												href="bbsList?page=${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">
												${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }</a>]
                    </c:forEach>
									</c:otherwise>
								</c:choose>


								<%--Page ���� ������ ���� --%>
								<c:choose>
									<c:when test="${pageInfo.currentBlock eq pageInfo.totalBlocks}">
               ��
                </c:when>
									<c:otherwise>
										<a
											href="bbsList?page=${pageInfo.currentBlock * pageInfo.pagesPerBlock + 1 }">
											��</a>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>

								<c:choose>
									<c:when test="${pageInfo.currentBlock eq 1}">
                    ����
                           </c:when>
									<c:otherwise>
										<a
											href="bbsList?searchType=${searchType}&searchValue=${searchValue}&page=
         ${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock }">
											��</a>
									</c:otherwise>
								</c:choose>

								<%--Page  ������ ���� --%>
								<c:choose>
									<c:when test="${pageInfo.currentBlock ne pageInfo.totalBlocks}">
										<c:forEach begin="1" end="${pageInfo.pagesPerBlock}"
											varStatus="num">
                        [<a
												href="bbsList?searchType=${searchType}&searchValue=${searchValue}&page=
                        ${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">
												${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a>]
                       </c:forEach>
									</c:when>
									<c:otherwise>
										<c:forEach
											begin="${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock + 1}"
											end="${pageInfo.totalPages}" varStatus="num">
                        [<a
												href="bbsList?searchType=${searchType}&searchValue=${searchValue}&page=${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">
												${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }</a>]
                    </c:forEach>
									</c:otherwise>
								</c:choose>


								<%--Page ���� ������ ���� --%>
								<c:choose>
									<c:when test="${pageInfo.currentBlock eq pageInfo.totalBlocks}">
               ����
                </c:when>
									<c:otherwise>
										<a
											href="bbsList?searchType=${searchType}&searchValue=${searchValue}&page=${pageInfo.currentBlock * pageInfo.pagesPerBlock + 1 }">
											��</a>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>




					</td>
				</tr>
			
			
			
			
			
			
			
				<tr><td colspan="5">
					<input type="button" value="write" 
					onclick="location='bbsForm'">
				</td></tr>
			</tfoot>
		</table>
	</div>
</body>
</html>