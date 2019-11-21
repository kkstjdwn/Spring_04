<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/css.jsp" />
</head>
<body>
	<c:import url="../layout/nav.jsp" />
	<c:import url="../layout/bootStrap.jsp" />
	<div class="container">
		<h2>${fn:toUpperCase(board) } UPDATE</h2>
		
		<form class="form-horizontal" action="${board}Update" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">TITLE</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" name="title"
						value="${vo.title }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="writer">WRITER</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="writer" name="writer"
						readonly="readonly" value="${vo.writer}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="contents">CONTENTS</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="contents" name="contents">${vo.contents }</textarea>
				</div>
			</div>
				<div id="files">
			<c:forEach items="${vo.files }" var="file">
				<div class="form-group" id="f${file.fnum }"> 
					<label class="control-label col-sm-2" for="title">FILES</label>
					<div class="col-sm-9">
						<span class="form-control" >${file.oname}</span>
						<input type="file" class="form-control" name="file">
						<input type="hidden" class="size" id="${vo.files.size() }">
					</div>
					<div class="col-sm-1">
						<input type="button" class="form-control btn btn-danger del" value="삭제" id="${file.fnum }">
						<input type="button" class="form-control btn btn-warning" value="수정">
					</div>
				</div>
			</c:forEach>
				</div>
			<!--***********************히든그룹 -->
			<input type="hidden" class="form-control" id="num" name="num"
				readonly="readonly" value="${vo.num }"> <input type="hidden"
				class="form-control" id="hit" name="hit" readonly="readonly"
				value="${vo.hit }">
			<c:if test="${board eq 'qna' }">
				<input type="hidden" class="form-control" id="ref" name="ref"
					readonly="readonly" value="${vo.ref }">
				<input type="hidden" class="form-control" id="step" name="step"
					readonly="readonly" value="${vo.step }">
				<input type="hidden" class="form-control" id="depth" name="depth"
					readonly="readonly" value="${vo.depth }">
			</c:if>
			<!--***********************히든그룹 -->


			<!--**********************버튼그룹 -->
			<input type="button" class="btn btn-primary btn_gp" value="ADD FILE" id="add_file">
			<button type="submit" class="btn btn-warning" id="btn_right">수정</button>
			
		</form>





	</div>
<script type="text/javascript">
var count = 0;
// if ($(".size").attr("id") != null) {
// 	count = $(".size").attr("id");
// }


 count = ${fn:length(vo.files)};

$("#add_file").click(function() {
		if (count < 5) {
	$.get("${board}AddFile", function(data) {	
		$("#files").append(data);
	});
			count++;
		
		
		}else{
			alert("그만해");
			
		}
	
});
	
	$(".del").click(function() {
		var fnum = $(this).attr("id");
		if (confirm("삭제하시겠습니까?")) {
			
		
		$.post("${board }FileDelete",{fnum : fnum}, function(data) {
			if (data > 0) {
				alert("제거");
				$("#f"+fnum).remove();
				count--;
			}else{
				alert("실패");
			}
		});
		}
	});

	$("#files").on("click",".del_file", function() {
		$(this).parent().parent().remove();
		count--;
	});
</script>
</body>
</html>