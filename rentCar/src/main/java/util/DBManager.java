package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
//			Timestamp now = new Timestamp(System.currentTimeMillis()); // 현재시간
//			System.out.println(now);
			
			// 2023-04-04 18:10:01
			Date date = new Date(2023-1900, 4+1, 4, 18, 10, 1);
			Timestamp now  = new Timestamp(date.getTime());
			// JNDI
			// Java Naming and Directory Interface
			
			Context init = new InitialContext();
			DataSource source = (DataSource) init.lookup("java:comp/env/jdbc/test");
			conn = source.getConnection();
			
			System.out.println("DB 연동 성공!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연동 실패");
		}
		return conn;
	}
	


	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			conn.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
