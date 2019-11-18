<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>M-J</title>
<c:import url="../layout/css.jsp"  />
</head>
<body>
<c:import url="../layout/nav.jsp"  />
<c:import url="../layout/bootStrap.jsp"/>
<div class="container">
  <form action="memberJoin" method="post" onsubmit="check()">
    <div class="form-group">
      <label for="id">Id</label>
      <input type="text" required="required" class="form-control" id="id" placeholder="Enter id" name="id" value="${param.id }">
      <div class="form-group" id="id_check"></div>
    </div>
    <div class="form-group">
      <label for="pw">Password</label>
      <input type="password" required="required" class="form-control" id="pw" placeholder="Enter password" name="pw">
    </div>
    <div class="form-group">
      <label for="name">Name</label>
      <input type="text" required="required" class="form-control" id="name" placeholder="Enter name" name="name">
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input type="email" required="required" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="form-group">
      <label for="birth">Birth</label>
      <input type="date" required="required" class="form-control" id="birth" name="birth">
    </div>
    <div class="form-group">
      <label for="phone">birth</label>
      <select  required="required" class="form-control" name="gender">
      	<option id="male" value="M">MALE</option>
      	<option id="female" value="F">FEMALE</option>
      </select>
    </div>
    <button type="submit" class="btn btn-info" id="btn_right">회원가입</button>
  </form>
  <script type="text/javascript">
  	var idCheck = false;
  
  	$("#id").blur(function() {
  		$.post("memCheck", {id:$("#id").val()}, function(data) {
		//$.get("memIdCheck?id="+$("#id").val(), function(data) {
			if (data == "pass") {
				
			$("#id_check").html("사용가능한 ID 입니다!");
			$("#id_check").prop("class","text-info");
			idCheck = true;
			}else{
				$("#id_check").html("식상한 ID 입니다!");
				$("#id_check").prop("class","text-danger");
				idCheck = false;
			}
			
			
			
		});
	});
  		
  $("#btn_right").click(function check() {
	if (idCheck) {
		return true;
	}
	return false;
});
  
  </script>

</div>
</body>
</html>