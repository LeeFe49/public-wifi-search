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
	<%--<input style="display: none;" type="text" id="lat" name="lat"> --%>
	<form name="form1" method="get">
		<input style="display: none;" type="text" id="lat" name="lat">
		<input style="display: none;" type="text" id="lnt" name="lnt"> 
		<input style="display: none;" type="text" id="time" name="time">
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
				System.out.println("history start");
				LoadDb db = new LoadDb();
				String x = request.getParameter("lat");
				String y = request.getParameter("lnt");
				String z = request.getParameter("time");
				db.deleteFromHistory(x, y, z);
				
				List<WifiClass> list = db.loadHistory();
				String a, b, c;

				

				int cnt = list.size();
				for (WifiClass wifi : list) {
					a = wifi.getLAT();
					b = wifi.getLNT();
					c = wifi.getWORK_DTTM();
					out.write("<tr>");
					out.write("<td>" + cnt + "</td>");
					out.write("<td>" + a + "</td>");
					out.write("<td>" + b + "</td>");
					out.write("<td>" + c + "</td>");
					out.write("<td><input type=\"submit\" onClick=\"remove(this);\" value=\"삭제\"></td>");
					out.write("</tr>");
					cnt--;
				}
				%>
				<tr class="tr1-1">
				</tr>
			</table>

			<%
			out.write("<script>");
			out.write("const x = document.getElementById(\"lat\");");
			out.write("const y = document.getElementById(\"lnt\");");
			out.write("const z = document.getElementById(\"time\");");
			out.write("function remove(This) {");
			out.write("if(This.closest('tbody').childElementCount == 1)");
			out.write("{");
			out.write("alert(\"삭제할 수 없습니다.\");");
			out.write("}else{");
			out.write("This.closest('tr').remove();");
			out.write("}");
			out.write("var tr=This.closest('tr');");
			out.write("x.value = tr.cells[1].innerText;");
			out.write("y.value = tr.cells[2].innerText;");
			out.write("z.value = tr.cells[3].innerText;");
			out.write("document.form1.submit()");
			out.write("}");
			out.write("</script>");
			%>
		</div>
	</form>
</body>
</html>