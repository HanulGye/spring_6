<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="./notice/noticeList">Notice List</a>
<a href="./qna/qnaList">Qna List</a>

<a href="./member/join">Join</a>
<a href="./member/login">Login</a>
<a href="./ani/list">유기동물 보기</a>
</body>
</html>
