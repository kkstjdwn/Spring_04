<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<c:import url="layout/nav.jsp" />
	<c:import url="layout/bootStrap.jsp" />
	<h1>Hello world!</h1>
	<P>The time on the server is ${serverTime}.</P>
	
	<div>
	
	<select id="animal" name="animal">
	<option value="dog">개</option>
	<option value="cat">고양이</option>
	<option value="birds">새</option>
	</select>
	
	</div>
	
	<div id="kind">
	<select>
		<option>치와와</option>
		<option>푸들</option>
		<option>말티즈</option>
	</select>
	</div>
	
	<input type="text" id="num" name="num">
	<button id="btn">number</button>
	
	<div id="result">
	
	</div>
	
	
	<script type="text/javascript">
	
	$("#animal").change(function() {
		
	
	
	var xmlhttp; //스크립트에서는 지역변수 X -- > 전역변수
	
	
	if (window.XMLHttpRequest) {
	   // code for modern browsers
	   xmlhttp = new XMLHttpRequest();
	 } else {
	   // code for old IE browsers
	   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	//request 정보 선언
	xmlhttp.open("GET","./selectAnimal?animal="+$("#animal").val());
	//xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	//GET 방식으로 request 요청 전송
	xmlhttp.send();
	
	//
	
	xmlhttp.onreadystatechange = function() {
		 if (this.readyState == 4 && this.status == 200) {
			
			//java스크립트
			//document.getElementByid("result").innerHTML = this.responseText;
			//j쿼리
			$("#kind").html(this.responseText);
			}
	}
	
	});
	
</script>
</body>
</html>
