<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	비밀번호가 틀렸습니다
	<br>
	<a href = "/guestbook2/gbc?action=deleteform&no=${param.no }">다시입력하기</a>
	<br>
	<a href = "/guestbook2/gbc?action=list">리스트로 돌아가기</a>
</body>
</html>