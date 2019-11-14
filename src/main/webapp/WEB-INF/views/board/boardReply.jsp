<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A-R</title>
<c:import url="../layout/css.jsp"/>
</head>
<body>
<c:import url="../layout/nav.jsp"  />
<c:import url="../layout/bootStrap.jsp"/>
	<div class="container">
		<h2>ANSER WRITE</h2>
		<form class="form-horizontal" action="${board }/${board}Reply" method="post" onsubmit=true>
		
			<!--***********************히든그룹 -->
			<input type="hidden" class="form-control" id="num" name="num" readonly="readonly" value="${vo.num }">
			<input type="hidden" class="form-control" id="hit" name="hit" readonly="readonly" value="${vo.hit }">
			<c:if test="${board ne 'notice' }">
			<input type="hidden" class="form-control" id="ref" name="ref" readonly="readonly" value="${vo.ref }">
			<input type="hidden"class="form-control" id="step" name="step" readonly="readonly" value="${vo.step }"> 
			<input type="hidden" class="form-control" id="depth" name="depth" readonly="readonly" value="${vo.depth }">
			</c:if>
			<!--***********************히든그룹 -->
		
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">TITLE</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" name="title" value="RE : ${vo.title }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">WRITER</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="writer" name="writer" value="${vo.writer }" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">CONTENTS</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="contents" name="contents"> [본문내용]  ${vo.contents } [본문내용] </textarea>
				</div>
			</div>
		<!--**********************버튼그룹 -->
		<button type="submit" class="btn btn-info" id="btn_right">작성</button>
		</form>


	</div>
</body>
</html>