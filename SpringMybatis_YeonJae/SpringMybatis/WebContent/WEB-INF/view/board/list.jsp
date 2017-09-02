
<%@page import="java.text.NumberFormat"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<html>
<head><title>  </title></head>

<link href="../boardstyle/stylecss.css" rel="stylesheet" type="text/css" >
<script>
 function show_Action(no){
	 document.read.b_id.value= no;
	 document.read.submit();//전송하기
	 
 }
 
 
 //검색부분의 찾기 버튼 클릭했을때
 function check(){
      if (document.search.keyWord.value == ""){
 		 alert("검색어를 입력하세요.");
 		 document.search.keyWord.focus();
 		 return;
 	    }
 	 document.search.submit();
  }

</script>

<c:url value="write.do" var="write"/>
<c:url value="list.do" var="list"/>
<body>

<c:if test="${sessionScope.userName == null}">
   <script>
     location.href="../user/userLogin.do";
   </script>
</c:if>
<center>
<h2>[ Spring MVC를 이용한 자료실 ]</h2>
<table width="900">
<tr>
<td align="right">
 [ ${sessionScope.sessionTime} ] ${userName}님 &nbsp; &nbsp;
 <a href="../user/logOut.do">[로그아웃]</a>
</td>
</tr>
<tr>
<td align="right">
<a href="${write}" align="right"> [ 글 쓰 기 ]</a>
<a href="${list}" align="right"> [ 처음으로 ] </a>
</td>
</tr>
</table>

<table width="900" border="1" cellpadding="0" cellspacing="0">
  <tr height="25" >
	  <td width="40" align="center">번호</td>
	  <td width="250" align="center">글제목</td>
	  <td width="200" align="center">파일이름</td>
	  <td width="100" align="center">파일용량</td>
	  <td width="120" align="center">작성자</td>
	  <td width="130" align="center">작성일</td>
	  <td width="60" align="center">조회수</td>  
</tr>
	
	
      <c:choose>
        <c:when test="${listModel == null}">
            <tr><td colspan='7'>등록된 게시물이 없습니다.</td></tr>
        </c:when>
        <c:otherwise>
           <c:forEach items="${listModel}" var="a" >
			<tr height="25" 
			onMouseOver="this.style.background='pink'"
			onMouseOut="this.style.background='white'">
				<td align="center">${a.b_id}</td>
				<td align="left"> 
				 <a href="view.do?b_id=${a.b_id}">
				     ${a.b_title}
				  </a>
				</td>
				
				<td>
				 <c:choose>
				    <c:when test="${a.b_fsize==0}">첨부파일 없음</c:when>
				    <c:otherwise><img src="../img/disk.gif">${a.b_fname}</c:otherwise>
				 </c:choose>
				  
				</td>
				
				<td>
				  <fmt:formatNumber value="${a.b_fsize}" />byte
				</td>
					
				<td align="center">
					<a href="mailto:${a.b_email}">
					${a.b_email}
					</a>
				</td>
				<td align="center">${a.b_date}</td>
				<td align="center">${a.b_count}</td>  
			</tr>   
			</c:forEach>
        </c:otherwise>
      </c:choose>
       
		   
	 
</table>


<!-- 검색 부분 -->
<form action="list.do" name="search" method="post">
<table border=0 width=527 align=center cellpadding=4 cellspacing=0 >
 <tr>
  <td align=center valign=bottom>
   <select name="keyField" size=1 >
    <option value="b_name"> 이 름
    <option value="b_title"> 제 목
    <option value="b_content"> 내 용
   </select>
   <input type="text" size=16 name="keyWord"  value="">
   <input type="button"  value="찾기" onClick="check()">
  </td>
 </tr>
</table>
</form>


</center>
</body>
</html>






