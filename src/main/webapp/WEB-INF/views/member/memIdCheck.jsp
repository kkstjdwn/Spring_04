<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../layout/bootStrap.jsp"/>
	

<h5 id = "color">
	<c:if test="${color eq 1 }">
		<script type="text/javascript"> 
			$("#color").css("color","rgba(255,0,0,0.7)");
		</script>
	</c:if>
	<c:if test="${color eq 2 }">
		<script>
			$("#color").css("color","rgb(0,150,0)");
		</script>
	</c:if>
	<c:if test="${result ne '' }">
		${result } 은(는)
	</c:if>
	${msg }
	
	</h5>
