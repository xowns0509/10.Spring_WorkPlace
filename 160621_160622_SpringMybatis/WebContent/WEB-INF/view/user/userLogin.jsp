<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 첫 페이지 </title>
<link rel="stylesheet" href="../style/stylecss.css" type="text/css">
<style>
	table{border:#FF9900 double }
	td{text-align:center;padding:5}
</style>

</head>
<script>
	function check(){
		if(document.form.userId.value==""){
			alert("ID를 입력하세요.")
			document.form.userId.focus();
			return false;
		}
		
		if(document.form.userPass.value==""){
			alert("패스워드를 입력하세요.")
			document.form.userPass.focus();
			return false;
		}
		
		document.form.submit();//전송
		
	}
	
	
</script>
<body>
<center>
<h4> 안녕하세요. 우리 홈페이지입니다.<p>
 사이트에 접속하기 위해서 사용자 인증 절차가 필요합니다.<p>
아이디와 패스워드를 입력하세요.</h4>

<form name="form" action="login.do" method="post" onSubmit="return check()">
  <table width="300" height="120" >
    <tr> 
      <td width="100"> 아이디</td>
      <td ><input type="text" name="userId"></td>
    </tr>
    
	<tr> <td>  패스워드</td>
      <td> <input type="password" name="userPass"></td>
    </tr>
  <tr>
  <td colspan=2>
    <input type="submit" name="Submit" value="로그인">
    <input type="button"  value="회원가입" onclick="location.href='userJoin.do'">
    <input type="reset" value="취소">
	
</td>
 </tr>
  </table>
  </form>
</center>
</body>
</html>

















