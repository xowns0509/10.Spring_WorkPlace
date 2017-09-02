<%@ page info="diary calendar" %>
<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page language="java" import="java.sql.*,java.io.*,java.net.*,java.util.*" %>

<jsp:useBean id = "dbconn" class="MyBeans.DBConnect" scope="request" />
<jsp:useBean id = "myutil" class="MyBeans.MyUtil" scope="request" />  


<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	String mode               = myutil.checkNull(request.getParameter("mode"));
	String id                     = myutil.checkNull2(request.getParameter("id"));
	String year                 = myutil.checkNull(request.getParameter("year"));
	String month              = myutil.checkNull(request.getParameter("month"));
	String day                  = myutil.checkNull(request.getParameter("day"));
	String subject            = myutil.toKorean(request.getParameter("subject"));
	String contents          = myutil.toKorean(request.getParameter("contents"));
	String member_id       = myutil.checkNull((String)session.getAttribute("member_id"));
	String member_name = URLDecoder.decode(myutil.checkNull((String)session.getAttribute("member_name")));
	String member_email = myutil.checkNull((String)session.getAttribute("member_email"));
	String query = new String();
	String created = new String();
	
	//회원 인증 체크	
	//if (member_id.equals("") || member_name.equals("") || member_email.equals("")) {
	//	response.sendRedirect("login.jsp?ret_url=calendar.jsp");
	//}
	
	try {
		conn = dbconn.getConnection();
		stmt = conn.createStatement();
	} catch(SQLException e) {
	}
	
	try {
		if (mode.equals("modify")) {
		
		query = "select * from diary where id="+id;
		rs = stmt.executeQuery(query);
		
			if (rs.next()) {
				year = myutil.checkNull(rs.getString("year"));
				month = myutil.checkNull(rs.getString("month"));
				day = myutil.checkNull(rs.getString("day"));
				subject = myutil.checkNull(rs.getString("subject"));
				contents = myutil.checkNull(rs.getString("contents"));
				created = myutil.checkNull(rs.getString("created"));
				mode = "update";
			}	
		rs.close();
		} else if (mode.equals("insert")) {
			//새글을 저장할 경우
			
			query = "insert into diary values (seq_diary_id.nextval, ?, ?, ?, ?, ?, sysdate, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, year);
			pstmt.setString(2, month);
			pstmt.setString(3, day);
			pstmt.setString(4, subject);
			pstmt.setString(5, contents);
			pstmt.setString(6, member_id);
			pstmt.execute();
			
			response.sendRedirect("calendar.jsp");
			
		} else if (mode.equals("update")) {
			//수정한 글을 저장할 경우
			
			query = "update diary set year=?, month=?, day=?, subject=?, contents=? WHERE id="+id;
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, year);
			pstmt.setString(2, month);
			pstmt.setString(3, day);
			pstmt.setString(4, subject);
			pstmt.setString(5, contents);
			pstmt.execute();
			
			response.sendRedirect("calendar.jsp");
			
		} else {
			//모드 값이 없으면 새글 작성으로 간주
			mode = "insert";
		}
	} catch(SQLException e) {
	} finally {
		dbconn.close();
	}
	
%>


		
		
<html>
<head>
<title>다이어리</title>

<style type="text/css">
<!--
A:link{font-size:9pt; font-family:"굴림"; text-decoration:none;color:#3E3E3E}
A:visited{font-size:9pt; font-family:"굴림"; text-decoration:none;color:#3E3E3E}
A:hover {font-size: 9pt; font-family:"굴림"; text-decoration: underline;color: #F29708;}

.title {font-size: 9pt; font-family:"굴림"; color:#504F4F}
-->
</style>


<script language="JavaScript">
<!--	
function check()
{
	f = document.diaryInput;
	if (!f.subject.value) {
		alert ("제목을 입력하세요!");
		f.subject.focus();
		return false;
	}
	
	if (!f.contents.value) {
		alert("내용을 입력하세요!");
		f.contents.focus();
		return false;	
	}	
}
//-->
</script>


</head>
<body LEFTMARGIN="0" TOPMARGIN="0" MARGINWIDTH="0" MARGINHEIGHT="0">
<form method="post"  name="diaryInput" action="write.jsp" onSubmit="return check()">

	<table width="235" height="180" border="0" cellspacing="0" cellpadding="0" align="center">
		<tr>
			<td align="center" valign="top" >
			
			
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
						<td width="210" height="20" align="left" class="title">
							<input type="hidden" name="year" value="<%= year %>" >
							<input type="hidden" name="month" value="<%= month %>">
							<input type="hidden" name="day" value="<%= day %>">
							&nbsp;<%= year %>년 <%= month %>월 <%= day %>일
						</td>
					</tr>
					<tr>
						<td width="210" height="20" align="left" class="title">&nbsp;제목&nbsp;:&nbsp;<input type="text" name="subject" value="<%= subject %>" size="20" maxlength="100" class="title">
						</td>
					</tr>
					<tr>
						<td width="210" height="80" align="left">
							<table width="200" height="80" border="0" cellspacing="0" cellpadding="0" align="left" valign="top">
								<tr>
									<td width="5"></td>
									<td width="195" valign="top" align="left" class="title"><textarea name="contents" cols="30" rows="5" class="title"><%= contents %></textarea></td>
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
							<input type="hidden" name="mode" value="<%= mode %>">
							<input type="hidden" name ="id" value="<%= id %>">
							<input type = "submit" value="전송">
							<input type = "button" value="취소" onClick="location='calendar.jsp'">			
						</td>
					</tr>
					<tr>
						<td width="210" height="1" bgcolor="#D2FCFC"></td>
					</tr>
					<tr>
						<td wdith="210" height="2" bgcolor="#44A5E9"></td>
					</tr>
					
				</table>
	
			</td>
		</tr>
	</table>

</form>
</body>
</html>