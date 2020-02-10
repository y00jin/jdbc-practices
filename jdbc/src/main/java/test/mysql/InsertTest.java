package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		
		Boolean result = insert("기획팀");
		if(result) {
			System.out.println("성공");
		}
	}
	
	public static boolean insert(String name) {
		boolean result = false;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			// 1. JDBC Driver(MySQL) Loading
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			// 3. Statement 객체 생성
			stmt = conn.createStatement();
			
//	-----------------여기서부터-------------------------------------------------------------------
			
			// 4. SQL문 실행
			String sql = "insert into dept values(null,'"+name+"')";
			int count = stmt.executeUpdate(sql);
			
			// 5. 성공여부
			result = count == 1;
			
//	-----------------여기까지만 바뀜--------------------------------------------------------------
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			// 6. 자원정리
			try {
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
