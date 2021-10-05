package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insertTest01 {

	public static void main(String[] args) {
		insert("영업");
		insert("개발");
		insert("기획");
		
	}

	private static boolean insert(String name) {
		Connection conn = null;
		boolean result =false;
		Statement stmt = null;
		try {
			//1. JDBC Drive 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결
			String url = "jdbc:mysql://127.0.0.1:3306/employees?charset=utf-8";
			conn = DriverManager.getConnection(url, "hr","hr");
			
			//3. statement 생성
			stmt = conn.createStatement();
			
			//4. SQL실행
			String sql ="insert into dept values(null, '"+ name +"')";
			int count = stmt.executeUpdate(sql);
			
			result = count == 1;
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch(SQLException e) {
			System.out.println("error:" + e);
		}
		finally {
			//clean up
			try {
				if(stmt != null) {
				stmt.close();
				}

				if(conn != null) {
				conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
