const optionButtons = document.querySelectorAll(".option-button");

for(let i = 0; i < optionButtons.length; i++) {

    optionButtons[i].onclick = () => {
        optionButtons[i].classList.toggle("black-button");
        optionButtons[i].classList.toggle("blue-button");
    }
}