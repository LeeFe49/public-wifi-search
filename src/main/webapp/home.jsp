<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2 class="title1"><b>와이파이 정보 구하기</b></h2>
<div>
<a href="http://localhost:8080/zerobase-study21/home.jsp">홈</a><span> |</span>
<a href="http://localhost:8080/zerobase-study21/history.jsp">위치 히스토리 목록</a><span> |</span>
<a href="http://localhost:8080/zerobase-study21/load-wifi.jsp">Open API 와이파이 정보 가져오기</a>
</div>
<br>
<div>
	<form>
		<label for="lat">LAT: </label>
		<input type="text" id="lat" name="lat"><span> , </span>
		<label for="lnt">LNT: </label>
		<input type="text" id="lnt" name="lnt">
		<input type="submit" value="내 위치 가져오기">
		<input type="submit" value="근처 WIFI 정보 보기">
	</form>
</div>
<br>
<div>
	<table>
		<tr class="tr1">
			<th>거리(Km)</th>
			<th>과리번호</th>
			<th>자치구</th>
			<th>와이파이명</th>
			<th>도로명주소</th>
			<th>상세주소</th>
			<th>설치위치(층)</th>
			<th>설치유형</th>
			<th>설치기관</th>
			<th>서비스구분</th>
			<th>망종류</th>
			<th>설치년도</th>
			<th>실내외구분</th>
			<th>WIFI접속환경</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>작업일자</th>
		</tr>
		<tr class="tr1-1">
			<td colspan="17">위치 정보를 입력한 후에 조회해 주세요</td>
		</tr>
	</table>
</div>
</body>
</html>