<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>bbsForm.jsp</title>
<style type="text/css">
	#bbs { width: 650px; margin: auto}
	#bbs table { width: 100%; border: 1px dotted  #9900ff}
	#bbs table .fd {width:100px; background-color: #b9b9ff; 
	font-weight: bold; text-align: center}
	#sub { width: 250px;}
</style>
<script src="//cdn.ckeditor.com/4.4.7/full/ckeditor.js"></script>
<script>
// window.onload=function(){
// 	CKEDITOR.replace('cont', {
// 		height: '500px' ,
// 		filebrowserImageUploadUrl: 'imageUpload'
// 	})
// };
</script>
</head>
<body>
<%-- <c:choose> --%>
<%-- <c:when test="${pageContext.request.userPrincipal.name != null}"> --%>
<%-- <c:set var="writer" value="${pageContext.request.userPrincipal.name}"></c:set> --%>
<%-- </c:when> --%>
<%-- </c:choose> --%>
	<div id="bbs">
		<form method="post" action="bbsIn">
		<input type="hidden" name="reip" value="<%=request.getRemoteAddr() %>">
			<table>
				<thead>
					<tr>
						<th colspan="2">
							Bbs �Է���
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
					<td class="fd">�� ��</td>
					<td>
						<input name="sub" id="sub">
					</td>
					</tr>
					<tr>
					<td class="fd">�� �� ��</td>
					<td>
						<input name="writer" id="writer" value="${writer }">
					</td>
					</tr>
					<tr>
					<td class="fd">�� �� �� ȣ</td>
					<td>
						<input name="pwd" id="pwd" type="password" maxlength="10">
					</td>
					</tr>
					<tr>
					<td class="fd">�� ��</td>
					<td>
						<textarea rows="20" cols="20" name="cont" id="cont"></textarea>
					</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
					<th colspan="2"><input type="submit" value="send">
						&nbsp;
						<input type="button" value="list" 
											onclick="location='bbsList'">
					</th>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>