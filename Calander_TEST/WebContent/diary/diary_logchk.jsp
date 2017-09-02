<%@ page info="diary calendar" %>
<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page language="java" import="java.io.*,java.net.*,java.util.*" %>

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
<title>chek</title>


<%
	//��尡 �����ϰ��
	if (mode.equals("insert")) {
		if( request.getParameter("log_id").equals("root����� ���̵� �����ٶ�") && request.getParameter("passwd").equals("passwd�����ٶ�") ){
%>
			<script>	
				window.alert( "�α��� �Ǿ����ϴ�.")
				location.replace("write.jsp?year=<%= year%>&month=<%= month %>&day=<%= day %>")
			</script>
<%
		} else {
%>
			<script>
				window.alert( "ID �� Password�� �ٽ� Ȯ�����ֽʽÿ�.")
				location.replace("view.jsp?mode=insert&year=<%= year %>&month=<%= month %>&day=<%= day %>")
			</script>
<%
		}
	}
%>

<%
	//��尡 �����ϰ��
	if (mode.equals("modify")) {
		if( request.getParameter("log_id").equals("root����� ���̵� �����ٶ�") && request.getParameter("passwd").equals("passwd�����ٶ�") ){
%>
			<script>	
				window.alert( "�α��� �Ǿ����ϴ�.")
				location.replace("write.jsp?mode=modify&id=<%= id %>")
			</script>
<%
		} else {
%>
			<script>
				window.alert( "ID �� Password�� �ٽ� Ȯ�����ֽʽÿ�.")
				location.replace("view.jsp?mode=view&id=<%= id%>")
			</script>
<%
		}
	}
%>

<%
	//��尡 �����ϰ��
	if (mode.equals("delete")) {
		if( request.getParameter("log_id").equals("root����� ���̵� �����ٶ�") && request.getParameter("passwd").equals("passwd�����ٶ�") ){
%>
			<script>	
				window.alert( "������ �������� ���� �Ǿ����ϴ�.")
				location.replace("delete.jsp?id=<%= id %>")
			</script>
<%
		} else {
%>
			<script>
				window.alert( "ID �� Password�� �ٽ� Ȯ�����ֽʽÿ�.")
				location.replace("view.jsp?mode=view&id=<%= id%>")
			</script>
<%
		}
	}
%>
	
</head>
<body>
</body>
</html>