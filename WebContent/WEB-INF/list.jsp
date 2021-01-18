<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action ="/guestbook2/gbc" method="post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><button type="submit">확인</button></td>
			</tr>
		</table>
				<input type="hidden" name = "action" value="insert">
	</form>
	<br>
	<br>
	<!-- 리스트 출력 -->
	
	<c:forEach items="${guestList}" var="vo"  >
		<table border="1">
			<tr>
				<td>${vo.no}</td>
				<td>${vo.name }</td>
				<td>${vo.date }</td>
				<td><a href="/guestbook2/gbc?action=deleteform&no=${vo.no }">삭제</a></td>
			</tr>
			<tr>
				<td colspan="4">${vo.content }</td>
			</tr>
		</table>
	</c:forEach>

	<br>
</body>
</html>