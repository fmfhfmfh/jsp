<%@page import="kr.or.ddit.jobs.model.JobsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<% List<JobsVO> list = (List<JobsVO>) request.getAttribute("list"); %>
</head>
<body>
	<table border="1">
		<tr>
			<th>Job_Id</th>
			<th>Job_Title</th>
		</tr>
		
		<% for(int i = 0; i < list.size(); i++){ %>
		<tr>
			<td><%= list.get(i).getJob_id() %></td>
			<td><%= list.get(i).getJob_title() %></td>
		</tr>
		<%} %>

	</table>
</body>
</html>