<%@ page info="diary calendar" %>
<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page language="java" import="java.sql.*,java.io.*,java.net.*,java.util.*" %>

<jsp:useBean id = "dbconn" class="MyBeans.DBConnect" scope="request" />
<jsp:useBean id = "myutil" class="MyBeans.MyUtil" scope="request" />  


<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String strYear = request.getParameter("year");
	String strMonth = request.getParameter("month");
	String query = new String();
	String url = new String();
	String selected = new String();
	//String member_id = myutil.checkNull((String)session.getAttribute("member_id"));
	//String member_name = URLDecoder.decode(myutil.checkNull((String)session.getAttribute("member_name")));
	//String member_email = myutil.checkNull((String)session.getAttribute("member_email"));
	
	//�޷°�ü ����
	Calendar myCalendar = Calendar.getInstance();
	
	int year = 0;
	int month = 0;
	int previous_year = 0;
	int previous_month = 0;
	int next_year = 0;
	int next_month = 0;
	int day = 0;
	int id = 0;
	
	
	int t_year = 0;
	int t_month = 0;
	int t_day = 0;
		
	t_year = myCalendar.get(myCalendar.YEAR);
	t_month = myCalendar.get(myCalendar.MONTH)+1;
	t_day = myCalendar.get(myCalendar.DAY_OF_MONTH);

	//ȸ�� ���� üũ
	
	//if (member_id.equals("") || member_name.equals("") || member_email.equals("")) {
	//	response.sendRedirect("login.jsp?ret_url=calendar.jsp");
	//}

	
	try {
		conn = dbconn.getConnection();
		stmt = conn.createStatement();
	} catch(SQLException e) {
	}
	
	if (strYear == null) {
		year = myCalendar.get(myCalendar.YEAR);
	} else {
		year = Integer.parseInt(strYear);
	}
	
	if(strMonth == null) {
		month = myCalendar.get(myCalendar.MONTH);
	} else {
		month = Integer.parseInt(strMonth) -1;
	}
	
	myCalendar.set(myCalendar.YEAR, year);
	myCalendar.set(myCalendar.MONTH, month);
	month = month + 1;
	
	previous_year = myCalendar.get(myCalendar.YEAR) - 1;
	previous_month = myCalendar.get(myCalendar.MONTH);
	
	if (previous_month < 1) {
		previous_month = 12;
	} else if(previous_month > 12) {
		previous_month = 1;
	}
	
	next_year = myCalendar.get(myCalendar.YEAR) + 1;
	next_month = myCalendar.get(myCalendar.MONTH) + 2;
	
	if (next_month < 1) {
		next_month = 12;
	} else if (next_month > 12) {
		next_month = 1;
	}
	
	%>

<%--HTML �ڵ� ����--%>
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
<%--FORM �±� ����--%>
<form method="post" action="calendar.jsp">

