<%@page import="com.doctorconsult.model.Patient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
   
	Patient p = (Patient) session.getAttribute("user");
    

	if(p!=null) {
		%>
		<h3><%= p.getName() %></h3>
		<%
	}

%>
</body>
</html>