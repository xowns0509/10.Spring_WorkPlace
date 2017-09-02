<%@ page info="diary calendar" %>
<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page language="java" import="java.sql.*,java.io.*,java.net.*,java.util.*" %>

<jsp:useBean id = "dbconn" class="MyBeans.DBConnect" scope="request" />
<jsp:useBean id = "myutil" class="MyBeans.MyUtil" scope="request" />  

<%
	Connection conn = null;
	Statement stmt = null;
	
	String id = myutil.checkNull2(request.getParameter("id"));
	String query = new String();
	
	try {
		conn = dbconn.getConnection();
		stmt = conn.createStatement();
		
		query = "delete from diary where id=" + id;
		stmt.executeUpdate(query);
	} catch(SQLException e){
	} finally {
		dbconn.close();
	}
	
	response.sendRedirect("calendar.jsp");
%>