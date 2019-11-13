<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커먼요</title>
</head>
<body>
<c:import url="../layout/bootStrap.jsp"/>

	<script type="text/javascript">
		var msg = '${msg}';
		var path = '${path}';
		
		
		alert(msg);
		location.href=path;			
		
	</script>



</body>
</html>