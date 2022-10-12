package db;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
public class TbPublicWifiInfo {
	public static List<WifiClass> list(String[] cnt, int a, int b) throws IOException{
		StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
		urlBuilder.append("/" +  URLEncoder.encode("4445686c456368753836486758657a","UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
		urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
		urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
		urlBuilder.append("/" + URLEncoder.encode(Integer.toString(a),"UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
		urlBuilder.append("/" + URLEncoder.encode(Integer.toString(b),"UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
		// 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.
		
		// 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다.
		urlBuilder.append("/" + URLEncoder.encode("20220301","UTF-8")); /* 서비스별 추가 요청인자들*/
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/xml");
		System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
		BufferedReader rd;

		// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			
			System.out.println(rd.getClass());
			sb.append(line); 
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		
		String arr = sb.toString();
		
		int count=0;
		for(int i=0;i<arr.length()-2;i++) {
			if(arr.charAt(i)=='L' && arr.charAt(i+1)=='A' && arr.charAt(i+2)=='T') {
				count++;
				i+=2;
			}
		}
		//System.out.println("개수 : "+ count);
		
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(sb.toString());
		JsonObject rootob = element.getAsJsonObject().get("TbPublicWifiInfo").getAsJsonObject();
		
		
		Gson gson = new Gson();
		JsonArray item = rootob.getAsJsonObject().get("row").getAsJsonArray();
		List<WifiClass> list = gson.fromJson(item.toString(), new TypeToken<List<WifiClass>>()
				{}.getType());
		
		JsonElement tmp = rootob.get("list_total_count");
		cnt[0] = tmp.getAsString();
		
//		System.out.println(rootob.get("list_total_count").getAsString());
		cnt[0] = rootob.get("list_total_count").getAsString();
		
		return list;
	}
	public static void main(String[] args) throws IOException {
		LoadDb db = new LoadDb();
//		db.withdraw("test3");
//		db.dbSelect();
		
		//db.register("test3", "test3", "test3", "test3");
//		System.out.println(list.get(0).getX_SWIFI_ADRES1());
//		System.out.println(list.get(0).getX_SWIFI_ADRES2());
//		System.out.println(list.get(5).getX_SWIFI_ADRES2());
		
//		System.out.println(rootob.get("list_total_count"));
		
		//___________________
		
//		TbPublicWifiInfo wifiInfo = new TbPublicWifiInfo();
//		
//		String[] cnt = new String[1];
//
//		List<WifiClass> list = wifiInfo.list(cnt, 1, 100);
//		List<WifiClass> tmp;
//		int count = Integer.parseInt(cnt[0]);
//		System.out.println(count);
//		int i;
//		for(i=101;i<count;i+=100) {
//			tmp = wifiInfo.list(cnt, i,i+99);
//			list.addAll(tmp);
//		}
//		
//		System.out.println(cnt[0]);
//		System.out.println(list.size()+"개 로드 성공!");
//		
//		System.out.println(list.get(list.size()-1).getX_SWIFI_WRDOFC());
//		db.initDb(list);
		
		//_________________
		
		//db.resetHistory();
//		db.test("b", "b", "b", "b");
		
		List<WifiClass> list = db.dbSelectTest2("126.870769","37.6492331");
		for(WifiClass wifi : list) {
			System.out.println(wifi.getX_SWIFI_MGR_NO()+" "+ wifi.getX_SWIFI_ADRES1()+" "+wifi.getX_SWIFI_ADRES2()+" "+wifi.getDistance());
		}
	}
}