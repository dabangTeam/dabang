let container = document.getElementById('map');

let options = {
    center: new kakao.maps.LatLng(35.157323, 129.059377), 
    level: 3,
    maxLevel: 11,
    minLevel: 1
};

let map = new kakao.maps.Map(container, options);
        
// 지도 확대, 축소 컨트롤에서 확대 버튼을 누르면 호출되어 지도를 확대하는 함수입니다
function zoomIn() {
    map.setLevel(map.getLevel() - 1);
}
        
// 지도 확대, 축소 컨트롤에서 축소 버튼을 누르면 호출되어 지도를 확대하는 함수입니다
function zoomOut() {
    map.setLevel(map.getLevel() + 1);
}

let markers = [];

let clusterer = new kakao.maps.MarkerClusterer({
    map: map,
    averageCenter: true,
    minLevel: 10,
    styles: [{
        minWidth: '30px',
        height: '30px',
        padding: '0px 6px',
        color: 'rgb(255, 255, 255)',
        fontSize: '12px',
        lineHeight: '26px',
        textAlign: 'center',
        border: '2px solid rgb(50, 108, 249)',
        borderRadius: '30px',
        backgroundColor: 'rgb(50, 108, 249)',
        whiteSpace: 'nowrap',
        position: 'relative',
        zIndex: '2'
    }]
});

kakao.maps.event.addListener( clusterer, 'clustered', function( clusters ) {
    clusters.forEach((cluster) => {
        console.log(cluster.getClusterMarker().getContent()); // 클러스터 오버레이 출력
    })
});

$.get("/static/js/location-data.js", function(data) {
    // 데이터에서 좌표 값을 가지고 마커를 표시합니다
    // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
    let markers = $(data.positions).map(function(i, position) {
        return new kakao.maps.Marker({
            position : new kakao.maps.LatLng(position.lat, position.lng)
        });
    });

    // 클러스터러에 마커들을 추가합니다
    clusterer.addMarkers(markers);
});

        // let customOverlay = new kakao.maps.CustomOverlay({
        //     map: map,
        //     clickable: true,
        //     content: '<div class="marker-content"><h1>1</h1><p>부전동</p></div>',
        //     position: new kakao.maps.LatLng(33.450701, 126.570667),
        //     xAnchor: 0.5,
        //     yAnchor: 1,
        //     zIndex: 3
        // });


let geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
let address = '부전동';

function load() {
	$.ajax({
	    async: false,
	    type: "get",
	    url: "/api/v1/map/address",
	    dataType: "json",
	    success: (response) => {
	        console.log(response.data);
	        getAddress(response.data);
	    },
	    error: (error) => {
	        console.log(error);
	    }
	});
}

function loadCity() {
	setMarkers(map);
    
    markers = []; // 배열을 비워줍니다.
    
	$.ajax({
	    async: false,
	    type: "get",
	    url: "/api/v1/map/address/city",
	    dataType: "json",
	    success: (response) => {
	        console.log(response.data);
	        getAddress(response.data);
	    },
	    error: (error) => {
	        console.log(error);
	    }
	});
}

let value = 0;

function getAddress(data) {
    // 기존의 마커들을 모두 제거합니다.
    for (const marker of markers) {
        marker.setMap(null);
    }
    markers = [];

    for (let address of data) {
        // Use the geocoder to get coordinates for each address
        geocoder.addressSearch(address, function(result, status) {
            if (status === kakao.maps.services.Status.OK) {
                let coords = new kakao.maps.LatLng(result[0].y, result[0].x);

                // Create a marker for each address
                let marker = new kakao.maps.Marker({ position: coords });

                // 마커를 배열에 추가합니다.
                markers.push(marker);
            }
        });
    }

    // 클러스터러를 초기화하고 마커들을 추가합니다.
    clusterer = new kakao.maps.MarkerClusterer({
        map: map,
        averageCenter: true,
        minLevel: 10,
    });
    clusterer.addMarkers(markers);
}

// 지도가 확대 또는 축소되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'zoom_changed', function() {
    const currentLevel = getMapLevel();
    if (currentLevel === 11 || currentLevel === 10) {
        loadCity();
    } else if (currentLevel === 9 || currentLevel === 8) {
        // 레벨이 9 또는 8일 때 클러스터러를 숨깁니다.
        if (clusterer) {
            clusterer.clear();
        }
    } else {
        // 레벨이 11이 아닐 때, 기존의 마커들을 배열에서 제거합니다.
        for (const marker of markers) {
            marker.setMap(null);
        }
        markers = []; // 배열을 비워줍니다.
    }
});

function getMapLevel() {	
	let level = map.getLevel();
	console.log(level);
	return level;
}

// 지도가 확대 또는 축소되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'zoom_changed', function() {
    const currentLevel = getMapLevel();
    if (currentLevel === 11 || currentLevel === 10) {
		setMarkers(map);
        loadCity();
    } else if(currentLevel === 9 || currentLevel === 8) {
		setMarkers(map); 
		markers = [];
	} else {
        setMarkers(map);
        markers = []; // 배열을 비워줍니다.
    }
});

// Trigger the AJAX call to get the addresses and display markers on the map
load();

if(getMapLevel().level === 11) {
	loadCity();
}

function setMarkers(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }            
}

function addMarker(position) {
    
    // 마커를 생성합니다
    let marker = new kakao.maps.Marker({
        position: position
    });

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);
    
    // 생성된 마커를 배열에 추가합니다
    markers.push(marker);
}
