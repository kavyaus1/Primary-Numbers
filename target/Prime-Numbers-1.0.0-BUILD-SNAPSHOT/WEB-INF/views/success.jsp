<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success Form</title>
</head>
<body>

	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Prime Number</th>
		</tr>
		<c:forEach var="prime" items="${list}">
			<tr>
				<td>${msg}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>