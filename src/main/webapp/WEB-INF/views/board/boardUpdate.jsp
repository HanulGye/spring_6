<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".files").click(function() {
			var id=$(this).attr("id");
			$.ajax({
				url:"../file/delete",
				type:"GET",
				data:{
					fnum:id
				},
				success:function(data){
					
				}
			});
		});
	});
</script>
<style type="text/css">
	.files {
		color: red;
		cursor: pointer;
	}
</style>
</head>
<body>
	<h1>${board} Update</h1>
	
	<form action="./${board}Update" method="post">
		<input type="hidden" name="num" value="${dto.num}">
		<input type="text" name="title" value="${dto.title}">
		<input type="text" name="writer" value="${dto.writer}">
		<textarea name="contents" rows="" cols="">${dto.contents}</textarea>
		
		<div>
			<c:forEach items="${files}" var="file" varStatus="i">
				<div id="f${i.index}">
					<span>${file.oname}</span><span title="f${i.index}" class="files" id="${file.fnum}">X</span>
				</div>
			</c:forEach>
		</div>
		
		<button>Update</button>
	</form>

</body>
</html>