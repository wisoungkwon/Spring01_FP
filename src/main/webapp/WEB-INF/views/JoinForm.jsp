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
			<h1>회원가입</h1>
			<form name="frm" method="post" action="wrAction" encType="multipart/form-data">
										<!-- encType를 적어 줘야만 첨부파일이 서버로 전송된다. -->
			<table id="jointable">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id"> * 필수</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass"> * 필수</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><input type="text" name="nname"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="tel"></td>
				</tr>
			</table>
			<br>
			<br> <input type="submit" value="등록"> <input type="reset"
				value="다시 작성"> <input type="button" value="목록"">
		</form>
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