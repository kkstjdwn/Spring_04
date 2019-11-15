<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>M-I-C</title>
<c:import url="../layout/css.jsp"  />
</head>
<body>
<c:import url="../layout/bootStrap.jsp"/>
	<form action="memberIdCheck">
	<h2>
	<c:if test="${param.id ne '' }">
		${param.id} 은(는) 
	</c:if>
	${msg }</h2>
<div class="container form-group">
		<label for="id" id="id_label">Id</label>
		<input type="text" required="required" class="form-control" id="id_window" placeholder="Enter id" name="id" value="${param.id }">
			
				
				<c:choose>
					<c:when test="${result eq 1}">
				<a href="" type="button" class="btn btn-info" id="btn_right3">ID 사용하기</a>
				
					</c:when>
				</c:choose>
				<button type="submit" class="btn btn-success" id="btn_right3">ID 중복확인</button>
</div>
	</form>
	
	<script type="text/javascript">
	$(".btn-info").click(function() {
		
		var id = $("#id_window").val();
		
		//javaScript
		opener.document.getElementById("id").value = id;
		
		//jQuery
		$("#id",opener.document).val(id);
		self.close();
		
	});
	
	</script>
</body>
</html>