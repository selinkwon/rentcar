package place;

public class PlaceDto {

	
	private String placeName, placeCode;
	
	public PlaceDto() {}
	
	public PlaceDto(String placeCode, String placeName) {
		this.placeCode = placeCode;
		this.placeName = placeName;
	}

	public String getPlaceCode() {
		return placeCode;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
}
