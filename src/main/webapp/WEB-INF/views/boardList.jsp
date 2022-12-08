<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./top.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/maincss.css">
</head>
<body>
<body>
	<section>
		<div>

		</div>
	</section>
	<c:choose>
	<c:when test="${login != null }">
		<div id="loginDV">
			${login } 님 로그인 되었습니다. <br> 어서오세요.
			<br>
			<a href="logout">[로그아웃]</a>
		</div>
	</c:when>
	<c:when test="${login eq null }">
		<div id="loginDV">
			<form id="loginFrm" action="login" method="post">
				<table>
					<tr>
						<td>ID</td>
						<td><input type="text" id="id" name="id"></td>
					</tr>
					<tr>
						<td>PASS</td>
						<td><input type="passowrd" id="pass" name="pass"></td>
					</tr>
					<tr>
						<td colspan=2><input type="submit" value="로그인"> <input
							type="button" value="신규가입"></td>
					</tr>
				</table>
			</form>
		</div>
	</c:when>
	</c:choose>

	<div id="zzz">
		<h2>게시판 목록</h2>
		<ul>
			<li><a href="/cafe/">메인 화면</a></li>
			<br>
			<li><a href="#">전체 개시판</a></li>
			<br>
			<li><a href="#">정보 개시판</a></li>
			<br>
			<li><a href="#">직업 개시판</a></li>
			<br>
			<li><a href="#">자유 개시판</a></li>
		</ul>
	</div>

</body>
<%@ include file="./footer.jsp"%>