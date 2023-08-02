let positions = {
  "서울특별시": [
      '',
      '강남구',
      '강동구',
      '강북구',
      '강서구',
      '관악구',
      '광진구',
      '구로구',
      '금천구',
      '노원구',
      '도봉구',
      '동대문구',
      '동작구',
      '마포구',
      '서대문구',
      '서초구',
      '성동구',
      '성북구',
      '송파구',
      '양천구',
      '영등포구',
      '용산구',
      '은평구',
      '종로구',
      '중구',
      '중랑구',
  ],
  "부산광역시": [
      '',
      '강서구',
      '금정구',
      '기장군',
      '남구',
      '동구',
      '동래구',
      '부산진구',
      '북구',
      '사상구',
      '사하구',
      '서구',
      '수영구',
      '연제구',
      '영도구',
      '중구',
      '해운대구',
  ],
  "인천광역시": [
      '',
      '강화군',
      '계양구',
      '남구',
      '남동구',
      '동구',
      '부평구',
      '서구',
      '연수구',
      '옹진군',
      '중구',
  ],
  "대구광역시": [
      '',
      '중구',
      '동구',
      '서구',
      '남구',
      '북구',
      '수성구',
      '달서구',
      '달성군',
  ],
  "광주광역시": ['', '동구', '서구', '남구', '북구', '광산구'],
  "대전광역시": ['', '동구', '중구', '서구', '유성구', '대덕구'],
  "울산광역시": ['', '중구', '남구', '동구', '북구', '울주군'],
  "세종특별자치시": [''],
  "경기도": [
      '',
      '가평군',
      '고양시',
      '과천시',
      '광명시',
      '광주시',
      '구리시',
      '군포시',
      '김포시',
      '남양주시',
      '동두천시',
      '부천시',
      '성남시',
      '수원시',
      '시흥시',
      '안산시',
      '안성시',
      '안양시',
      '양주시',
      '양평군',
      '여주시',
      '연천군',
      '오산시',
      '용인시',
      '의왕시',
      '의정부시',
      '이천시',
      '파주시',
      '평택시',
      '포천시',
      '하남시',
      '화성시',
  ],
  "강원도": [
      '',
      '원주시',
      '춘천시',
      '강릉시',
      '동해시',
      '속초시',
      '삼척시',
      '홍천군',
      '태백시',
      '철원군',
      '횡성군',
      '평창군',
      '영월군',
      '정선군',
      '인제군',
      '고성군',
      '양양군',
      '화천군',
      '양구군',
  ],
  "충청북도": [
      '',
      '청주시',
      '충주시',
      '제천시',
      '보은군',
      '옥천군',
      '영동군',
      '증평군',
      '진천군',
      '괴산군',
      '음성군',
      '단양군',
  ],
  "충청남도": [
      '',
      '천안시',
      '공주시',
      '보령시',
      '아산시',
      '서산시',
      '논산시',
      '계룡시',
      '당진시',
      '금산군',
      '부여군',
      '서천군',
      '청양군',
      '홍성군',
      '예산군',
      '태안군',
  ],
  "경상북도": [
      '',
      '포항시',
      '경주시',
      '김천시',
      '안동시',
      '구미시',
      '영주시',
      '영천시',
      '상주시',
      '문경시',
      '경산시',
      '군위군',
      '의성군',
      '청송군',
      '영양군',
      '영덕군',
      '청도군',
      '고령군',
      '성주군',
      '칠곡군',
      '예천군',
      '봉화군',
      '울진군',
      '울릉군',
  ],
  "경상남도": [
      '',
      '창원시',
      '김해시',
      '진주시',
      '양산시',
      '거제시',
      '통영시',
      '사천시',
      '밀양시',
      '함안군',
      '거창군',
      '창녕군',
      '고성군',
      '하동군',
      '합천군',
      '남해군',
      '함양군',
      '산청군',
      '의령군',
  ],
  "전라북도": [
      '',
      '전주시',
      '익산시',
      '군산시',
      '정읍시',
      '완주군',
      '김제시',
      '남원시',
      '고창군',
      '부안군',
      '임실군',
      '순창군',
      '진안군',
      '장수군',
      '무주군',
  ],
  "전라남도": [
      '',
      '여수시',
      '순천시',
      '목포시',
      '광양시',
      '나주시',
      '무안군',
      '해남군',
      '고흥군',
      '화순군',
      '영암군',
      '영광군',
      '완도군',
      '담양군',
      '장성군',
      '보성군',
      '신안군',
      '장흥군',
      '강진군',
      '함평군',
      '진도군',
      '곡성군',
      '구례군',
  ],
  "제주특별자치도": ['', '제주시', '서귀포시']
}
/*

function getAddressList() {
    for (let city in addressMap) {
        console.log(city);
        const towns = addressMap[city];
        for (let i = 0; i < towns.length; i++) {
            console.log(towns[i]);
        }
    }
}

let customMarkers = [];
let city = [];
let dong = [];

let geocoder = new kakao.maps.services.Geocoder();
function getAddress(data) {
  for (city in data) {
    const address = city;
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
          zIndex: 3,
        });

        // Set the map center to the first address's coordinates
        map.setCenter(coords);
      }
    });

    for (dong of data[city]) {
      const address1 = dong;

      geocoder.addressSearch(address1, function(result, status) {
        if (status === kakao.maps.services.Status.OK) {
          let coords = new kakao.maps.LatLng(result[0].y, result[0].x);
          console.log(address1);

          // Create a custom overlay for each address
          let customOverlay = new kakao.maps.CustomOverlay({
            map: map,
            clickable: true,
            content:
              '<div class="marker-content"><h1>1</h1><p>' + address1 + '</p></div>',
            position: coords,
            xAnchor: 0.5,
            yAnchor: 1,
            zIndex: 3,
          });

          // Set the map center to the first address's coordinates
          map.setCenter(coords);
        }
      });
    }
  }
}

// 호출
getAddress(positions);

function getLocation() {
    return addressMap;
}*/

/*
$.get("/download/web/data/chicken.json", function(data) {
    // 데이터에서 좌표 값을 가지고 마커를 표시합니다
    // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
    var markers = $(data.positions).map(function(i, position) {
        console.log("test");
        return new kakao.maps.Marker({
            position : new kakao.maps.LatLng(position.lat, position.lng)
        });
    });

    // 클러스터러에 마커들을 추가합니다
    clusterer.over(markers);
});
*/