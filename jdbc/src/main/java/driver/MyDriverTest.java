package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDriverTest {

	public static void main(String[] args) {
		
		try {
			// 1. JDBC Driver(MyDriver) Loading
			Class.forName("driver.MyDriver");
			
			// 2. 연결하기
			try {
				String url = "jdbc:mydb://127.0.0.1:9999/webdb";
				Connection connection = DriverManager.getConnection(url, "webdb","webdb");
				System.out.println(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	
}
