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