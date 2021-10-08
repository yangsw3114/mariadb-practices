package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;



public class CartDao {

	public boolean insert(CartVo vo) {
		Connection conn = null;
		boolean result =false;
		PreparedStatement pstmt = null;
		try {
			
			conn = getConnection();
			//3. SQL문 준비
			String sql ="insert into cart values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩(binding)
			pstmt.setInt(1, vo.getCount());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setLong(3, vo.getMemberNo());

			
			//5. SQL실행
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			//System.out.println("bookmall_cartdao_insert\n");
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
	
	
	public List<CartVo> findAll() {
		
		List<CartVo> result = new ArrayList<CartVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			
			conn = getConnection();
			
			//3. SQL문 준비
			String sql ="select count, book_no, member_no from cart;";
			pstmt = conn.prepareStatement(sql);
			
			
			//5. SQL실행
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int count = rs.getInt(1);
				Long book_no = rs.getLong(2);
				Long member_no = rs.getLong(3);
	
				
				CartVo vo = new CartVo();
				vo.setCount(count);
				vo.setBookNo(book_no);
				vo.setMemberNo(member_no);
				
				result.add(vo);
			}
			//System.out.println("bookmall_Cartdao_findall\\n");
			
			
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
