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
<form action="memberLogin" method="post">
    <div class="form-group">
      <label for="email" id="id_label">ID</label>
      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id" value="${vo.id }">
    </div>
    <div class="form-group">
      <label for="pwd">PW</label>
      <input type="password" class="form-control" id="pw" placeholder="Enter PW" name="pw">
    </div>
    <div class="form-group">        
        <div class="checkbox">
          <label><input type="checkbox" value="check" checked="checked"> Remember me</label>
        </div>
    </div>
    
    <button type="submit" class="btn btn-default">LOGIN</button>
    
  </form>
</div>
</body>
</html>