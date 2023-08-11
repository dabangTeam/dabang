const joinBtn = document.querySelector(".JoinBtn");
const loginBtn = document.querySelector(".login-page-button")

loginBtn.onclick = () => {
    console.log("login");
    location.href = "/welcome/login";

}

joinBtn.onclick = () => {
    console.log("Join");
    location.href = "/welcome/join";

}

// function getCheck(){
//     const selectedElement = document.querySelectorAll("input[type=checkbox]:checked");
//     const cnt = selectedElement.length;

//     if(cnt >= 3){
//         document.querySelector(".JoinBtn").disabled=false;
//     }else{
//         document.querySelector(".JoinBtn").disabled=true;
//     }
// }




// function selectAll(selectAll){
//     const checkboxs = document.querySelectorAll(".Check-ListBox");

//     checkboxs.forEach((checkbox) => {
        
//             checkbox.checked = selectAll.checked;
//             document.querySelector(".JoinBtn").disabled=false;
        
//     })
// }

const form = document.querySelector("#JoinAgree-form");
const checkAll = document.querySelector(".Check-Container input");
const checkBoxs = document.querySelectorAll(".Check-boxs input");
const submitButton = document.querySelector(".JoinBtn");

//버튼 정보함
const agreements = {
    agecheck:false,         //첫번째 필수동의 체크박스
    AcceptanceCheck: false,  //두번째 필수동의 체크박스
    personalInfo: false,    //세번째 필수동의 체크박스
    marketintInfo:false     //네번째 필수동의 체크박스
}

form.addEventListener('submit', (e) => e.preventDefault())

checkBoxs.forEach((item) => item.addEventListener('input', toggleCheckbox));


function toggleCheckbox(e) {
    const { checked, id} = e.target;
    agreements[id] = checked;
    this.parentNode.classList.toggle('active');
    checkAllStatus();
    toggleSubmitButton();
}

/*
총 4개의 체크박스를 한번에 클릭하게 하는 함수
*/
function checkAllStatus() {
    const {agecheck, AcceptanceCheck,personalInfo ,marketintInfo} = agreements;
    if(agecheck & AcceptanceCheck &personalInfo & marketintInfo) {
        checkAll.checked = true;
    }else{
        checkAll.checked =false;
    }
}

function toggleSubmitButton() {
    const { agecheck, AcceptanceCheck, personalInfo } = agreements;
    if(agecheck && AcceptanceCheck && personalInfo) {
        submitButton.disabled = false;
    }else {
        submitButton.disabled =true;
    }
}

//checkAll 버튼을 누르면 

checkAll.addEventListener('click', (e) => {
    const {checked} = e.target;
    if(checked){
        checkBoxs.forEach((item) => {
            item.checked = true;
            agreements[item.id] =true;
            item.parentNode.classList.add('active');
        });
    }else {
        checkBoxs.forEach((item) => {
            item.checked = false;
            agreements[item.id] =false;
            item.parentNode.classList.remove('active');
        });
    }
    toggleSubmitButton();
})