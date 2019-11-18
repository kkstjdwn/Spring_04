<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<c:import url="layout/nav.jsp"/>
<c:import url="layout/bootStrap.jsp"/>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>


<div id="result">
	<input type="text" id="num">
	<button id="btn">콕</button>

</div>

<script type="text/javascript">
	$("#btn").click(function() {
		var num = $("#num").val(); 
		
// 		$.get("getNum?num="+num, function(data) {
// 			$("#result").append(data);
// 		}); //선택자 없이 
		$.post("getNum", {num:num } , function(data) { //,로 연결
			$("#result").append(data);
		}); //선택자 없이
	});

</script>
</body>
</html>
