package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverTest {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			//1. JDBC Driver 로딩
			Class.forName("driver.MyDriver"); //Driver인터페이스를 상속받은 MyDriver실행
			
			//2. 연결
			String url = "jdbc:mydb://127.0.0.1:2204/webdb";
			conn = DriverManager.getConnection(url, "webdb","webdb");
			
			//3. 연결 성공
			System.out.println("ok: " + conn);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: " + e);
		}catch(SQLException e) {
			
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
