<%@page import="db.WifiClass"%>
<%@page import="java.util.List"%>
<%@page import="db.LoadDb"%>
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
		<form>
			<label id="lat" for="lat">LAT: </label> <input type="text"
				id="getLat" name="lat"><span> , </span> <label id="lnt"
				for="lnt">LNT: </label> <input type="text" id="getLnt" name="lnt"><span>
			</span>
			<button type="button" onclick="myLoc()">내 위치 가져오기</button>
			<span> </span>
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

			function showWifi() {
				alert("조회중!")
			}

			function loading() {
				alert("로딩중이니 잠시 기다려주세요!");
			}
		</script>
	</div>
	<%
	String x = request.getParameter("lat");
	String y = request.getParameter("lnt");
	
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
	
	LoadDb db = new LoadDb();
	db.dbSelectTest1(y, x);
	List<WifiClass> list = db.dbSelectTest2(y, x);
	
	
	for(WifiClass wifi : list){
		out.write("<tr>");
		out.write("<td>"+wifi.getDistance()+"</td>");
		out.write("<td>"+wifi.getX_SWIFI_MGR_NO()+"</td>");
		out.write("<td>"+wifi.getX_SWIFI_WRDOFC()+"</td>");
		out.write("<td>"+wifi.getX_SWIFI_MAIN_NM()+"</td>");
		out.write("<td>"+wifi.getX_SWIFI_ADRES1()+"</td>");
		out.write("<td>"+wifi.getX_SWIFI_ADRES2()+"</td>");
		out.write("<td>"+wifi.getX_SWIFI_INSTL_FLOOR()+"</td>");
		out.write("<td>"+wifi.getX_SWIFI_INSTL_TY()+"</td>");
		out.write("<td>"+wifi.getX_SWIFI_INSTL_MBY()+"</td>");
		out.write("<td>"+wifi.getX_SWIFI_SVC_SE()+"</td>");
		out.write("<td>"+wifi.getX_SWIFI_CMCWR()+"</td>");
		out.write("<td>"+wifi.getX_SWIFI_CNSTC_YEAR()+"</td>");
		out.write("<td>"+wifi.getX_SWIFI_INOUT_DOOR()+"</td>");
		out.write("<td>"+wifi.getX_SWIFI_REMARS3()+"</td>");
		out.write("<td>"+wifi.getLAT()+"</td>");
		out.write("<td>"+wifi.getLNT()+"</td>");
		out.write("<td>"+wifi.getWORK_DTTM()+"</td>");
		out.write("</tr>");
	}
	out.write("</table>");
	out.write("</div>");
	
	out.write("<p>"+x+" "+y+"</p>");
	
	%>
	

</body>
</html>
