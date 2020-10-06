<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% int result = (Integer) session.getAttribute("mulResult"); %>
	결과 값 : <% out.print(result); %>
</body>
</html>