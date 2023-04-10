package place;

public class Place {
	
	private String placeCode, placeName;
	
	public Place(String placeCode, String placeName) {
		this.placeCode = placeCode;
		this.placeName = placeName;
	}
	
	public Place(PlaceDto placeDto) {
		this.placeCode = placeDto.getPlaceCode();
		this.placeName = placeDto.getPlaceName();
	}	

	public String getPlaceCode() {
		return placeCode;
	}

	public String getPlaceName() {
		return placeName;
	}
	
	
}
