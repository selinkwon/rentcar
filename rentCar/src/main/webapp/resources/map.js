let container = document.getElementById('map'),
	map = new kakao.maps.Map(container, {
		center: new kakao.maps.LatLng(37.50308282223799, 130.86080767234358),
		level: 8
	});

let options = {
	map: map, // drawing manager로 그리기 요소를 그릴 map 객체 
	drawingMode: [ // drawing manager로 제공할 그리기 요소 모드
		kakao.maps.drawing.OverlayType.MARKER,
		kakao.maps.drawing.OverlayType.POLYLINE,
		kakao.maps.drawing.OverlayType.RECTANGLE,
		kakao.maps.drawing.OverlayType.CIRCLE,
		kakao.maps.drawing.OverlayType.POLYGON
	],
	guideTooltip: ['draw', 'drag', 'edit'], // 사용자에게 제공할 그리기 가이드 툴팁
	markerOptions: {
		draggable: true, // 마커를 그리고 나서 드래그 가능하게 한다
		removable: true // 마커를 삭제 할 수 있도록 x 버튼이 표시된다 
	},
	polylineOptions: {
		draggable: true, // 그린 후 드래그가 가능하며 guideTooltip옵션에 'drag'가 포함된 경우 툴팁이 표시된다
		removable: true, // 그린 후 삭제 할 수 있도록 x 버튼이 표시된다
		editable: true, // 그린 후 수정할 수 있도록 작은 사각형이 표시되며 guideTooltip옵션에 'edit'가 포함된 경우 툴팁이 표시된다
		strokeColor: '#39f', // 선 색
		hintStrokeStyle: 'dash', // 그리중 마우스를 따라다니는 보조선의 선 스타일
		hintStrokeOpacity: 0.5  // 그리중 마우스를 따라다니는 보조선의 투명도
	},
	rectangleOptions: {
		draggable: true,
		removable: true,
		editable: true,
		strokeColor: '#39f', // 외곽선 색
		fillColor: '#39f', // 채우기 색
		fillOpacity: 0.5 // 채우기색 투명도
	},
	circleOptions: {
		draggable: true,
		removable: true,
		editable: true,
		strokeColor: '#39f',
		fillColor: '#39f',
		fillOpacity: 0.5
	},
	polygonOptions: {
		draggable: true,
		removable: true,
		editable: true,
		strokeColor: '#39f',
		fillColor: '#39f',
		fillOpacity: 0.5,
		hintStrokeStyle: 'dash',
		hintStrokeOpacity: 0.5
	}
};

let manager = new kakao.maps.drawing.DrawingManager(options);

let marker1 = new kakao.maps.Marker({
	position: new kakao.maps.LatLng(37.49639808767572, 130.89214157859138)

});

let marker2 = new kakao.maps.Marker({
	position: new kakao.maps.LatLng(37.52523213922627, 130.87104066253468)

});

let marker3 = new kakao.maps.Marker({
	position: new kakao.maps.LatLng(37.52967462198738, 130.8359481448985)

});

let marker4 = new kakao.maps.Marker({
	position: new kakao.maps.LatLng(37.48441275848577, 130.90576780387886)

});

let marker5 = new kakao.maps.Marker({
	position: new kakao.maps.LatLng(37.4772213535266, 130.80955621879266)

});

let marker6 = new kakao.maps.Marker({
	position: new kakao.maps.LatLng(37.483107448364784, 130.85290778853124)

});

let markers = [marker1, marker2, marker3, marker4, marker5, marker6];


let clusterer = new kakao.maps.MarkerClusterer({
	map: map,
	markers: markers,
	gridSize: 35,
	averageCenter: true,
	minLevel: 6,
	disableClickZoom: true,
	styles: [{
		width: '53px', height: '52px',
		background: 'url(cluster.png) no-repeat',
		color: '#fff',
		textAlign: 'center',
		lineHeight: '54px'
	}]
});

clusterer.addMarker(marker1);
clusterer.addMarker(marker2);
clusterer.addMarker(marker3);
clusterer.addMarker(marker4);
clusterer.addMarker(marker5);
clusterer.addMarker(marker6);

let message = null;
kakao.maps.event.addListener(marker1, 'click', function() {

	message = '봉래폭포휴게소';

	let resultDiv = document.getElementById('result');
	resultDiv.innerHTML = message;

	location.href = `shortTerm?search=01&message=${message}`;

});

kakao.maps.event.addListener(marker2, 'click', function() {

	message = '나리전망대';

	let resultDiv = document.getElementById('result');
	resultDiv.innerHTML = message;

	location.href = `shortTerm?search=02&message=${message}`;

});

kakao.maps.event.addListener(marker3, 'click', function() {

	message = '울릉예림원';

	let resultDiv = document.getElementById('result');
	resultDiv.innerHTML = message;

	location.href = `shortTerm?search=03&message=${message}`;
});


kakao.maps.event.addListener(marker4, 'click', function() {

	message = '울릉군청';

	let resultDiv = document.getElementById('result');
	resultDiv.innerHTML = message;

	location.href = `shortTerm?search=04&message=${message}`;

});

kakao.maps.event.addListener(marker5, 'click', function() {

	message = '울릉도 국민여가캠핑장';

	let resultDiv = document.getElementById('result');
	resultDiv.innerHTML = message;

	location.href = `shortTerm?search=05&message=${message}`;

});


kakao.maps.event.addListener(marker6, 'click', function() {

	message = '경북 울릉군 서면 남양리 산 152-1';

	let resultDiv = document.getElementById('result');
	resultDiv.innerHTML = message;

	location.href = `shortTerm?search=06&message=${message}`;

});


function getCarValue(event) {
	let carName = event.target.value;
	document.getElementById('checkedCar').innerText = carName;
}




