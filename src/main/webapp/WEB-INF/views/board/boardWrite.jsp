<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S-L</title>
<c:import url="../layout/css.jsp"/>
</head>
<body>
<c:import url="../layout/nav.jsp"  />
<c:import url="../layout/bootStrap.jsp"/>
<c:import url="../layout/summerNote.jsp"/>
	<div class="container">
		<h2>${fn:toUpperCase(board) } WRITE</h2>
		
		<form class="form-horizontal" action="${board}Write" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">TITLE</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" name="title">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">WRITER</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="writer" name="writer" readonly="readonly" value="${member.id }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">CONTENTS</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="contents" name="contents"></textarea>
				</div>
				
			</div>
		<div id = "files" >
			<div class="form-group"> 
				<label class="control-label col-sm-2" for="title">FILES</label>
				<div class="col-sm-9">
				<input type="file" class="form-control" id="file" name="file">
				</div>
				<div class="col-sm-1">
				<input type="button" class="form-control btn btn-danger del_file" value="삭제">
				</div>
			</div>
		</div>
		
			<input type="button" class="btn btn-primary" value="ADD FILE" id="add_file">
		<!--**********************버튼그룹 -->
		<button type="submit" class="btn btn-info" id="btn_right">작성</button>
		</form>

	
	</div>
	
	<script type="text/javascript">
	var count = 0;

	
	$("#add_file").click(function() {
			if (count < 4) {
		$.get("${board}AddFile", function(data) {	
			$("#files").append(data);
		});
				count++;
			
			
			}else{
				$.get("noticeReset");
				alert("그만해");
				
			}
		
	});
	
	$("#files").on("click", ".del_file",function() {
		$(this).parent().parent().remove();
		count--;
	});
	
	$("#contents").summernote({
		height: 400,
		callbacks :	{
			onImageUpload : function(files, editor) {
				uploadFile(files[0], this);
			}, //oIU
			
			onMediaDelete : function(files, editor) {
				deleteFile(files[0],this);
			}//oMD
			
		}//callback
	});
	
	function deleteFile(file, editor) {
		var fileName = $(file).attr("src");
		fileName = fileName.substring(fileName.lastIndexOf("/")+1);
		$.ajax({
			data : {
				file: fileName
				},
			type : "POST",
			url : "summerFileDelete",
			success : function(result) {
				console.log(result);
			}
			
		});
	}
	
	function uploadFile(file, editor) {
		var formData = new FormData();
		formData.append('file',file); //파라미터로 받음
		$.ajax({
			data : formData,
			type : "POST",
			url	: "summerFile",
			enctype : "multipart/form-data",		//여기서부터
			contentType	: false,
			cache	: false,						//여기까진 그냥 써라
			processData : false,
			success	: function(data) {
				data = data.trim();
				data = '../resources/upload/summer/'+data;
				$(editor).summernote('insertImage',data);
			}
			});
	}
	

	
	
	</script>
</body>
</html>