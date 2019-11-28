<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
<c:import url="layout/css.jsp"/>
<c:import url="layout/bootStrap.jsp"/>
<c:import url="layout/summerNote.jsp"/>
</head>
<body>
<c:import url="layout/nav.jsp"/>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>
<div id="getJson" class="container">
	<button id="json" class="btn btn-success">json</button>
	<input type="text" id="base" class="toUpper" placeholder="base">
	<input type="text" id="price" class="toUpper" placeholder="price">
	<input type="text" id="want" class="toUpper" placeholder="want">
</div>

<div class = "container" id="getMovie">
	<button id = "search">get movie</button>
	<img src="" id="movieIMG">
	

</div>
<script type="text/javascript">

	$("#json").click(function() {
// 		$.get("getJson3", function(data) {
// // 			data = data.trim();
// 			// $("#getJson").append(typeof data); String 이라 속성을 꺼낼수 없었음
// //			data = JSON.parse(data); //JavaScript 의 기본 타입은 var 니까 뭐든지 받을 수 있음
			
// 			for (var i = 0; i < data.size; i++) {
// 			$("#getJson").append(data.get(i).title + "\t"+ data.get(i).writer +"\t"+ data.get(i).contents);				
// 			}
			
// 			$.each(data, function(i, vo) {
// 				$("#getJson").append(vo.title +"\t");	
// 			})
// 			//alert(typeof data);
// 		});
	var base = $("#base").val();
	var price = $("#price").val();
	var code = "KRW,USD,JPY";
	$.ajax({
		type : "GET",
		url  : "https://api.manana.kr/exchange/price.json",
		data : {
			base:base,
			price:price,
			code:code
		},
		success:function(data){
			if ($("#want").val() == "KRW") {
				console.log(data.KRW);
			}else if($("#want").val() == "USD") {
				console.log(data.USD);
			}else{
				console.log(data.JPY);
			}
		}
		
	});
	});
	
	$("#search").click(function() {
		$.ajax({
			type : "GET",
			url : "https://yts.lt/api/v2/list_movies.json",
			data : {
				limit : 1,
				movies :{
					medium_cover_image	:	"https://yts.lt/assets/images/movies/hustlers_2019/medium-cover.jpg",
					title	:	"Hustlers"
				}
			},
			success:function(data){
				$("#getMovie").append(data.data.movies[0].title);
				$("#movieIMG").prop("src",data.data.movies[0].medium_cover_image);
				
				
			}
		});
	});

</script>
</body>
</html>
