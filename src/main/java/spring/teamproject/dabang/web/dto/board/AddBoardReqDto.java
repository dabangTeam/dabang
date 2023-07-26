package spring.teamproject.dabang.web.dto.board;

import lombok.Data;
import spring.teamproject.dabang.domain.board.Board;

@Data
public class AddBoardReqDto {
	private String boardTitle;
	private String boardContent;
	private int boardNumber;
	
	public Board toEntity() {
		return Board.builder()
				.board_title(boardTitle)
				.board_content(boardContent)
				.board_number(boardNumber)
				.build();
	}
}
