package board.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import board.Board;
import util.DBManager;

public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private BoardDao() {}
	
	private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	public ArrayList<Board> getBoardAll(){
		ArrayList<Board> list = new ArrayList<>();
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			try {
				String sql = "SELECT * FROM board ORDER BY content_num";
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					Board board = null;
					int contentNum = this.rs.getInt(1);
					int userCode = this.rs.getInt(2);
					String name = this.rs.getString(3);
					String content = this.rs.getString(4);
					String title = this.rs.getString(5);
					String addDate = this.rs.getString(6);
					
					board = new Board(contentNum,userCode, name, content, title, addDate);
					list.add(board);					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}

	public Board getBoardByContentNum(int contentNum) {
		Board board = null;
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			try {
				String sql = "SELECT * FROM board WHERE content_num = ?";
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, contentNum);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int userCode = this.rs.getInt(2);
					String name = this.rs.getString(3);
					String content = this.rs.getString(4);
					String title = this.rs.getString(5);
					String addDate = this.rs.getString(6);

					board = new Board(contentNum, userCode, name, content, title, addDate);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return board;
	}
}
