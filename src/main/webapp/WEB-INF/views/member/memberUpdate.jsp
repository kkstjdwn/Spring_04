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
  <form action="memberUpdate" method="post">
    <div class="form-group">
      <label for="id">Id</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id" value="${member.id }" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="pw">Password</label>
      <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
    </div>
    <div class="form-group">
      <label for="name">Name</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value="${member.name }">
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" value="${member.email }">
    </div>
    <div class="form-group">
      <label for="birth">Birth</label>
      <input type="text" class="form-control" id="birth" name="birth"  placeholder="Enter birth"  value="${member.birth }">
    </div>
    <div class="form-group">
      <label for="gender">Gender</label>
      <input type="text" class="form-control" id="gender" name="gender" readonly="readonly" value="${member.gender }">
    </div>
    <button type="submit" class="btn btn-warning" >수정</button>
    <button type="button" class="btn btn-danger">삭제</button>
  </form>
  
<script type="text/javascript">
	
	$(".btn-success").click(function() {
		open("memberIdCheck?id="+$("#id").val(),"","width=600,height=200,top=300,left=600","");
	});


</script>
</div>
</body>
</html>