package place.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import place.Place;
import util.DBManager;

public class PlaceDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private PlaceDao() {}

	private static PlaceDao instance = new PlaceDao();

	public static PlaceDao getInstance() {
		return instance;
	}
	
	public ArrayList<Place> getPlaceAll(){
		ArrayList<Place> list = new ArrayList<>();
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			try {
				String sql = "SELECT * FROM place ORDER BY place_cod";
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					Place place = null;
					String placeCode = this.rs.getString(1);
					String name = this.rs.getString(2);
					
					place = new Place(placeCode, name);
					list.add(place);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}
}
