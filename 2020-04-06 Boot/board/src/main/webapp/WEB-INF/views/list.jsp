<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">

		<c:forEach var="dto" items="${boardDto }">
			<tr>
				<th>id</th>
				<td>${dto.id }</td>
				<th>pw</th>
				<td>${dto.pw }</td>
				<th>name</th>
				<td>${dto.name }</td>
				<td><input type="button" value="삭제" onclick="location.href='delete.do?id=${dto.id}'"></td>
				<td><input type="button" value="업데이트" onclick="location.href='update.do?id=${dto.id}'"></td>
			</tr>
		</c:forEach>




	</table>

</body>
</html>