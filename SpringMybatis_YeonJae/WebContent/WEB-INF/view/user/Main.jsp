<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
  a{text-decoration: none}
</style>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<center>
<h1>로그인 결과</h1>



<table width="500">
<tr>
<th>
 [ ${sessionScope.sessionTime} ] ${userName}님 &nbsp; &nbsp;
</th>
</tr>
<tr>
<th>
 <a href="logOut.do">[로그아웃]</a> &nbsp;&nbsp;
  <a href="memberInfo.do">[회원정보]</a>
  <a href="../board/list.do">[게시판]</a>
</th>
</tr>
</table>


<c:if test="${list!=null}">
  <h2>[ 회원정보 ]</h2>
   <table>
    <tr>
       <!--  <th>UserNo</th>-->
       <th>UserId</th>
       <th>UserName</th>
       <th>UserPass</th>
      <!--  <th>UserDate</th>--> 
     </tr>
   <c:forEach items="${list}" var="vo">
     <tr>
       
       <td>${vo.userId}</td>
       <td>${vo.userName}</td>
       <td>${vo.userPass}</td>
       
     </tr>
   </c:forEach>
   </table>
   <p/>
   <form action="userSearch.do" method="post">
   <select name="keyField">
      <option value="0">--선택--</option>
      <option value="userName">이름</option>
      <option value="userId">아이디</option>
   </select>
   <input type="text" name="keyWord"/>
   <input type="submit" value="검색"/>
   </form>
</c:if>

</center>
</body>
</html>







