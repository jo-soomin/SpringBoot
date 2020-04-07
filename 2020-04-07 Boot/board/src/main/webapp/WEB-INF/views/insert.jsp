<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertRes.do" method="post">
		<table border="1">
		<tr>
			<th>id</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>pw</th>
			<td><input type="text" name="pw"></td>
		</tr>
		<tr>
			<th>name</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="작성하기">
			</td>
		</tr>
		
		</table>
	</form>

</body>
</html>