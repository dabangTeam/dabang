document.addEventListener("DOMContentLoaded", () => {
    const boardContentsRows = document.querySelectorAll(".board-contents");

    boardContentsRows.forEach(row => {
        row.addEventListener("click", () => {
            const contentsPlus = row.nextElementSibling.querySelector(".contents-plus");
            contentsPlus.style.display = contentsPlus.style.display === "block" ? "none" : "block"; // Toggle display
        });
    });
});


const inqueryButton = document.querySelector(".Inquery");

inqueryButton.onclick = () => {
    location.href = "/board";
}

function load() {
	$.ajax({
        type: "get",
        url: `/api/v1/board/get?usercode=1`,
        dataType: "json",
        success: (response) => {
			console.log(response.data);
			loadContent(response.data);
			ContentArray(response.data);
		},
		error: (error) => {
			console.log(error);
		}
	});
}

load();





function loadContent(data) {
	
	const contentPlus = document.querySelector(".contents-plus");
	contentPlus.innerHTML = ""; // 내용 초기화

	data.forEach(content => {
		contentPlus.innerHTML += `<p>${content.notice_content}</p>`; // 누적하여 추가
	});
		
}

function ContentArray(data) {
	const boardContents = document.querySelector(".board-contents");
	boardContents.innerHTML = "";
	 
    for (const item of data) {
        boardContents.innerHTML += `
            <tr class="board-contents">
                <td class="board-type board-content">${item.notice_type}</td>
                <td class="board-title board-content">${item.notice_title}</td>
                <td class="board-enrollment board-content">${item.create_date}</td>
                <td class="board-answer board-content">${item.total_board_count > 0 ? "답변 완료" : "미답변"}</td>
            </tr>
        `;
    }
}


