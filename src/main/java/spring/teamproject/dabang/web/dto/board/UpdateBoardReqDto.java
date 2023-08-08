package spring.teamproject.dabang.web.dto.board;


import spring.teamproject.dabang.domain.board.Board;
import lombok.Data;

@Data
public class UpdateBoardReqDto {
	private int usercode;
	private String noticeContent;
	 
	
	public Board toEntity() {
		return Board.builder()
				.user_code(usercode)
				.notice_content(noticeContent)
				.build();
}
}