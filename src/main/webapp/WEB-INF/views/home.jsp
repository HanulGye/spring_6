<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#frm").click(function() {
			var f = $("#f")[0];
			var formData = new FormData(f);
			
			$.ajax({
				url:"./notice/noticeWrite",
				type:"post",
				processData:false,
				contentType:false,
				encType:"multipart/form-data",
				data:formData,
				success:function(data){
					
				},
				error:function(xhr){
					alert(xhr.status);
				}
			
			});
		})
	})
</script>	
</head>
<body>
<h1>
	Hello world!  
</h1>

<div>
	<form id="f" action="./notice/noticeWrite" method="post" enctype="multipart/form-data">
		<input type="text" id="writer" name="writer">
		<input type="text" id="title" name="title">
		<textarea id="contents" name="contents"></textarea>
		<input type="button" id="frm" value="Write">
	</form>
</div>

<P>  The time on the server is ${serverTime}. </P>
<a href="./notice/noticeList">Notice List</a>
<a href="./qna/qnaList">Qna List</a>

<a href="./member/join">Join</a>
<a href="./member/login">Login</a>
<a href="./ani/list">유기동물 보기</a>



<a href="./memo/memoList">Ajax Page</a>
</body>
</html>
