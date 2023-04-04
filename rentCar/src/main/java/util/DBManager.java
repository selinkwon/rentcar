package util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	public static Connection getConnectionFromMySQL() {
		Connection conn = null;
		
		try {
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
}