<table width="200" height="170" border="0" cellspacing="0" cellpadding="0" align="center">
	<tr>
		<td align="center" valign="top" >
		
		
		

	<table border="0" cellspacing="0" cellpadding="0" align="center" width="210" valign="top">
		<tr>
			<td width="10%" height="20" align="center">
				<a href="calendar.jsp?year=<%= previous_year %>&month=<%= month %>"><img src="../jsp_img/left_year.gif" border="0" align="absmiddle"></a>
				<a href="calendar.jsp?year=<%= previous_month == 12 ? previous_year : year %>&month=<%= previous_month %>"><img src="../jsp_img/left_month.gif" border="0" align="absmiddle"></a>
			</td>
			<td wdith="80%" align="center" class="title">
				<select name="year" style="background-color:#F5F7F8;" class="title">				
			<%
				for(int i = -5; i<5; i++){
					int temp_year = year + i;
					if (year == temp_year) {
						selected = "selected";
					} else{
						selected = "";
					}
			%>
					<option value = "<%= temp_year %>" <%= selected %>><%= temp_year %></option>
			<%
				}
			%>
				</select>��
				<select name="month" style="background-color:#F5F7F8;" class="title">
			<%
				for(int i = 1; i<=12; i++) {
					if (month == i) {
						selected = "selected";
					} else {
						selected = "";
					}
			%>
					<option value="<%= i %>" <%= selected %>><%= i %></option>
			<%
				}
			%>
				</select>��				
				<input type="submit" value="�̵�" style="border-width:1; color:#FFFFFF; background-color:#44A5E9;" class="title">
			</td>
			<td width="10%" align="center" >
				<a href="calendar.jsp?year=<%= next_month == 1 ? next_year : year%>&month=<%= next_month %>"><img src="../jsp_img/right_month.gif" border="0" align="absmiddle"></a>
				<a href="calendar.jsp?year=<%= next_year %>&month=<%= month %>"><img src="../jsp_img/right_year.gif" border="0" align="absmiddle"></a>
			</td>
		</tr>
	</table>
	<table border="1" cellspacing="0" cellpadding="3" align="center" width="200" bordercolorlight="#EAFAE9" bordercolordark="#FFFFFF">
		<tr align="center" valing="middle">
			<td width="30" height="20" class="title"><font color="red">��</font></td>
			<td width="30" height="20" class="title">��</td>
			<td width="30" height="20" class="title">ȭ</td>
			<td width="30" height="20" class="title">��</td>
			<td width="30" height="20" class="title">��</td>
			<td width="30" height="20" class="title">��</td>
			<td width="30" height="20" class="title"><font color="blue">��</font></td>
		</tr>
	<%
		while(true){
			day++;
			
			//��¥�� day ������ ����
			myCalendar.set(myCalendar.DAY_OF_MONTH, day);
			
			//�޷��� ��¥�� �����޷� �Ѿ�� day ���̶� �޶���
			if (day != myCalendar.get(myCalendar.DAY_OF_MONTH)) {
				break;
			}
			
			if (day == 1) {
				out.println("<tr align='right' valign='top'>");
				
				//���� ����ŭ ��ĭ �����
				for (int j = 1; j < myCalendar.get(myCalendar.DAY_OF_WEEK); j++) {
					out.print("<td width='30' height='20'>&nbsp;</td>");
				}
			}
			
			try {
				id = 0;
				
				query = "select id from diary where year='"+year+"'";
				query = query + " and month='"+month+"' and day='"+day+"'";
				//query = query + "and userid='"+member_id+"'";
				rs = stmt.executeQuery(query);
				
				if (rs.next()) {
					id = rs.getInt("id");
				}
			} catch (SQLException e) {
			} finally {
				rs.close();
			}
			
			if (id > 0) {
				out.println("<td width='30' height='20' background='../jsp_img/is_bg.gif'>");
				url = "view.jsp?id="+id+"&mode=view";
			} else {
				out.println("<td width='30' height='20'>");
				url = "view.jsp?year="+year+"&month="+month+"&day="+day+"&mode=insert";
			}
			out.println("<a href='"+url+"'>");
			
			//������ �Ͽ����̸� ���������� ǥ��
			if (myCalendar.get(myCalendar.DAY_OF_WEEK) == myCalendar.SUNDAY) {
				out.println("<font color=red>");
				out.println(myCalendar.get(myCalendar.DAY_OF_MONTH));
				out.println("</font>");
				
			} else if (myCalendar.get(myCalendar.DAY_OF_WEEK) == myCalendar.SATURDAY) {
				//������ ������̸� �Ķ������� ǥ��					
				out.println("<font color=blue>");
				out.println(myCalendar.get(myCalendar.DAY_OF_MONTH));
				out.println("</font>");
				
			} else if (t_year == year & t_month == month & t_day == day) {
				//������ ��� ��Ʈ�� ũ�� ������ ����������				
				out.println("<font color=#EE7EAD><b>");
				out.println(myCalendar.get(myCalendar.DAY_OF_MONTH));
				out.println("</b></font>");
			
			} else {
				out.println(myCalendar.get(myCalendar.DAY_OF_MONTH));
			}
			out.println("</a></td>");
			
			//������ ������̸� �����ٷ� ����
			if (myCalendar.get(myCalendar.DAY_OF_WEEK) == myCalendar.SATURDAY) {
				out.println("</tr>");
				out.println("<tr align='right' valign='top'>");
			}
		}
		
		
		//�������� ����Ϸ� ������ �ʾ����� ���� �ݾ���
		if (myCalendar.get(myCalendar.DAY_OF_WEEK) != myCalendar.SATURDAY){
			out.println("</tr>");
		}
		
	%>
	
	</table>
</form>
</body>
</html>
		