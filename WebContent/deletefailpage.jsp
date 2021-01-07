<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int no = (int)request.getAttribute("no");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	비밀번호가 틀렸습니다
	<br>
	<a href = "/guestbook2/gbc?action=deleteform&no=<%=no%>">다시입력하기</a>
	<br>
	<a href = "/guestbook2/gbc?action=list">리스트로 돌아가기</a>
</body>
</html>