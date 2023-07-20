const inputs = document.querySelectorAll("input");
const longinBtn = document.querySelector(".SolidButton");
const email = document.querySelector(".input-Email");
const password = document.querySelector(".Password-Input");
/*const checkpassword = document.querySelector("Password-Input");*/

let checkUseremailFlag = false;
let checkUserpasswordFlag = false;

function check_password(){
	const input = document.getElementById("password");
	
	const password_format = /^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[-~!@#$%^&*_+=])[a-zA-Z\\d-~!@#$%^&*_+=]{8,20}$/;
	if(password_format.test(input)){
		console.log("비밀번호 형식 ok")
	}else{
		console.log("비밀번호 형식 no")
	}
}


function check_email() {
	const input = document.getElementById("email")
	
	const email_format = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	if(email_format.test(input)) {
		console.log("이메일 형식 ok")		
	}else{
		console.log("잘못된 형식")
		
	}
}


inputs[0].onblur = () => {
	check_email()
    //아이디 중복확인
    console.log(inputs[0].value)
    $.ajax({
        async: false,
        type: "get",
        url: "/api/v1/auth/join/email/validation",
        data: {email: inputs[0].value},
        dataType: "json",
        success: (response) => {
            checkUseremailFlag = response.data;
            if(checkUseremailFlag){
                alert("사용 가능한 이메일입니다.")
            }else{
                alert("이미 사용중인 이메일입니다.")
            }
        },
        error: (error) => {
            if(error.status == 400){
                alert(JSON.stringify(error.responseJSON.data));
            }else{
                console.log("요청실패")
                console.log(error)
            }
        }
    })
  }
  
inputs[1].onblur = () => {
	check_password();
	
	 console.log(inputs[1].value)
	  $.ajax({
        async: false,
        type: "get",
        url: "/api/v1/auth/join/password/validation",
        data: {password: inputs[1].value},
        dataType: "json",
        success: (response) => {
            checkUserpasswordFlag = response.data;
            if(checkUserpasswordFlag){
                console.log("비밀번호 검사 ok.")
            }else{
                console.log("비밀번호 검사 no")
            }
        },
        error: (error) => {
            if(error.status == 400){
                alert(JSON.stringify(error.responseJSON.data));
            }else{
                console.log("요청실패")
                console.log(error)
            }
        }
    })
}

function validatePassword() {
	
}

    
longinBtn.onclick = () => {
	let joinData = {
		email: inputs[0].value,
		password: inputs[1].value,
		checkpassword: inputs[2].value,
		"checkUseremailFlag": checkUseremailFlag
	}
	
	$.ajax({
		async: false,
		type: "post",
		url: "/api/v1/auth/welcome/join",
		contentType: "application/json",
		data: JSON.stringify(joinData),
		dataType: "json",
		success: (response) => {
			if(response.data){
				alert("회원가입완료")
				location.replace("/index")
			}
		},
		error: (error) => {
			if(error.status == 400){
				alert(JSON.stringify(error.responseJSON.data));
			}else{
				console.log(joinData[0].value);
				console.log("요청실패")
            	console.log(error)
			}
		}
	})
}


