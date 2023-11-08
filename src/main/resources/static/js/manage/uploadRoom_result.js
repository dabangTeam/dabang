$(document).ready(function() {
    var roomCode = window.location.pathname.split('/').pop();
    $.ajax({
        type: "get",
        url: `/api/v1/manage/list/${roomCode}`,
        dataType: "json",
        success: (response) => {
            console.log("response :", response);
			console.log(response.data);
            getList(response.data);
        },
        error: (error) => {
            console.log(error);
        }
    });

});

function getList(roomInfo) {
	console.log("getList 실행");
	const tbody = document.querySelector(".myroom-text-ul");
	console.log(tbody);
	tbody.innerHTML = "";
	//list.forEach(roomInfo => {
	tbody.innerHTML += `
				<li>
					<div class="myroom-text-titleDiv">
						<div>
							<p class="myroom-pTag-create">등록일 
								<span>${roomInfo.createDate}</span>
							</p>
							<p class="myroom-pTag-number">매물번호 
								<span>${roomInfo.roomCode}</span>
							</p>
							<div class="myroom-pTag-enddate" style="margin-left: 16px;">
								<p>광고종료 D-29</p>
							</div>
						</div>
						<div class="myroon-buttonDiv">
							<button class="myroom-Btn">
								<span>비공개로 전환</span>
							</button>
							<button class="myroom-Btn updateBtn">
								<span>수정</span>
							</button>
							<button class="myroom-Btn deleteBtn">
								<span>삭제</span>
							</button>
						</div>
					</div>
					<a href="/room/64b52fe31338fe73adb76d45" target="_blank" 
					rel="noopener noreferrer" class="myroom-roomInfo">
						<div>
							<div class="roomInfo-photoDiv">
								<div class="roomInfo-countDiv">
									<p>찜
										<span>0</span>
									</p>
									<p>조회
										<span>0</span>
									</p>
								</div>
							</div>
						</div>
						<div>
							<div class="roomInfo-state">
								<p>광고중</p>
							</div>
							<h3 class="roomInfo-title">${roomInfo.trnscType}</h3>
							<p class="roomInfo-memo">${roomInfo.salesType} ${roomInfo.roomInfoCount} | ${roomInfo.salesAddressMainRoad} ${roomInfo.salesAddressDong} ${roomInfo.salesAddressHo}</p>
							<p class="roomInfo-subMemo">${roomInfo.descTitle}</p>
						</div>
					</a>
				</li>
	`;
	const deleteButton = document.querySelector(".deleteBtn");
	deleteButton.onclick = function() {
		console.log("삭제버튼 클릭");
		deleteRoomInfoList();	
	}
	const updateButton = document.querySelector(".updateBtn");
	updateButton.onclick = function() {
		console.log("수정버튼 클릭");
		updateRoomInfoPage();
	}
	//});
}

function updateRoomInfoPage() {
	var roomCode = window.location.pathname.split('/').pop();
	location.href= `/manage/${roomCode}`;
}

function deleteRoomInfoList(){
	var roomCode = window.location.pathname.split('/').pop();
	$.ajax({
		type: 'delete',
		url: `/api/v1/manage/content/delete/${roomCode}`,
		dataType: 'json',
		success: (response) => {
			console.log(response.data);

			alert("삭제되었습니다.");
			location.href= `/manage`;
		},
		error: (error) => {
			console.log(error);
		}
	})
}