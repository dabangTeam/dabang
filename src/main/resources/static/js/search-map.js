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

    };
});


optionDetailLabels.forEach((optionLabel) => {
    const optionInput = optionLabel.querySelector(".option-detail-input");
    const checkText = optionLabel.querySelector(".check-text");
    optionInput.onchange = () => {
      if (optionInput.checked) {
        checkText.innerHTML += optionInput.value + ", ";
      } else {
        checkText.innerHTML = checkText.innerHTML.replace(
          optionInput.value + ", ",
          ""
        );
      }
    };
  });

