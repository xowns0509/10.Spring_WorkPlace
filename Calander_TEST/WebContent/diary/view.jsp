<%@ page info="diary calendar" %>
<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page language="java" import="java.sql.*,java.io.*,java.net.*,java.util.*" %>

<jsp:useBean id = "dbconn" class="MyBeans.DBConnect" scope="request" />
<jsp:useBean id = "myutil" class="MyBeans.MyUtil" scope="request" />  



<%

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String mode = myutil.checkNull(request.getParameter("mode"));
	String id = myutil.checkNull2(request.getParameter("id"));
	String member_id = myutil.checkNull((String)session.getAttribute("member_id"));
	String member_name = URLDecoder.decode(myutil.checkNull((String)session.getAttribute("member_name")));
	String member_email = myutil.checkNull((String)session.getAttribute("member_email"));	
	String year = new String();
	String month = new String();
	String day = new String();
	String subject = new String();
	String contents = new String();
	String created = new String();
	String userid = new String();
	String query = new String();	
	
	if (mode.equals("view")) {// start if
	

	
	//ȸ�� ���� üũ	
	//if (member_id.equals("") || member_name.equals("") || member_email.equals("")) {
	//	response.sendRedirect("login.jsp?ret_url=calendar.jsp");
	//}
	
	try {
		conn = dbconn.getConnection();
		stmt = conn.createStatement();
	} catch (SQLException e) {
	}
	
	try {
		query = "select * from diary where id = "+id;
		rs = stmt.executeQuery(query);
		
		if(rs.next()) {
			year = myutil.checkNull(rs.getString("year"));
			month = myutil.checkNull(rs.getString("month"));
			day = myutil.checkNull(rs.getString("day"));
			subject = myutil.checkNull(rs.getString("subject"));
			contents = myutil.checkNull(rs.getString("contents"));
			created = myutil.checkNull(rs.getString("created"));
			userid = myutil.checkNull(rs.getString("userid"));
		}
		rs.close();
		
		contents = myutil.n12br(contents);
	} catch(SQLException e) {
	} finally {
		dbconn.close();
	}
	
	} //end if
	
	if (mode.equals("insert")){
	
	year    = myutil.checkNull(request.getParameter("year"));
	month = myutil.checkNull(request.getParameter("month"));
	day    = myutil.checkNull(request.getParameter("day"));
	
	}
%>

<html>
<head>
<title>���̾</title>

<style type="text/css">
<!--
A:link{font-size:9pt; font-family:"����"; text-decoration:none;color:#3E3E3E}
A:visited{font-size:9pt; font-family:"����"; text-decoration:none;color:#3E3E3E}
A:hover {font-size: 9pt; font-family:"����"; text-decoration: underline;color: #F29708;}

.title {font-size: 9pt; font-family:"����"; color:#504F4F}
-->
</style>


</head>
<body LEFTMARGIN="0" TOPMARGIN="0" MARGINWIDTH="0" MARGINHEIGHT="0">
<table width="235" height="180" border="0" cellspacing="0" cellpadding="0" align="center">
	<tr>
		<td align="center" valign="top">
<!-- ��尡 insert�϶� ����-->
<%
	if (mode.equals("insert")){
%>
	<table width="210" height="145" border="0" cellspacing="0" cellpadding="0" align="center">
	
	
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
		<td width="210" height="50" align="left" class="title"><img src = "../jsp_img/point.gif" border="0" align="absmiddle">&nbsp;<%= year %>�� <%= month %>�� <%= day %>�� <br>&nbsp;&nbsp;��ĳ���� �����ϴ�.</td>
	</tr>
	<tr>
		<td width="210"></td>
	</tr>
	<tr>
		<td width="210" height="1" bgcolor="#A6E6E6"></td>
	</tr>
	
	
	<table>
	<table width="210"  height="25" border="0" cellspacing="0" cellpadding="0" align="center">
	
	
	<tr>
		<td width="210" height="20" align="center">		
			<a href="calendar.jsp"><img src="../jsp_img/list.gif" border="0" alt="diary_list.gif" align="absmiddle"></a>
			<a href="diary_login.jsp?mode=<%= mode %>&year=<%= year %>&month=<%= month %>&day=<%= day %>"><img src = "../jsp_img/write.gif" border="0" alt="new_write.gif" align="absmiddle"></a>			
		</td>
	</tr>
	<tr>
		<td width="210" height="1" bgcolor="#D2FCFC"></td>
	</tr>
	<tr>
		<td wdith="210" height="2" bgcolor="#44A5E9"></td>
	</tr>
	
	</table>
	
<%
	}
%>
<%
	if (mode.equals("view")){
%>
	<table width="210" height="145" border="0" cellspacing="0" cellpadding="0" align="center">
	
	
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
		<td width="210" height="20" align="left" class="title">&nbsp;<%= year %>�� <%= month %>�� <%= day %>��</td>
	</tr>
	<tr>
		<td width="210" height="20" align="left" class="title">&nbsp;����&nbsp;:&nbsp;<%= subject %></td>
	</tr>
	<tr>
		<td width="210" height="80" align="left">
			<table width="200" height="80" border="0" cellspacing="0" cellpadding="0" align="left" valign="top">
				<tr>
					<td width="5"></td>
					<td width="195" valign="top" align="left" class="title"><%= contents %></td>
				</tr>
				<tr>
					<td colspan="2" width="200"></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td width="210"></td>
	</tr>
	<tr>
		<td width="210" height="1" bgcolor="#A6E6E6"></td>
	</tr>
	
	
	</table>
	<table width="210"  height="25" border="0" cellspacing="0" cellpadding="0" align="center">
	
	
	<tr>
		<td width="210" height="20" align="center">
			<a href="calendar.jsp"><img src="../jsp_img/list.gif" border="0" alt="diary_list.gif" align="absmiddle"></a>
			<a href="diary_login.jsp?mode=modify&id=<%= id %>"><img src = "../jsp_img/modify.gif" border="0" alt="modify.gif" align="absmiddle"></a>
			<a href="diary_login.jsp?mode=delete&id=<%= id %>"><img src = "../jsp_img/delete.gif" border="0" alt="delete.gif" align="absmiddle"></a>			
		</td>
	</tr>
	<tr>
		<td width="210" height="1" bgcolor="#D2FCFC"></td>
	</tr>
	<tr>
		<td wdith="210" height="2" bgcolor="#44A5E9"></td>
	</tr>
	
	</table>
	
<%
	}
%>
			
		</td>
	</tr>
</table>
</body>
</html>