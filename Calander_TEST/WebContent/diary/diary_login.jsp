<%@ page info="diary calendar" %>
<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page language="java" import="java.sql.*,java.io.*,java.net.*,java.util.*" %>

<jsp:useBean id = "myutil" class="MyBeans.MyUtil" scope="request" />  

<%
	String mode               = myutil.checkNull(request.getParameter("mode"));
	String id                     = myutil.checkNull2(request.getParameter("id"));
	String year                 = myutil.checkNull(request.getParameter("year"));
	String month              = myutil.checkNull(request.getParameter("month"));
	String day                  = myutil.checkNull(request.getParameter("day"));
	String subject            = myutil.toKorean(request.getParameter("subject"));
	String contents          = myutil.toKorean(request.getParameter("contents"));
	
%>


<html>
<head>
<title>notice</title>

<style type="text/css">
<!--
A:link{font-size:9pt; font-family:"����"; text-decoration:none;color:#3E3E3E}
A:visited{font-size:9pt; font-family:"����"; text-decoration:none;color:#3E3E3E}
A:hover {font-size: 9pt; font-family:"����"; text-decoration: underline;color: #F29708;}

.title {font-size: 9pt; font-family:"����"; color:#504F4F}
-->
</style>

<script language="javascript">
<!--
var KeyUp1=false;
var MouseUp1=false;
//-->
</script>


<script language="JavaScript">
<!--
	function checkValue()
	{
		f = document.loginform;
		if(!f.log_id.value)
		{
			alert('���̵��� �Է��ϼ���.');
			f.log_id.focus();
			return false;
		}
		if(!f.passwd.value)
		{
			alert('�н����带 �Է��ϼ���.');
			f.passwd.focus();
			return false;
		}
	}
//-->
</script>


</head>
<body LEFTMARGIN="0"TOPMARGIN="0" MARGINWIDTH="0" MARGINHEIGHT="0">
<table width="235" height="180" border="0" cellspacing="0" cellpadding="0" align="center">
	<tr>
		<td align="center" valign="top">
		
			<form name="loginform" method=post action="diary_logchk.jsp?mode=<%= mode %>" onSubmit="return checkValue()" >
			<table border="0" cellspacing="0" cellpadding="0" align="center" width="210" height="133">
				<tr>
					<td width="210" height="5"></td>
				</tr>
				<tr>
					<td width="210" height="3" bgcolor="#44A5E9"></td>
				</tr>
				<tr>
					<td width="210" height="2" bgcolor="#D2FCFC"></td>
				</tr>
				<tr>
					<td height="20" aling="center" valing="middle" class="title">�α���					
					</td>
				<%
					if (mode.equals("insert")) {
				%>	
						<input type = "hidden" name="id" value="<%= id %>">
						<input type = "hidden" name="year" value= "<%= year %>">
						<input type = "hidden" name="month" value="<%= month %>" >
						<input type="hidden" name="day" value="<%= day %>" >
				<%
					} else {																
				%>
						<input type="hidden" name="id" value="<%= id %>" >
				<%
					}
				%>		
				</tr>
				<tr>
					<td height="90">
					
					<div align="center">
					<table border="0" cellspacing="0" cellpadding="0" align="center" width="200">
						<tr>
							<td width="200" class="title" align="center">
								���̵�&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;<input type="text" name="log_id" size="15" class="title">
							</td>
						</tr>
						<tr>
							<td width="200" class="title" align="center">
								�н����� :</font>&nbsp;&nbsp;<input type="password" name="passwd" size="15" class="title">
							</td>
						</tr>
					</table>
					</div>
					
					
					</td>
				</tr>
				<tr>
					<td width="210"></td>
				</tr>
				<tr>
					<td width="210" height="1" bgcolor="#A6E6E6"></td>
				</tr>
			</table>
			<table border="0" cellspacing="0" cellpadding="0" align="center" width="210" height="25">				
				<tr>
					<td height="25" align="center">
						<input type="submit"  value="Ȯ��" class="title">
						<input type="button" value="���" class="title" onClick="history.back()">
					</td>
				</tr>
				<tr>
					<td width="210" height="1" bgcolor="#D2FCFC"></td>
				</tr>
				<tr>
					<td wdith="210" height="2" bgcolor="#44A5E9"></td>
				</tr>
			</table>
			</form>
		
		</td>
	</tr>
</table>
		
<script language="JavaScript">
<!--
if ( KeyUp1 == false && MouseUp1 == false)
{
	document.loginform.log_id.focus();
}
//-->
</script>
</body>
</html>










