function getPrincipal(){
	let user = null;
	$.ajax({
		async: false,
		type: "get",
		url: "/api/v1/auth/principal",
		dataType: "json",
		success: (response) => {
			user = response.data;
		},
		error: (error) => {
			console.log(error);
		}
	});
	return user;
}


function loadHeader(user) {
    const authItems = document.querySelector(".auth-items");
	const contract = document.querySelector(".contract");
	authItems.innerHTML = "";
	contract.textContent = "";
    if (user == null) {
        authItems.innerHTML = `
            <button type="button" class="login-page-button menu-item" onclick="location.href='/welcome';">
                <span class="button-text">로그인<span></span>회원가입</span>
            </button>
            <button class="last-button menu-item">
                <span class="button-text">중개사 가입/광고문의</span>
            </button>
        `;

		contract.textContent = "다방싸인 비대면 계약";
    } else {
        authItems.innerHTML = `
			<div size="32" class="Profile">
				<img src="/static/images/profile.svg" draggable="false">
				<div class="user-option">
					<p>${user.nname} 님</p>
					<div class="user-option-box">
						<nav>
							<a href="" class="user-service-nav">문자문의</a>
							<a href="" class="user-service-nav">전화문의</a>
							<a href="/inquery" class="user-service-nav">1:1 문의내역</a>
							<a href="" class="user-service-nav">허위매물 신고내역</a>
							<a href="/account" class="user-service-nav">내 정보</a>
							<button class="logout-button user-service-nav">
								로그아웃
								<svg width="17" height="15" viewBox="0 0 17 15" fill="none" xmlns="http://www.w3.org/2000/svg">
									<path fill-rule="evenodd" clip-rule="evenodd" d="M 9.00067 9.39777 V 14 H 0.997552 V 1 H 9.00067 V 5.3515 H 10 V 0 H 0 V 15 H 10 V 9.39777 H 9.00067 Z M 12 4.70711 L 12.7071 4 L 16.1074 7.40031 L 12.716 10.7917 L 12.0089 10.0846 L 14.0935 8 H 5 V 7 H 14.2929 L 12 4.70711 Z" fill="#656565"></path>
								</svg>
							</button>
						</nav>
					</div>
				</div>
			</div>
        `;

		contract.textContent = "My 비대면 계약";
        // const username = document.querySelector(".username");
        // username.onclick = () => {
		// 	location.replace("");
		// }
    }
}



let user = getPrincipal();
console.log(user);
loadHeader(user);

function getUser(){
	console.log(user);
	return user;
}