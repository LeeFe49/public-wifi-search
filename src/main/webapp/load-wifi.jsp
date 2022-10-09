<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>    
<%@ page import="db.TbPublicWifiInfo" %>
<%@ page import="db.WifiClass" %>
<!DOCTYPE html>
<%
	out.write("<html>");
	out.write("<head>");
	out.write("<meta charset=\"UTF-8\">");
	out.write("<title>Insert title here</title>");
	out.write("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">");
	out.write("</head>");
	out.write("<body>");
	out.write("<div class=\"loadwifi\">");
	out.write("<div class=\"title2\">");
	
	TbPublicWifiInfo wifiInfo = new TbPublicWifiInfo();
	String[] cnt = new String[1];
	List<WifiClass> list = wifiInfo.list(cnt);
		
	out.write("<p>" + cnt[0] + "개의 WIFI 정보를 정상적으로 저장하였습니다.</p>");
	out.write("</div>");
	out.write("<a href=\"http://localhost:8080/zerobase-study21/home.jsp\">홈 으로 가기</a>");
 
	out.write("</div>");
	out.write("</body>");
	out.write("</html>");
%>