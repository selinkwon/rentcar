package car;

public class CarDto {

	private int carCode,price;
	private String name,date,placeCode,imagePath;
	
	public CarDto(int carCode, String placeCode, String imagePath, int price, String name, String date) {
		this.carCode = carCode;
		this.placeCode = placeCode;
		this.price = price;
		this.name = name;
		this.date = date;
	}
	
	public CarDto(int carCode, String imagePath, int price, String name, String date) {
		this.carCode = carCode;
		this.imagePath = imagePath;
		this.price = price;
		this.name = name;
		this.date = date;
	}
	

	public int getCarCode() {
		return carCode;
	}

	public void setCarCode(int carCode) {
		this.carCode = carCode;
	}
	

	public String getPlaceCode() {
		return placeCode;
	}


	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}


	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
