
  function load(usercode) {
    $.ajax({
      type: "get",
/*      url: "/api/v1/account/get/${user.user_code}", // AJAX 요청을 보낼 서버의 엔드포인트 URL*/
      url: `/api/v1/account/get/${usercode}`, // AJAX 요청을 보낼 서버의 엔드포인트 URL
      dataType: "json", // 받아올 데이터의 타입 (JSON 데이터 예상),
      success: (response) => {
        loadContent(response.data);
        console.log(response.data);
        console.log(user);
      },
      error: function (xhr, status, error) {
        console.log(error);
      }
    });
  }
console.log(getUser().user_code);
load(getUser().user_code);

function getData() {
	const nickNameAnswer = document.querySelector(".nickNameAnswer");
	if(getUser() != null) {
		console.log("nname불러오기");
		nickNameAnswer.innerHTML = `<p>${getUser().nname}</p>`;
	}
}

