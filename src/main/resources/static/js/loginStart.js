const GoJoin = document.querySelector(".LoginJoin button");
const EmailLogin = document.querySelector(".Email-Login");


GoJoin.onclick = () => {
    location.href = "/welcome/agree/join";
}

EmailLogin.onclick = () => {
    location.href = "/welcome/login";
}

/*function kakaoLogin(){
	$.ajax({
		url: '/api/v1/auth/login/kakao/callback',
		type: 'get',
		async: false,
		dataType: 'text',
		success: function (res) {
			location.href = (res);
		}
	})
}*/

/* $(document).ready(function() {

      var kakaoInfo = '${kakaoInfo}';

      if(kakaoInfo != ""){
          var data = JSON.parse(kakaoInfo);

          alert("카카오로그인 성공 \n accessToken : " + data['accessToken']);
          alert(
          "user : \n" + "email : "
          + data['email']  
          + "\n nickname : " 
          + data['nickname']);
      }
  });  */