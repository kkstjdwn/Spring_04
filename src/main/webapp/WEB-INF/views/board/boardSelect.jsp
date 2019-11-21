<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S-O</title>
<c:import url="../layout/css.jsp" />
</head>
<body>
	<c:import url="../layout/nav.jsp" />
	<c:import url="../layout/bootStrap.jsp" />
	<div class="container">
		<form class="form-horizontal" action="/action_page.php">
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">TITLE</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" name="title"
						readonly="readonly" value="${vo.title }">
				</div>
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


			<div class="form-group">
				<label class="control-label col-sm-2" for="writer">WRITER</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="writer" name="writer"
						readonly="readonly" value="${vo.writer }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="contents">CONTENTS</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="contents" name="contents"
						readonly="readonly">${vo.contents }</textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="reg_date">DATE</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="reg_date"
						name="reg_date" readonly="readonly" value="${vo.reg_date }">
				</div>
			</div>
			<div  class="form-group">
			<c:forEach items="${vo.files }" var="file">
				<a href="fileDown?fnum=${file.fnum }">${file.oname }</a>
			</c:forEach>
			</div>
		</form>
		
		<!--**********************버튼그룹 -->

		<div id="bt_gp">
			
			<a href="${board}List" class="btn btn-primary btn_gp">목록</a>
			<c:if test="${!empty member }">
			<c:if test="${member.id eq vo.writer}">
			<a href="${board}Update?num=${vo.num }" class="btn btn-warning">수정</a>
			<button class="btn btn-danger" id="delete">삭제</button>
			</c:if>
			<c:if test="${board ne 'notice'}">
				<a href="${board}Reply?num=${vo.num }" class="btn btn-success"
					id="btn_right">ANSER</a>
			</c:if>
			</c:if>

		</div>
	</div>

	<script type="text/javascript">
		$("#delete").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				location.href="${board}Delete?num=${vo.num }";
			}
		});
	
	</script>
</body>
</html>