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
  <form>
    <div class="form-group">
      <label for="id">Id</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id" value="${sessionScope.member.id }" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="name">Name</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value="${member.name }" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" value="${member.email }" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="birth">Birth</label>
      <input type="text" class="form-control" id="birth" name="birth" readonly="readonly" value="${member.birth }">
    </div>
    <div class="form-group">
      <label for="gender">Gender</label>
      <input type="text" class="form-control" id="gender" name="gender" readonly="readonly" value="${member.gender }">
    </div>
    <a href="memberUpdate" type="button" class="btn btn-warning" >수정</a>
    <a id="mem_del" type="button" class="btn btn-danger">삭제</a>
  </form>
  
  <script type="text/javascript">
  
  $("#mem_del").click(function() {
	if (confirm("삭제하시겠습니까?")) {
		location.href = "memberDelete";
	}
});
  
  </script>
</div>
</body>
</html>