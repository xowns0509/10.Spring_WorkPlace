
<%@ page contentType="text/html;charset=euc-kr" %>

<html>
<head><title></title></head>
<link href="../boardstyle/stylecss.css" rel="stylesheet" type="text/css" >
<script src="../boardstyle/board.js"></script>
<body>
<center>
<form name="update" method="post"  encType="multipart/form-data" >
<table border="1" cellpadding="0" cellspacing="0" width="600">
 <caption><h1 style="background:pink">�� �� �� �� ��</h1></caption>
  <tr height="30" align="center">
  <td width="100">�۹�ȣ</td>
  <td width="200">${model.b_id }</td>
  <td width="100">�̸���</td>
  <td width="200" align="left"><input type="text" name="b_email" value="${model.b_email }"></td>
  </tr>
  
  <tr height="30"  align="center">
  <td width="100">�ۼ���</td>
  <td width="200" align="left"><input type="text" name="b_name" value="${model.b_name }"></td>
  <td width="100">�ۼ���</td>
  <td width="200">${model.b_date }</td>
  </tr>
  
  <tr height="30">
  <td width="100" align="center">������</td>
  <td colspan="3">
 <input type="text" name="b_title" value="${model.b_title }" size="30">
   </td>
  </tr>
  
  <tr height="25">
  <td width="100"  align="center">�۳���</td>
  <td colspan="3">
  	<textarea name="b_content"  rows="10"  
  	 style="width:500">${model.b_content }</textarea>
  </td>
  </tr>
  
  <tr height="60">
     <td width="80" align="center">��  ��</td>
     <td colspan="3"><br>
      &nbsp;&nbsp;${model.b_fname }<br>
      &nbsp;&nbsp;
     <input type="file" name="file" maxlength="60" size="40" >
     </td>
  </tr>
  
   <tr height="30">
  <td width="100" align="center">��й�ȣ</td>
  <td colspan="3">
     <input type="password" name="b_pwd" value="">
   </td>
  </tr> 
  <tr height="30">
  <td colspan="4" align="right">
  <input type="button" value="�����Ϸ�"  onclick="update_Action()">
    &nbsp;&nbsp;&nbsp;&nbsp;
  <input type="button" value="�ڷ�"  onclick="history.back()">
    &nbsp;&nbsp;&nbsp;&nbsp;  
  
  </td>
  </tr>
</table>
  <input type="hidden" name="b_id" value="${param.b_id}"/>
 </form>


</body>
</html>









