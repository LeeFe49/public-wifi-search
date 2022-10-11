<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	out.write("<html>");
	out.write("<head>");
	out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Home</title>");
		out.write("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">");
	out.write("</head>");
	out.write("<body>");
		out.write("<h2 class=\"title1\"><b>와이파이 정보 구하기</b></h2>");
			out.write("<div>");
				out.write("<a href=\"http://localhost:8080/zerobase-study21/home.jsp\">홈</a><span> | </span>");
				out.write("<a href=\"http://localhost:8080/zerobase-study21/history.jsp\">위치 히스토리 목록</a><span> | </span>");
				out.write("<a href=\"http://localhost:8080/zerobase-study21/load-wifi.jsp\" onclick=\"loading()\">Open API 와이파이 정보 가져오기</a>");
			out.write("</div>");
			out.write("<br>");
			out.write("<div>");
				
					out.write("<label id=\"lat\" for=\"lat\">LAT: </label>");
					out.write("<input type=\"text\" id=\"getLat\" name=\"lat\"><span> , </span>");
					out.write("<label id=\"lnt\" for=\"lnt\">LNT: </label>");
					out.write("<input type=\"text\" id=\"getLnt\" name=\"lnt\"><span> </span>");
					out.write("<button onclick=\"myLoc()\">내 위치 가져오기</button><span> </span>");
					out.write("<button onclick=\"myLoc2\">근처 WIFI 정보 보기</button>");
					
					out.write("<script>");
					
					out.write("const x = document.getElementById(\"getLat\");");
					out.write("const y = document.getElementById(\"getLnt\");");

					out.write("function myLoc() {");
						out.write("if (navigator.geolocation) {");
						out.write("navigator.geolocation.getCurrentPosition(showPosition);");
						out.write("} else { ");
						out.write("x.value = \"Geolocation not found.\";");
						out.write("y.value = \"Geolocation not found.\";");
						out.write("}");
					out.write("}");

					out.write("function showPosition(position) {");
						out.write("x.value = position.coords.latitude;");
						out.write("y.value = position.coords.longitude;");
					out.write("}");
					
					out.write("function loading() {");
					out.write("alert(\"로딩중이니 잠시 기다려주세요!\");");
				out.write("}");

					out.write("</script>");
				
			out.write("</div>");
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
		out.write("</body>");
	out.write("</html>");
 %>