<%@page import="db.LoadDb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="db.TbPublicWifiInfo"%>
<%@ page import="db.WifiClass"%>
<!DOCTYPE html>
<%
out.write("<html>");
out.write("<head>");
out.write("<meta charset=\"UTF-8\">");
out.write("<title>Load-WIFI</title>");
out.write("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">");
out.write("</head>");
out.write("<body>");
out.write("<div class=\"loadwifi\">");
out.write("<div class=\"title2\">");

LoadDb db = new LoadDb();
//TbPublicWifiInfo wifiInfo = new TbPublicWifiInfo();
String[] cnt = new String[1];
List<WifiClass> list = TbPublicWifiInfo.list(cnt, 1, 100);

List<WifiClass> tmp;
int count = Integer.parseInt(cnt[0]);
System.out.println(count);
int i;
for (i = 101; i < count; i += 100) {
	tmp = TbPublicWifiInfo.list(cnt, i, i + 99);
	list.addAll(tmp);
}

System.out.println(cnt[0]);
System.out.println(list.size() + "개 로드 성공!");

System.out.println(list.get(list.size() - 1).getX_SWIFI_WRDOFC());
db.initDb(list);

out.write("<p>" + list.size() + "개의 WIFI 정보를 정상적으로 저장하였습니다.</p>");
System.out.println("테스트2: "+ list.size());
out.write("</div>");
out.write("<a href=\"http://localhost:8080/zerobase-study21/home.jsp\">홈 으로 가기</a>");

out.write("</div>");
out.write("</body>");
out.write("</html>");
%>