<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h2 class="title1">
		<b>와이파이 정보 구하기</b>
	</h2>
	<div>
		<a href="http://localhost:8080/zerobase-study21/home.jsp">홈</a><span>
			| </span> <a href="http://localhost:8080/zerobase-study21/history.jsp">위치
			히스토리 목록</a><span> | </span> <a
			href="http://localhost:8080/zerobase-study21/load-wifi.jsp"
			onclick="loading()">Open API 와이파이 정보 가져오기</a>
	</div>
	<br>
	<div>
		<form action='home2.jsp' method="get">
			<label id="lat" for="lat">LAT: </label> 
			<input type="text" id="getLat" name="lat"><span> , </span> 
			<label id="lnt" for="lnt">LNT: </label> 
			<input type="text" id="getLnt" name="lnt"><span> </span>
			<button type="button" onclick="myLoc()">내 위치 가져오기</button><span> </span>
			<input type="submit" value='근처 WIFI 정보 보기'>
		</form>

		<script>
			const x = document.getElementById("getLat");
			const y = document.getElementById("getLnt");

			function myLoc() {
				if (navigator.geolocation) {
					navigator.geolocation.getCurrentPosition(showPosition);
				} else {
					x.value = "Geolocation not found.";
					y.value = "Geolocation not found.";
				}
			}

			function showPosition(position) {
				x.value = position.coords.latitude;
				y.value = position.coords.longitude;
			}

			function loading() {
				alert("로딩중이니 잠시 기다려주세요!");
			}
		</script>
	</div>
	<%
	out.write("<br>");
	out.write("<div>");
	out.write("<table>");
	out.write("<tr class=\"tr1\">");
	out.write("<th>거리(Km)</th>");
	out.write("<th>과리번호</th>");
	out.write("<th>자치구</th>");
	out.write("<th>와이파이명</th>");
	out.write("<th>도로명주소</th>");
	out.write("<th>상세주소</th>");
	out.write("<th>설치위치(층)</th>");
	out.write("<th>설치유형</th>");
	out.write("<th>설치기관</th>");
	out.write("<th>서비스구분</th>");
	out.write("<th>망종류</th>");
	out.write("<th>설치년도</th>");
	out.write("<th>실내외구분</th>");
	out.write("<th>WIFI접속환경</th>");
	out.write("<th>X좌표</th>");
	out.write("<th>Y좌표</th>");
	out.write("<th>작업일자</th>");
	out.write("</tr>");
	out.write("<tr class=\"tr1-1\">");
	out.write("<td colspan=\"17\">위치 정보를 입력한 후에 조회해 주세요</td>");
	out.write("</tr>");
	out.write("</table>");
	out.write("</div>");
	%>

</body>
</html>
