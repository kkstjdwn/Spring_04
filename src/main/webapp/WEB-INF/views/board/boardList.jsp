<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>B-L</title>
<c:import url="../layout/css.jsp"/>
</head>
<body>
<c:import url="../layout/nav.jsp"/>
<c:import url="../layout/bootStrap.jsp"/>
<div class="container">
		<h2>${fn:toUpperCase(board) } LIST</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>NO</th>
					<th>TITLE</th>
					<th>WRITER</th>
					<th>DATE</th>
					<th>HIT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<th>${dto.num}</th>
						<th>
						<c:catch>
							<c:forEach begin="1" end="${dto.depth}">ㄴ</c:forEach>
						</c:catch>
						<a href="${board}Select?num=${dto.num}">${dto.title}</a></th>
						<th>${dto.writer}</th>
						<th>${dto.reg_date}</th>
						<th>${dto.hit}</th>

					</tr>
				</c:forEach>
			</tbody>

		</table>
		<!--**********************버튼그룹 -->
		<!-- session member, memberDTO -->

		<form class="form-horizontal" action="${board}List" method="get">
			<div class="form-group">
				<label class="control-label col-sm-2" for="search" id="label">검색</label>
				<div class="col-sm-10" id="not_remote">
					<select class="not_sel" name="kind" id="not_sel">
						<option value="kT" id="kT">TITLE</option>
						<option value="kW" id="kW">WRITER</option>
						<option value="kC" id="kC">CONTENTS</option>
					</select> <input type="text" class="form-control" id="search" name="search"
						value="${pager.search }">
					<button type="submit" class="btn btn-success" id="btn_ser">검색</button>
					<div id="not_ul">
						<ul class="pagination" id="paging">
							<c:if test="${pager.curBlock gt 1}">
								<li><a
									href="${board}List?curPage=${pager.startNum-1 }&kind=${pager.kind}&search=${pager.search}">이전</a></li>
							</c:if>
							<c:forEach begin="${pager.startNum }" end="${pager.lastNum}"
								var="i">
								<c:if test="${pager.curPage eq i }">
									<li><a
										href="${board}List?curPage=${i }&kind=${pager.kind}&search=${pager.search}"
										id="li_curPage">${i }</a></li>
								</c:if>
								<c:if test="${pager.curPage != i }">
									<li><a
										href="${board}List?curPage=${i }&kind=${pager.kind}&search=${pager.search}">${i }</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${pager.curBlock lt pager.totalBlock }">
								<li><a
									href="${board}List?curPage=${pager.lastNum+1 }&kind=${pager.kind}&search=${pager.search}">다음</a></li>
							</c:if>
						</ul>
					</div>
					<c:if test="${!empty sessionScope.member}">
						<a href="${board}Write" class="btn btn-info" id="btn_right">글쓰기</a>
					</c:if>
				</div>
			</div>
		</form>





	</div>
	<script type="text/javascript">
		var check = '#${pager.kind}';
		if (check == "") {
			check = "#kT";
		}
		$(check).prop("selected", "selected");
	</script>
</body>
</html>