<%@ page contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<html>
<head><title>  </title></head>

<script src="../boardstyle/board.js"></script>

<body>
<center><h1>�� �� �� �� ��</h1>
<form name="form" method="post"action="delete_ok.do">

<table border="0" cellpadding="0" cellspacing="0">
<tr height="50">
  <td colspan="2" align="left">
  <b>  >> ��ȣ�� �Է��ϼ���. <<  </b>
  </td>
 </tr> 
<tr>
  <td width="80">��&nbsp;&nbsp;ȣ</td>
  <td>
  <input type="password" name="b_pwd" maxlength="12" size="12"></td>
  </td>
</tr> 

<tr height="50" align="center">
  <td colspan="2">
  <input type="button" value="�ۻ���" onclick="delete_ok()"> &nbsp;&nbsp;&nbsp;
  <input type="reset"  value="�ٽ��ۼ�"> &nbsp;
  <input type="button" value="�ڷ�" onclick="history.back()">
  </td>
</tr>        
</table>

<input type="hidden" name="b_id" value="${param.b_id}"/>
 
</form>

</body>
</html>






