const loginBtn = document.querySelector(".SolidBtn");
const email = document.querySelector(".Email-input");
const emailtext = document.getElementById("Email-input");
const emailNoError = document.querySelector(".emailerror");
const password = document.querySelector(".password-input");
const buttons = document.querySelectorAll(".Btn-wrap button");

const emailLoginBtn = buttons[1];
const changepassword = buttons[0];

const Error = document.querySelector(".error-logo")

function passwordempty(){
	if (password.value.trim() === '') {
		emailNoError.innerHTML = "비밀번호를 입력해주세요.";
	    emailNoError.style.display = 'block';
		Error.style.display = 'block';
    setTimeout(() => {
      emailNoError.style.display = 'none';
      Error.style.display = 'none';
    }, 4000);
  } else {
    emailNoError.style.display = 'none';
    Error.style.display = 'none';
  }
}



function emailError() {
  if (email.value.trim() === '') {
    emailNoError.style.display = 'block';
	Error.style.display = 'block';
    setTimeout(() => {
      emailNoError.style.display = 'none';
      Error.style.display = 'none';
    }, 4000);
  } else {
    emailNoError.style.display = 'none';
    Error.style.display = 'none';
  }
}

function emailError2() {
  const emailFormat = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
  if (!emailFormat.test(email.value.trim())) {
    emailNoError.innerHTML = "이메일 형식을 확인해 주세요.";
    emailNoError.style.display = 'block';
    Error.style.display = 'block';
    setTimeout(() => {
      emailNoError.style.display = 'none';
      Error.style.display = 'none';
    }, 4000);
  } else {
    emailNoError.style.display = 'none';
    Error.style.display = 'none';
  }
}

function noFindUser(){
	if (password.value.trim() === '') {
		emailNoError.innerHTML = "이메일주소 또는 비밀번호가 틀렸습니다.";
	    emailNoError.style.display = 'block';
		Error.style.display = 'block';
    setTimeout(() => {
      emailNoError.style.display = 'none';
      Error.style.display = 'none';
    }, 4000);
  } else {
    emailNoError.style.display = 'none';
    Error.style.display = 'none';
  }
}

loginBtn.onclick = () => {
	event.preventDefault();
	
	emailError();
	emailError2();
	passwordempty();
	
    const loginData = {
        email: email.value,
        password: password.value
    };

    $.ajax({
        type: "POST",
        url: "/api/v1/auth/login",
        contentType: "application/json",
        data: JSON.stringify(loginData),
        dataType: "json",
        success: (response) => {
            if (response.data) {
                /*alert("로그인 완료");*/
                location.replace("/welcome");
            }
        },
        error: (error) => {
            if (error.status == 400) {
				alert("로그인 실패");
                emailNoError.innerHTML = "이메일주소 또는 비밀번호가 틀렸습니다.";
			    emailNoError.style.display = 'block';
				Error.style.display = 'block';
			    setTimeout(() => {
			      emailNoError.style.display = 'none';
			      Error.style.display = 'none';
			    }, 4000);
               
               
            } else {
                console.log("요청 실패");
                console.log(error);
            }
        }
    });
};

emailLoginBtn.onclick = () => {
	location.href = "/welcome/agree/join";
}
