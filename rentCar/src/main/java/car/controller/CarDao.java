package car.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import car.Car;
import util.DBManager;

public class CarDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private CarDao() {}

	private static CarDao instance = new CarDao();

	public static CarDao getInstance() {
		return instance;
	}
	
	public Car getCarByCarCode(int carCode) {
		Car car = null;
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			try {
				String sql = "SELECT * FROM car WHERE car_code = ?";
				
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, carCode);
				this.rs = this.pstmt.executeQuery();
				
				while(rs.next()) {
					String imagePath = this.rs.getString(3);
					int price = this.rs.getInt(4);
					String name = this.rs.getString(5);
					String date = this.rs.getString(6);
					
					car = new Car(carCode,imagePath, price, name, date);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return car;
	}
	
	public ArrayList<Car> getCarByPlaceCode(String placeCode) {
		ArrayList<Car> list = new ArrayList<>();
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			try {
				String sql = "SELECT * FROM car WHERE place_code = ?";
				
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, placeCode);
				this.rs = this.pstmt.executeQuery();
				
				while(rs.next()) {
					Car car = null;
					int carCode = this.rs.getInt(1);
					String imagePath = this.rs.getString(3);
					int price = this.rs.getInt(4);
					String name = this.rs.getString(5);
					String date = this.rs.getString(6);
					
					car = new Car(carCode,imagePath, price, name, date);
					list.add(car);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}
	
	public ArrayList<Car> getCarAll(){
		ArrayList<Car> list = new ArrayList<>();
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			try {
				String sql = "SELECT * FROM car ORDER BY car_code";
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					Car car = null;
					int carCode = this.rs.getInt(1);
					String imagePath = this.rs.getString(3);
					int price = this.rs.getInt(4);
					String name = this.rs.getString(5);
					String date = this.rs.getString(6);
					
					car = new Car(carCode,imagePath, price, name, date);
					list.add(car);
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
