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
	<h3>
	<c:if test="${result ne '' }">
		${result } 은(는)
	</c:if>
	${msg }
	
	</h3>
<div class="container form-group">
		<label for="id" id="id_label">Id</label>
		<input type="text" required="required" class="form-control" id="id_window" placeholder="Enter id" name="id" value="${result }">
			
				<c:if test="${empty vo}">
				<button type="button" class="btn btn-info" id="btn_right3">ID 사용하기</button>
				</c:if>
				<button type="submit" class="btn btn-success" id="btn_right3">ID 중복확인</button>
</div>
	</form>
<script type="text/javascript">
	$(".btn-info").click(function() {
		$("#id",opener.document).val($("#id_window").val());
		self.close();
	});

</script>
</body>
</html>