<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/mulCalculation" method="POST">
		First<input type="text" name="param1"><br>
		Second<input type="text" name="param2"><br>
		<input type="submit" value="결과"><br>
	</form>
</body>
</html>