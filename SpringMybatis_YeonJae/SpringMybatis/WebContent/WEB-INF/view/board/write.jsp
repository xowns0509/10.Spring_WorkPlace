
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title></title>
<!-- 폼에 입력된 정보가 올바른지 판단하는 자바스크립트 부분 -->
<script language="JavaScript" src="../boardstyle/board.js" charset='euc-kr'></script>
<link href="../boardstyle/stylecss.css" rel="stylesheet" type="text/css" >
</head>



<body>
<center>

<form name="form" method="post"  action="write_ok.do" 
   enctype="multipart/form-data">
<table border="0" cellpadding="0" cellspacing="0">
<caption>
<h1 style="background:pink">
    자료실 글 올 리 기
 </h1>
 </caption>
<tr height="30">
  <td width="80">작성자</td>
  <td width="140">
  <input type="text" name="b_name" maxlength="15" size="10" value="${userName}" readonly></td>
  
  <td width="80">이메일</td>
  <td width="240">
  <input type="text" name="b_email" maxlength="30" size="24"></td>
</tr>

<tr height="30">
  <td width="80">글제목</td>
  <td colspan="3" width="460">
     <input type="text" name="b_title" maxlength="60" size="55"> 
  </td>
</tr>

<tr>
  <td colspan="4">
  <textarea wrap="hard" name="b_content" rows="10" cols="65"></textarea>
  </td>
</tr> 
<!-- 파일첨부 부분 추가 -->
 <tr height="30">
 <td width="80" style="color:red"><br>파일첨부</td>
 <td colspan="3">
   <br>
  <input type="file" name="file" maxlength="60" size="40">
 </td>
</tr> 
<!-- 파일첨부 부분 끝 -->
<tr>
  <td width="80">암&nbsp;&nbsp;호</td>
  <td colspan="3" width="460">
  <input type="password" name="b_pwd" maxlength="12" size="12">
  <input type="hidden" name="b_ip" 
       value="<%=request.getRemoteAddr()%>"> 
  </td>

</tr> 
<tr height="50" align="center">
  <td colspan="4" width="480">
  <input type="button" value="글쓰기" onclick="check_ok()"> &nbsp;
  <input type="reset"  value="다시작성"> &nbsp;
  <input type="button" value="글목록" onclick="location.href='list.do'">&nbsp;
  </td>
</tr>        
</table>
</form>
</center>
</body>
</html>