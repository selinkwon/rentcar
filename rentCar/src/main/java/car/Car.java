package car;

public class Car {
	
	private int carCode,price;
	private String name,date, placeCode,imagePath;
	
	public Car(int carCode, String placeCode, String imagePath, int price, String name, String date) {
		this.carCode = carCode;
		this.placeCode = placeCode;
		this.price = price;
		this.name = name;
		this.date = date;
	}
	
	public Car(int carCode, String imagePath, int price, String name, String date) {
		this.carCode = carCode;
		this.imagePath = imagePath;
		this.price = price;
		this.name = name;
		this.date = date;
	}
	
	public Car(CarDto carDto) {
		this.carCode = carDto.getCarCode();
		this.placeCode = carDto.getPlaceCode();
		this.price = carDto.getPrice();
		this.name = carDto.getName();
		this.date = carDto.getDate();
	}

	public int getCarCode() {
		return carCode;
	}

	public String getPlaceCode() {
		return placeCode;
	}

	public String getImagePath() {
		return imagePath;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}
	
}
