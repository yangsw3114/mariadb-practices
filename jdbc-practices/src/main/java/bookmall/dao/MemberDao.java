package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.MemberVo;


public class MemberDao {
	
	
	public boolean insert(MemberVo vo) {
		Connection conn = null;
		boolean result =false;
		PreparedStatement pstmt = null;
		try {
			
			conn = getConnection();
			//3. SQL문 준비
			String sql ="insert into member values(null, ?, ?, ?,?)";
			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩(binding)
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPassword());
			
			
			//5. SQL실행
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			//System.out.println("bookmall_Memberdao_insert\n");
		}catch(SQLException e) {
			System.out.println("error:" + e);
		}
		finally {
			//clean up
			try {
				if(pstmt != null) {
					pstmt.close();
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
	
	
	public List<MemberVo> findAll() {
		
		List<MemberVo> result = new ArrayList<MemberVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			
			conn = getConnection();
			
			//3. SQL문 준비
			String sql ="select no, name, tel, email, password from member";
			pstmt = conn.prepareStatement(sql);
			
			
			//5. SQL실행
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String tel = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);
				
				MemberVo vo = new MemberVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setTel(tel);
				vo.setEmail(email);
				vo.setPassword(password);
				
				result.add(vo);
			}
			//System.out.println("bookmall_Memberdao_findall\\n");
			
			
		}catch(SQLException e) {
			System.out.println("error:" + e);
		}
		finally {
			//clean up
			try {
				if(pstmt != null) {
					pstmt.close();
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

	//모든 dao insert랑 select만 하면됨

	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;
	}



	
	
}
