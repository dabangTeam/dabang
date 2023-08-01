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
    let value = 0;

    function getAddress(data) {
        for (let address of data) {
            
            // Use the geocoder to get coordinates for each address
            geocoder.addressSearch(address, function(result, status) {
                if (status === kakao.maps.services.Status.OK) {
                    let coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                    console.log(address);

                    // Create a custom overlay for each address
                    let customOverlay = new kakao.maps.CustomOverlay({
                        map: map,
                        clickable: true,
                        content: '<div class="marker-content"><h1>1</h1><p>' + address + '</p></div>',
                        position: coords,
                        xAnchor: 0.5,
                        yAnchor: 1,
                        zIndex: 3
                    });

                    // Set the map center to the first address's coordinates
                    map.setCenter(coords);
                }
            });
        }
    }

    // Trigger the AJAX call to get the addresses and display markers on the map
    load();