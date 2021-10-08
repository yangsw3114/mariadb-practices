package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrderVo;


public class OrderDao {
	
	public boolean insert(OrderVo vo) {
		Connection conn = null;
		boolean result =false;
		PreparedStatement pstmt = null;
		try {
			
			conn = getConnection();
			//3. SQL문 준비
			String sql ="insert into order_ values(null,?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩(binding)
			pstmt.setInt(1, vo.getOrderNum());
			pstmt.setInt(2, vo.getPayprice());
			pstmt.setString(3, vo.getShipaddress());
			pstmt.setLong(4, vo.getMemberNo());
			
			//5. SQL실행
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			//System.out.println("bookmall_orderdao_insert\n");
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
	
	
	public List<OrderVo> findAll() {
		
		List<OrderVo> result = new ArrayList<OrderVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			
			conn = getConnection();
			
			//3. SQL문 준비
			String sql ="select no, order_num, payprice, shipaddress, member_no from order_";
			pstmt = conn.prepareStatement(sql);
			
			
			//5. SQL실행
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Long no = rs.getLong(1);
				int order_num = rs.getInt(2);
				int payprice = rs.getInt(3);
				String shipaddress = rs.getString(4);
				Long member_no = rs.getLong(5);
				
				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setOrderNum(order_num);
				vo.setPayprice(payprice);
				vo.setShipaddress(shipaddress);
				vo.setMemberNo(member_no);
				
				
				result.add(vo);
			}
			//System.out.println("bookmall_orderdao_findall\\n");
			
			
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
