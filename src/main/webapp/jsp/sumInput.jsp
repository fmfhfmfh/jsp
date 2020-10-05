<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/sumCalculation" method="POST">
		Start<input type="text" name="first"><br>
		End<input type="text" name="second"><br>
		Result<input type="submit" value="계산"><br>
	</form>	
</body>
</html>