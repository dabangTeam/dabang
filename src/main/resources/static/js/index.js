
function getPrincipal(){
	let user = null;
	$.ajax({
		async:false,
		type: "get",
		url: "/api/v1/auth/principal",
		dataType: "json",
		success: (response) => {
			user = response.data;
			console.log(user);
		},
		error: (error) => {
			console.log(error);
		}
	});
	return user;
}

function loadHeader(user) {
    const authItems = document.querySelector(".auth-items");

    if (user == null) {
        authItems.innerHTML = `
            <button type="button" class="login-page-button menu-item" onclick="location.href='/welcome';">
                <span class="button-text">로그인<span></span>회원가입</span>
            </button>
            <button class="last-button menu-item">
                <span class="button-text">중개사 가입/광고문의</span>
            </button>
        `;
    } else {
        authItems.innerHTML = `
            <button type="button" class="auth-button username">${user.nName}</button>
        `;
    }
}

let user = getPrincipal();
console.log(user);
loadHeader(user);

function getUser(){
	console.log(user);
	return user;
	}
	
	