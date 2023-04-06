package user.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import user.User;
import user.UserRequestDto;
import util.DBManager;

public class UserDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private UserDao() {}
	private static UserDao instance = new UserDao();
	public static UserDao getInstance() {
		return instance;
	}
	
	public void createUser(UserRequestDto userDto) {
		User user = new User(userDto);
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "INSERT INTO users VALUES(?,?,?,?,?,TO_DATE(?,'YYYY-MM-DD'))";	
		try {			
			this.pstmt = this.conn.prepareStatement(sql);
			
			this.pstmt.setInt(1, user.getUser_code());
			this.pstmt.setString(2, user.getName());
			this.pstmt.setString(3, user.getId());
			this.pstmt.setString(4, user.getPassword());
			this.pstmt.setString(5, user.getContact());
			this.pstmt.setString(6, user.getJoindate());
			
			this.pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		}
	}

	public User getUserByCustno(int userCode) {
		User user = null;
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			try {
				String sql = "SELECT * FROM users WHERE user_code=?";
				
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, userCode);
				this.rs = this.pstmt.executeQuery();
				
				while(rs.next()) {
					String name = this.rs.getString(2);
					String id = this.rs.getString(3);
					String password = this.rs.getString(4);
					String contact = this.rs.getString(5);
					String joindate = this.rs.getString(6);
					
					user = new User(userCode, name, id, password, contact, joindate);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return user;
	}
	
	public ArrayList<User> getUserAll() {
		ArrayList<User> list = new ArrayList<>();

		this.conn = DBManager.getConnection();
		if (this.conn != null) {

			try {
				String sql = "SELECT * FROM users ORDER BY user_code";
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					User user = null;
					int user_code = this.getUser_codeMax()+1;
					String name = this.rs.getString(2);
					String id = this.rs.getString(3);
					String password = this.rs.getString(4);
					String contact = this.rs.getString(5);
					String joindate = this.rs.getString(6);
					
					user = new User(user_code, name, id, password, contact, joindate);

					list.add(user);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}
	
	public int getUser_codeMax() {
		int userCode = 1001;
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "SELECT MAX(user_code) FROM users";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				this.rs.next();
				userCode = this.rs.getInt(1);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userCode;
	}
	
	public void updateUser(UserRequestDto userDto) {
		this.conn = DBManager.getConnection();
		if(this.conn != null) {			
			String sql = "UPDATE users SET name=?, id=?, password=?, contact=?,joindate=TO_DATE(?,'YYYY-MM-DD') WHERE user_code=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				
				this.pstmt.setString(1, userDto.getName());
				this.pstmt.setString(2, userDto.getId());
				this.pstmt.setString(3, userDto.getPassword());
				this.pstmt.setString(5, userDto.getContact());
				this.pstmt.setString(6, userDto.getJoindate());
				this.pstmt.setInt(7, userDto.getUser_code());
				
				this.pstmt.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}
	
	public void remeveUserByUser_code(int userCode) {
		User user = getUserByCustno(userCode);
		this.conn = DBManager.getConnection();
		
		if(user != null && this.conn != null) {
			String sql = "DELETE FROM users WHERE user_code=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, userCode);
				this.pstmt.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn,pstmt);
			}
		}
	}
}
