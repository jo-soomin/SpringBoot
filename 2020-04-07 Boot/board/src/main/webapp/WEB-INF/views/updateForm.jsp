<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${dto.id }님의 정보 변경</h1>
	
	<form action="updateRes.do", method="post">
		<input type="hidden" name="id" value="${dto.id }">
		<table border="1">
			<tr>
				<th>pw</th>
				<td><input type="text" name="pw" value="${dto.pw }"></td>
			</tr>
			<tr>
				<th>name</th>
				<td><input type="text" name="name" value="${dto.name }"></td>
			</tr>
			<tr>
				<td><input type="submit" value="업데이트"></td>
			</tr>
			
		</table>
	</form>

</body>
</html>