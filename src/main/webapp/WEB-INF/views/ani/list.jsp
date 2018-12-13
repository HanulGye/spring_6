<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#sImage{
	width: 100px;
	height: 100px;
}
</style>
<script type="text/javascript">
	var msg = '${param.msg}';
	if(msg != ''){
		alert(msg);
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Animal List</h1>
	<table>
		<tr>
			<td>이미지</td><td>글 제목</td><td>성별</td><td>발견장소</td><td>발견일자</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td><img id="sImage" src="../resources/animal/${dto.fname}"></td>
			<td><a href="select?num=${dto.num}">${dto.title}</a></td>
			<td>${dto.sung}</td>
			<td>${dto.location}</td>
			<td>${dto.get_date}</td>
		</tr>		
		</c:forEach>
	</table>
	<a href="./list">List</a>
	<a href="./write">Write</a>

</body>
</html>