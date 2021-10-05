### 서브쿼리

단일행 서브쿼리는
단일행 연산자를 사용하고(=, >, <, >=, <=, <>, !=)
서브쿼리로 인해 전달되는 행이 단 하나여야한다.

서브쿼리는 하나의 테이블로도
사용될수 있다.
ex) select * from(select now());

다중행 서브쿼리
전달되는 행이 여러개인 경우
복수행 연산자: in, not in, any, all

-- any 사용법
-- 1. =any: in(1,10,20)
-- 2. >any, >=any: 최소값
-- 3. <any, <=any: 최대값
-- 4. <>any : not in과 동일

-- all사용법
-- 1. =all (사용불가)
-- 2. >all, >=all : 최대값
-- 3. <all, <=all : 최소값


### JDBC

#### connection

```
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			//1. JDBC Drive 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf-8";
			conn = DriverManager.getConnection(url, "webdb","webdb");
			
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch(SQLException e) {
			System.out.println("error:" + e);
		}
		finally {
			try {
				if(conn != null) {
				conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

```
> ##### 드라이버 로드
Class.forName("oracle.jdbc.driver.OracleDriver");
##### Connection연결
String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf-8";
			conn = DriverManager.getConnection(url, "webdb","webdb");
##### connection 닫기
conn.close();

#### insert01
```
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

```
> ##### 드라이버 로드
Class.forName("oracle.jdbc.driver.OracleDriver");
##### Connection연결
String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf-8";
			conn = DriverManager.getConnection(url, "webdb","webdb");
##### statement 생성
stmt = conn.createStatement();
##### SQL실행
String sql ="insert into dept values(null, '"+ name +"')";
int count = stmt.executeUpdate(sql);
##### close()
stmt.close();
conn.close();

#### update01
```
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest01 {

	public static void main(String[] args) {
		DeptVo vo = new DeptVo();
		vo.setNo(8L);
		vo.setName("전략기획팀");
		
		Boolean result = update(vo);
		if(result) {
			System.out.println("성공!");
		}
	}

	private static Boolean update(DeptVo vo) {
		boolean result = false;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			//3. Statement 생성
			stmt = conn.createStatement();
			
			//4. SQL 실행
			String sql =
				"update dept" + 
			    "   set name='" + vo.getName() + "'" +
			    " where no=" + vo.getNo();
			
			int count = stmt.executeUpdate(sql);
			
			result = count == 1;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// clean up
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

```
> ##### 드라이버 로드
Class.forName("oracle.jdbc.driver.OracleDriver");
##### Connection연결
String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf-8";
			conn = DriverManager.getConnection(url, "webdb","webdb");
##### statement 생성
stmt = conn.createStatement();
##### SQL실행
			String sql =
				"update dept" + 
			    "   set name='" + vo.getName() + "'" +
			    " where no=" + vo.getNo();
			
			int count = stmt.executeUpdate(sql);
##### close()
stmt.close();
conn.close();


#### delete
```
package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class DeleteTest01 {


	public static void main(String[] args) {
		Boolean result =  delete(5L);
		System.out.println(result ? "성공" : "실패");
	}

	private static Boolean delete(long no) {
		boolean result = false;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			//3. Statement 생성
			stmt = conn.createStatement();
			
			//4. SQL 실행
			String sql = "delete from dept where no=" + no;
			int count = stmt.executeUpdate(sql);
			
			result = count == 1;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// clean up
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

```
> ##### 드라이버 로드
Class.forName("oracle.jdbc.driver.OracleDriver");
##### Connection연결
String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf-8";
			conn = DriverManager.getConnection(url, "webdb","webdb");
##### statement 생성
stmt = conn.createStatement();
##### SQL실행
			String sql = "delete from dept where no=" + no;
			int count = stmt.executeUpdate(sql);
##### close()
stmt.close();
conn.close();



#### select01
```
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest01 {

	public static void main(String[] args) {
		search("pat");
	}
	
	public static void search(String keyword) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			//3. Statement 생성
			stmt = conn.createStatement();
			
			//4. SQL 실행
			String sql = 
				"select emp_no, first_name " + 
			    "  from employees" + 
			    " where first_name like '%" + keyword + "%'";
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Long empNo = rs.getLong(1);
				String firstName = rs.getString(2);
				System.out.println(empNo + ":" + firstName);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// clean up
			try {
				if(rs != null) {
					rs.close();
				}				
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
	}

}

```
> ##### 드라이버 로드
Class.forName("oracle.jdbc.driver.OracleDriver");
##### Connection연결
String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf-8";
			conn = DriverManager.getConnection(url, "webdb","webdb");
##### statement 생성
stmt = conn.createStatement();
##### SQL실행
			String sql = 
				"select emp_no, first_name " + 
			    "  from employees" + 
			    " where first_name like '%" + keyword + "%'";
			rs = stmt.executeQuery(sql); /'/ResultSet으로 결과받기
			while(rs.next()) {
				Long empNo = rs.getLong(1);
				String firstName = rs.getString(2);
				System.out.println(empNo + ":" + firstName);
			}
##### close()
rs.close();
stmt.close();
conn.close();