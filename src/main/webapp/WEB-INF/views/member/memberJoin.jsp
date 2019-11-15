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
  <form action="memberJoin" method="post">
    <div class="form-group">
      <label for="id">Id</label>
      <input type="text" required="required" class="form-control" id="id" placeholder="Enter id" name="id" value="${param.id }">
      <button type="button" class="btn btn-success">ID중복확인</button>
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
	
	$(".btn-success").click(function() {
		open("memberIdCheck?id="+$("#id").val(),"","width=600,height=200,top=300,left=600","");
	});


</script>
</div>
</body>
</html>