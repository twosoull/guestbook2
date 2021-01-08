<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.javaex.guestvo.GuestVo"%>
<%
	List<GuestVo> guestList = (List<GuestVo>) request.getAttribute("guestList");
%>
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
	<%
		for (int i = 0; i < guestList.size(); i++) {
	%>
		<table border="1">
			<tr>
				<td><%=guestList.get(i).getNo() %></td>
				<td><%=guestList.get(i).getName() %></td>
				<td><%=guestList.get(i).getDate() %></td>
				<td><a href="/guestbook2/gbc?action=deleteform&no=<%=guestList.get(i).getNo() %>">삭제</a></td>
			</tr>
			<tr>
				<td colspan="4"><%=guestList.get(i).getContent() %></td>
			</tr>
		</table>
	<%
		}
	%>
	<br>
</body>
</html>