<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  	<h2>member join</h2>
    <div class="form-group">
      <label for="id" id="id_label">Id</label>
      <input type="text" required="required" class="form-control id" id="id" placeholder="Enter id" name="id" value="${param.id }" readonly="readonly">
      							<!-- 중복확인****************************** -->
      <a href="" type="button" class="btn btn-success" id="btn_right3">ID 중복확인</a>
    </div>
    <div class="form-group">
      <label for="pw">Password</label>
      <input type="password" required="required" class="form-control" id="pw" placeholder="Enter password" name="pw">
      <input type="hidden" class="form-control" id="pw_length" readonly="readonly" value="PW는 6자 이상 설정해야 합니다!">
    </div>
    <div class="form-group">
      <label for="pw">RE-Password</label>
      <input type="password" required="required" class="form-control" id="pw_re" placeholder="Enter password">
      <input type="hidden" class="form-control" id="pw_warning" readonly="readonly" value="설정한 PW가 다릅니다!">
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
      <label for="phone">Birth</label>
      <input type="date" required="required" class="form-control" id="birth" placeholder="Enter Birth" name="birth">
    </div>
    <div class="form-group">
      <label for="phone">Gender</label>
      <select class="form-control" name="gender">
      	<option value="M" id="M">MALE</option>
      	<option value="F" id="F">FEMALE</option>
      </select>
    </div>
    
    
    <button type="submit" class="btn btn-info" id="btn_right">회원가입</button>
  </form>
</div>

<script type="text/javascript">
	$("#pw").on ({
		change : function() {
	
		if ($("#pw").val() != $("#pw_re").val()) {
			$("#pw_warning").prop("type","text");
		}else{
			$("#pw_warning").prop("type","hidden");
		}
	},
		blur: function() {
			if (this.value.length < 5) {
				if ($("#pw").val() != $("#pw_re").val()) {
					$("#pw_length").prop("type","text");
				}else{
					$("#pw_length").prop("type","hidden");
				}
			}
		}
	});
	
	$("#pw_re").change(function() {
		if ($("#pw").val() != $("#pw_re").val()) {
			$("#pw_warning").prop("type","text");
		}else{
			$("#pw_warning").prop("type","hidden");
		}
	});
	
	$("#btn_right3").click(function() {
		open("memberIdCheck?id="+$("#id").val(),"","width=600px, height=200, top=200px, left=500");
	});
	
	

</script>
</body>
</html>