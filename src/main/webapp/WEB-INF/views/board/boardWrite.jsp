<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<div class="container">
		<h2>${board } WRITE</h2>
		
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
					<input type="text" class="form-control" id="writer" name="writer" value="">
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
				<input type="button" class="form-control btn btn-danger del_file" value="DEL" id="H">
				</div>
			</div>
		</div>
		
			<input type="button" class="btn btn-primary" value="ADD FILE" id="add_file">
		<!--**********************버튼그룹 -->
		<button type="submit" class="btn btn-info" id="btn_right">작성</button>
		</form>

	
	</div>
	
	<script type="text/javascript">
	var number = 0;

	
	$("#add_file").click(function() {
			if (number < 4) {
		$.get("noticeAddFile", function(data) {	
			$("#files").append(data);
		});
				number++;
			
			
			}else{
				$.get("noticeReset");
				alert("그만해");
				
			}
		
	});
	
	var remove = $()
	$("#files").on("click", ".del_file",function() {
		$(this).parent().parent().remove();
		number--;
	});

// 	$(".del_file").on("click",'input', function() {
		
// 		alert("띵");
// 	});
	
	
	</script>
</body>
</html>