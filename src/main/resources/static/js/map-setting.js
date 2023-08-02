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

let city1 = [];
let city2 = [];
let dong = [];

 var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 10 // 클러스터 할 최소 지도 레벨 
 });

const citySet = new Set();

$.get("/static/js/location-test.json", function(data) {
// Iterate through the data and create custom overlays for each location

	for (const location in data) {
		const cityName = location.split('/')[0];
	    citySet.add(cityName);
		const lat = data[location].lat;
	    const lng = data[location].long;
	    const coords = new kakao.maps.LatLng(lat, lng);
	    
	    // Extract the text after the forward slash ("/")
	    const gungu = location.split('/')[1];
	    
	    // Create a custom overlay for each address
	    let customOverlay = new kakao.maps.CustomOverlay({
			map: map,
			clickable: true,
			content: '<div class="marker-content"><h1>1</h1><p>' + gungu + '</p></div>',
			position: coords,
			xAnchor: 0.5,
			yAnchor: 1,
			zIndex: 10, // Set a higher z-index value to ensure it's displayed above cluster markers
	    });
	
	    // Add the custom overlay to the map
	    //customOverlay.setMap(map);
	    
	    city2.push(customOverlay);
	    customOverlay.setMap(null);    
    }
	const cities = Array.from(citySet);
	
	getAddress(cities);
	console.log(cities);
});

// Convert the Set to an array to get unique city names


// Function to hide all custom overlays in the 'city' array
function hideCityOverlays1() {
  city1.forEach(function(overlay) {
    overlay.setMap(null);
  });
}

// Function to show all custom overlays in the 'city' array
function showCityOverlays1() {
  city1.forEach(function(overlay) {
    overlay.setMap(map);
  });
}
// Function to hide all custom overlays in the 'city' array
function hideCityOverlays2() {
  city2.forEach(function(overlay) {
    overlay.setMap(null);
  });
}

// Function to show all custom overlays in the 'city' array
function showCityOverlays2() {
  city2.forEach(function(overlay) {
    overlay.setMap(map);
  });
}

function toggleCityOverlays() {
    const currentLevel = getMapLevel();
    if (currentLevel > 7 && currentLevel < 10) {
        showCityOverlays2();
    } else {
        hideCityOverlays2();
    }
    if(currentLevel >= 10) {
		showCityOverlays1();
	}else {
		hideCityOverlays1();
	}
}

// Add event listener for map zoom change
kakao.maps.event.addListener(map, 'zoom_changed', toggleCityOverlays);

// Call the function to show/hide city overlays initially
toggleCityOverlays();

let geocoder = new kakao.maps.services.Geocoder();

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
/*
function getAddress(data) {
  for (let city in data) {
    const address = city;
    // Use the geocoder to get coordinates for each address
    geocoder.addressSearch(address, function(result, status) {
      if (status === kakao.maps.services.Status.OK) {
        let coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // Create a custom overlay for each address
        let customOverlay = new kakao.maps.CustomOverlay({
          map: map,
          clickable: true,
          content: '<div class="marker-content"><h1>1</h1><p>' + address + '</p></div>',
          position: coords,
          xAnchor: 0.5,
          yAnchor: 1,
          zIndex: 10, // Set a higher z-index value to ensure it's displayed above cluster markers
        });

        // Set the map center to the first address's coordinates
        map.setCenter(coords);
      }
    });

    for (let dong of data[city]) {
      const address1 = dong;

      geocoder.addressSearch(address1, function(result, status) {
        if (status === kakao.maps.services.Status.OK) {
          let coords = new kakao.maps.LatLng(result[0].y, result[0].x);

          // Create a custom overlay for each address
          let customOverlay = new kakao.maps.CustomOverlay({
            map: map,
            clickable: true,
            content: '<div class="marker-content"><h1>1</h1><p>' + address1 + '</p></div>',
            position: coords,
            xAnchor: 0.5,
            yAnchor: 1,
            zIndex: 10, // Set a higher z-index value to ensure it's displayed above cluster markers
          });

          // Set the map center to the first address's coordinates
          map.setCenter(coords);
        }
      });
    }
  }
}
*/


function getAddress(data) {
    for (let i = 0; i < data.length; i++) {
        const address = data[i];
        // Use the geocoder to get coordinates for each address
        geocoder.addressSearch(address, function (result, status) {
            if (status === kakao.maps.services.Status.OK) {
                let coords = new kakao.maps.LatLng(result[0].y, result[0].x);

                // Create a custom overlay for each address
                let customOverlay = new kakao.maps.CustomOverlay({
                    map: map,
                    clickable: true,
                    content: '<div class="marker-content"><h1>1</h1><p>' + address + '</p></div>',
                    position: coords,
                    xAnchor: 0.5,
                    yAnchor: 1,
                    zIndex: 10, // Set a higher z-index value to ensure it's displayed above cluster markers
                });
                
                city1.push(customOverlay);
            }
        });
    }
}

function getMapLevel() {	
	let level = map.getLevel();
	console.log(level);
	return level;
}

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
