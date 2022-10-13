<%@page import="db.LoadDb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="db.TbPublicWifiInfo"%>
<%@ page import="db.WifiClass"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h2 class="title1">
		<b>위치 히스토리 목록</b>
	</h2>
	<div>
		<a href="http://localhost:8080/zerobase-study21/home.jsp">홈</a><span>
			|</span> <a href="http://localhost:8080/zerobase-study21/history.jsp">위치
			히스토리 목록</a><span> |</span> <a
			href="http://localhost:8080/zerobase-study21/load-wifi.jsp">Open
			API 와이파이 정보 가져오기</a>
	</div>
	<br>
	<div>
		<table>
			<tr class="tr1">
				<td>ID</td>
				<td>X좌표</td>
				<td>Y좌표</td>
				<td>조회일자</td>
				<td>비고</td>
			</tr>
			<%
			LoadDb db = new LoadDb();
			List<WifiClass> list = db.loadHistory();
			int cnt = list.size();
			for (WifiClass wifi : list) {
				out.write("<tr>");
				out.write("<td>" + cnt + "</td>");
				out.write("<td>" + wifi.getLAT() + "</td>");
				out.write("<td>" + wifi.getLNT() + "</td>");
				out.write("<td>" + wifi.getWORK_DTTM() + "</td>");
				out.write("<td><button type=\"button\" onClick=\"remove(this)\">삭제</button></td>");
				out.write("</tr>");
				cnt--;
			}
			%>
			<tr class="tr1-1">
			</tr>
		</table>
		<%
		out.write("<script>");
		out.write("function remove(This) {");
				out.write("if(This.closest('tbody').childElementCount == 1)");
				out.write("{");
				out.write("alert(\"삭제할 수 없습니다.\");");
				out.write("}else{");
				out.write("This.closest('tr').remove();");
				out.write("}");
		out.write("}");
		out.write("</script>");
		 %>
	</div>
</body>
</html>