package db;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LoadDb {
	public void resetHistory() {
		String url = "jdbc:mariadb://localhost:3306/projectdb1";
		String dbUserId = "testuser1";
		String dbPassword = "0409";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			String sql = "truncate history";

			int affected;

			preparedStatement = connection.prepareStatement(sql);

			affected = preparedStatement.executeUpdate();
			if (affected < 0) {
				System.out.println("저장 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (rs != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void resetInfo() {
		String url = "jdbc:mariadb://localhost:3306/projectdb1";
		String dbUserId = "testuser1";
		String dbPassword = "0409";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			String sql = "truncate info";

			int affected;

			preparedStatement = connection.prepareStatement(sql);

			affected = preparedStatement.executeUpdate();
			if (affected < 0) {
				System.out.println("저장 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (rs != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteInfoError() {
		String url = "jdbc:mariadb://localhost:3306/projectdb1";
		String dbUserId = "testuser1";
		String dbPassword = "0409";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			String sql = "delete from info where (lnt>90 or lnt<-90);";

			int affected;

			preparedStatement = connection.prepareStatement(sql);

			affected = preparedStatement.executeUpdate();
			if (affected < 0) {
				System.out.println("저장 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (rs != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void initDb(List<WifiClass> list) {

		resetInfo();
		String url = "jdbc:mariadb://localhost:3306/projectdb1";
		String dbUserId = "testuser1";
		String dbPassword = "0409";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			String sql = "insert into info(distance, X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_ADRES1"
					+ ", X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY"
					+ ", X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, "
					+ "X_SWIFI_REMARS3, name, LAT, LNT, WORK_DTTM)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

			int affected;

			for (int i = 0; i < list.size(); i++) {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, "");
				preparedStatement.setString(2, list.get(i).getX_SWIFI_MGR_NO());
				preparedStatement.setString(3, list.get(i).getX_SWIFI_WRDOFC());
				preparedStatement.setString(4, list.get(i).getX_SWIFI_ADRES1());
				preparedStatement.setString(5, list.get(i).getX_SWIFI_ADRES2());
				preparedStatement.setString(6, list.get(i).getX_SWIFI_INSTL_FLOOR());
				preparedStatement.setString(7, list.get(i).getX_SWIFI_INSTL_TY());
				preparedStatement.setString(8, list.get(i).getX_SWIFI_INSTL_MBY());
				preparedStatement.setString(9, list.get(i).getX_SWIFI_SVC_SE());
				preparedStatement.setString(10, list.get(i).getX_SWIFI_CMCWR());
				preparedStatement.setString(11, list.get(i).getX_SWIFI_CNSTC_YEAR());
				preparedStatement.setString(12, list.get(i).getX_SWIFI_INOUT_DOOR());
				preparedStatement.setString(13, list.get(i).getX_SWIFI_REMARS3());
				preparedStatement.setString(14, list.get(i).getX_SWIFI_MAIN_NM());
				preparedStatement.setString(15, list.get(i).getLAT());
				preparedStatement.setString(16, list.get(i).getLNT());
				preparedStatement.setString(17, list.get(i).getWORK_DTTM());

				affected = preparedStatement.executeUpdate();
				if (affected < 0) {
					System.out.println("저장 실패");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (rs != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		deleteInfoError();
	}

	public void dbSelectTest1(String x, String y) {
		String url = "jdbc:mariadb://localhost:3306/projectdb1";
		String dbUserId = "testuser1";
		String dbPassword = "0409";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			String sql = "Set @location = POINT(" + x + "," + y + ");";
			System.out.println("x좌표: " + x + " y좌표: " + y);

			int affected;

			preparedStatement = connection.prepareStatement(sql);

			affected = preparedStatement.executeUpdate();
			if (affected < 0) {
				System.out.println("저장 실패");
			} else {
				System.out.println("좌표 설정 완료");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (rs != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<WifiClass> dbSelectTest2(String x, String y) {

		List<WifiClass> list = new ArrayList<>();

		String url = "jdbc:mariadb://localhost:3306/projectdb1";
		String dbUserId = "testuser1";
		String dbPassword = "0409";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		// String memberTypeValue = "limit";

		try {
			System.out.println("--check1--");
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			String sql = "SELECT\r\n"
					+ "    *, (\r\n"
					+ "      6371 * acos (\r\n"
					+ "      cos ( radians("+x+") )\r\n"
					+ "      * cos( radians( lat ) )\r\n"
					+ "      * cos( radians( lnt ) - radians("+y+") )\r\n"
					+ "      + sin ( radians("+x+") )\r\n"
					+ "      * sin( radians( lat ) )\r\n"
					+ "    )\r\n"
					+ ") AS dis\r\n"
					+ "from info\r\n"
					+ "order by dis limit 20;";
			

			int affected;
			
			System.out.println(sql);

			preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setString(1, " ");

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				// System.out.println("hi");
				// wificlass 객체 반환하기
				// (임의로 서대문구 위치한 객체 반환으로 테스트)
				// 후에 list에 하나씩 추가
				// list 반환 후 테이블 표현
				WifiClass tmp = new WifiClass();
				tmp.setDistance(Double.toString(rs.getDouble("dis")));
				tmp.setX_SWIFI_MGR_NO(rs.getString("X_SWIFI_MGR_NO"));
				tmp.setX_SWIFI_WRDOFC(rs.getString("X_SWIFI_WRDOFC"));
				tmp.setX_SWIFI_ADRES1(rs.getString("X_SWIFI_ADRES1"));
				tmp.setX_SWIFI_ADRES2(rs.getString("X_SWIFI_ADRES2"));
				tmp.setX_SWIFI_INSTL_FLOOR(rs.getString("X_SWIFI_INSTL_FLOOR"));
				tmp.setX_SWIFI_INSTL_TY(rs.getString("X_SWIFI_INSTL_TY"));
				tmp.setX_SWIFI_INSTL_MBY(rs.getString("X_SWIFI_INSTL_MBY"));
				tmp.setX_SWIFI_SVC_SE(rs.getString("X_SWIFI_SVC_SE"));
				tmp.setX_SWIFI_CMCWR(rs.getString("X_SWIFI_CMCWR"));
				tmp.setX_SWIFI_CNSTC_YEAR(rs.getString("X_SWIFI_CNSTC_YEAR"));
				tmp.setX_SWIFI_INOUT_DOOR(rs.getString("X_SWIFI_INOUT_DOOR"));
				tmp.setX_SWIFI_REMARS3(rs.getString("X_SWIFI_REMARS3"));
				tmp.setX_SWIFI_MAIN_NM(rs.getString("name"));
				tmp.setLAT(rs.getString("LAT"));
				tmp.setLNT(rs.getString("LNT"));
				tmp.setWORK_DTTM(rs.getString("WORK_DTTM"));

				list.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (rs != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void register(String X_SWIFI_MGR_NO, String WORK_DTTM, String LAT, String LNT) {
		String url = "jdbc:mariadb://localhost:3306/projectdb1";
		String dbUserId = "testuser1";
		String dbPassword = "0409";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			String sql = "insert into history(X_SWIFI_MGR_NO, WORK_DTTM, LAT, LNT)\n" + "values (?, ?, ?, ?);";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, X_SWIFI_MGR_NO);
			preparedStatement.setString(2, WORK_DTTM);
			preparedStatement.setString(3, LAT);
			preparedStatement.setString(4, LNT);

			int affected = preparedStatement.executeUpdate();

			if (affected > 0) {
				System.out.println("저장 성공");
			} else {
				System.out.println("저장 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (rs != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void withdraw(String X_SWIFI_MGR_NO) {

		String url = "jdbc:mariadb://localhost:3306/projectdb1";
		String dbUserId = "testuser1";
		String dbPassword = "0409";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// Statement statement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			String sql = "delete from history\n" + "where X_SWIFI_MGR_NO=?;";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, X_SWIFI_MGR_NO);

			int affected = preparedStatement.executeUpdate();

			if (affected > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (rs != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void test(String X_SWIFI_MGR_NO, String WORK_DTTM, String LAT, String LNT) {
		resetHistory();
		String url = "jdbc:mariadb://localhost:3306/projectdb1";
		String dbUserId = "testuser1";
		String dbPassword = "0409";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			String sql = "insert into history\n" + "values (?, ?, ?, ?);";

			int affected;

			for (int i = 0; i < 3; i++) {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, X_SWIFI_MGR_NO + Integer.toString(i));
				preparedStatement.setString(2, WORK_DTTM + Integer.toString(i));
				preparedStatement.setString(3, LAT + Integer.toString(i));
				preparedStatement.setString(4, "");

				affected = preparedStatement.executeUpdate();
				if (affected < 0) {
					System.out.println("저장 실패");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (rs != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void autuSaveHistory(List<WifiClass> list) {

		String url = "jdbc:mariadb://localhost:3306/projectdb1";
		String dbUserId = "testuser1";
		String dbPassword = "0409";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		LocalDateTime now = LocalDateTime.now();

		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			String sql = "insert into history(WORK_DTTM, LAT, LNT)"+
					"values(?,?,?);";

			int affected;

			for (int i = 0; i < list.size(); i++) {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, now.toString());
				preparedStatement.setString(2, list.get(i).getLAT());
				preparedStatement.setString(3, list.get(i).getLNT());

				affected = preparedStatement.executeUpdate();
				if (affected < 0) {
					System.out.println("저장 실패");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (rs != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<WifiClass> loadHistory() {

		List<WifiClass> list = new ArrayList<>();

		String url = "jdbc:mariadb://localhost:3306/projectdb1";
		String dbUserId = "testuser1";
		String dbPassword = "0409";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		// String memberTypeValue = "limit";

		try {
			System.out.println("--check1--");
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			String sql = "select * from history;";
			

			int affected;
			
			System.out.println(sql);

			preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setString(1, " ");

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				// System.out.println("hi");
				// wificlass 객체 반환하기
				// (임의로 서대문구 위치한 객체 반환으로 테스트)
				// 후에 list에 하나씩 추가
				// list 반환 후 테이블 표현
				WifiClass tmp = new WifiClass();
				tmp.setLAT(rs.getString("LAT"));
				tmp.setLNT(rs.getString("LNT"));
				tmp.setWORK_DTTM(rs.getString("WORK_DTTM"));

				list.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (rs != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void deleteFromHistory(String x, String y, String time) {

		String url = "jdbc:mariadb://localhost:3306/projectdb1";
		String dbUserId = "testuser1";
		String dbPassword = "0409";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// Statement statement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			String sql = "delete from history\n" + "where LAT=? and LNT=? and WORK_DTTM=?;";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, x);
			preparedStatement.setString(2, y);
			preparedStatement.setString(3, time);

			int affected = preparedStatement.executeUpdate();

			if (affected > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (rs != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
