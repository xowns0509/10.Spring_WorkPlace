<%@ page contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<html>
<head><title>  </title></head>

<script src="../boardstyle/board.js"></script>

<body>
<center><h1>글 삭 제 하 기</h1>
<form name="form" method="post"action="delete_ok.do">

<table border="0" cellpadding="0" cellspacing="0">
<tr height="50">
  <td colspan="2" align="left">
  <b>  >> 암호를 입력하세요. <<  </b>
  </td>
 </tr> 
<tr>
  <td width="80">암&nbsp;&nbsp;호</td>
  <td>
  <input type="password" name="b_pwd" maxlength="12" size="12"></td>
  </td>
</tr> 

<tr height="50" align="center">
  <td colspan="2">
  <input type="button" value="글삭제" onclick="delete_ok()"> &nbsp;&nbsp;&nbsp;
  <input type="reset"  value="다시작성"> &nbsp;
  <input type="button" value="뒤로" onclick="history.back()">
  </td>
</tr>        
</table>

<input type="hidden" name="b_id" value="${param.b_id}"/>
 
</form>

</body>
</html>






