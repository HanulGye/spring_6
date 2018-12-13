<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
var oEditors = [];
$(function(){
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          //textArea의 id를 elPlaceHolder에 설정
          elPlaceHolder: "contents",
          //SmartEditor2Skin.html 파일이 존재하는 경로
          sSkinURI: "${pageContext.request.contextPath}/resources/SE2/SmartEditor2Skin.html",  
          htParams : {
              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseToolbar : true,             
              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseVerticalResizer : true,     
              // 모드 탭(Editor | HTML | TEXT) ?ъ슜 ?щ? (true:?ъ슜/ false:?ъ슜?섏? ?딆쓬)
              bUseModeChanger : true,         
              fOnBeforeUnload : function(){
                   
              }
          }
      });
      
      //저장버튼 클릭시 form 전송  
      $("#save").click(function(){
          oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);
          $("#frm").submit();
      });    
});
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Write</h1>
	
	<form id="frm" action="./${board}Write" method="post" enctype="multipart/form-data">
		<input type="text" name="title">
		<input type="text" name="writer">
		<textarea name="contents" rows="" cols="" id="contents"></textarea>
		<input type="button" value="ADD" id="btn">
		<div id="files">
			
		</div>
		<input type="button" value="Write" id="save">
	</form>
	

</body>
</html>