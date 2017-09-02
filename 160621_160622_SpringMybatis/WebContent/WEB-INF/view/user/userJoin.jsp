<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>사용자 등록</title>
<link rel="stylesheet" href="../style/stylecss.css" type="text/css">
<script type="text/javascript" src="../style/jquery-1.7.1.js" ></script>
<script type="text/javascript" src="../style/js_userinput.js" charset='euc-kr'></script>

</head>

<body bgcolor="#FFFFFF">
<center>
<table width="570" border="0" cellspacing="0" cellpadding="5">
  <tr bgcolor="#3399CC"> 
    <td height="30" class="normalbold"><font color="#FFFFFF">사용자 정보입력</font></td>
  </tr>
  <tr>
    <td class="normal">안녕하세요. 우리 홈페이지를 자유롭게 이용하려면 회원가입을 하셔야 합니다.<br>
      아래의 사항들을 빠짐없이 기록해 주세요.</td>
  </tr>
</table>
<form method="post" action="userInsert.do" name="userinput" id="userinput">
  <table width="570" border="1" cellspacing="0" cellpadding="3" bordercolor="#000000">
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">사용자 ID</div>
      </td>
      <td colspan="3" class="normal"> 
        <input type="text" name="userId" id="userId" size="20" 
        onkeyup="idDuplicateCheck()">
        <span id="idCheckResult" style="width:150px;color:red"></span>
        
      <!--   <input type="text" name="userId" id="userId" size="20" >
        <span id="idCheckResult" style="width:150px;color:red"></span> -->
      </td>
    </tr>
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">비밀번호</div>
      </td>
      <td width="154" class="normal"> 
        <input type="password" name="userPass" id="userPass">
      </td>
      <td width="141" class="normalbold" bgcolor="#FFCCCC"> 
        <div align="center">비밀번호 확인</div>
      </td>
      <td width="160"> 
        <input type="password" name="userPass2" id="userPass2">
      </td>
    </tr>
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179" height="23"> 
        <div align="center">사용자 이름</div>
      </td>
      <td colspan="3" height="23" class="normal"> 
        <input type="text" name="userName" id="userName">
      </td>
    </tr>
    
      <td colspan="4" class="normal"> 
        <div align="center"> 
          <input type="button" name="confirm" value="등   록" OnClick="javascript:checkUserInput()">
          <input type="reset" name="reset" value="취   소">
        </div>
      </td>
    </tr>
  </table>
</form>
</center>
</body>
</html>
