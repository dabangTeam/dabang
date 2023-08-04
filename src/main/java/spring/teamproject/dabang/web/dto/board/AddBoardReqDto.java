package spring.teamproject.dabang.web.dto.board;

import lombok.Data;
import spring.teamproject.dabang.domain.board.Board;

@Data
public class AddBoardReqDto {
	private String noticeTitle;
	private String noticeContent;
	private int noticeNumber;
	
	public Board toEntity() {
		return Board.builder()
				.notice_title(noticeTitle)
				.notice_content(noticeContent)
				.notice_number(noticeNumber)
				.build();
	}
}

