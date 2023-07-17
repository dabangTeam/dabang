const optionBoxes = document.querySelectorAll(".option-box");
const buttons = document.querySelectorAll(".search-type button");
const optionDetailLabel = document.querySelectorAll(".option-detail-label");

buttons[0].onclick = () => {
    if(buttons[1].classList.contains("button-color")) {
        buttons[1].classList.remove("button-color");
        buttons[0].classList.add("button-color");

    }
}

buttons[1].onclick = () => {
    if(buttons[0].classList.contains("button-color")) {
        buttons[0].classList.remove("button-color");
        buttons[1].classList.add("button-color");
    }
}

optionBoxes.forEach((optionBox) => {
    const optionButton = optionBox.querySelector(".option-button");
    const textColor = optionButton.querySelector("p");
    const optionContainer = optionBox.querySelector(".option-detail-container");
  
    optionButton.onclick = () => {
      optionButton.classList.toggle("black-button");
      optionButton.classList.toggle("blue-button");
      textColor.classList.toggle("black-font");
      textColor.classList.toggle("blue-font");
      optionContainer.classList.toggle("hidden");

optionDetailLabels.forEach((optionLabel) => {
    const optionInput = optionLabel.querySelector(".option-detail-input");
    const checkText = optionLabel.parentNode.querySelector(".option-button p");
    optionLabel.onclick = () => {
        if (optionInput.checked) {
            checkText.textContent = optionInput.value;
        } else {
            checkText.textContent = ""; // 체크되지 않은 경우 텍스트를 비웁니다.
        }
    };
});
    };
});