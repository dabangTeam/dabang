package spring.teamproject.dabang.web.dto.board;


import spring.teamproject.dabang.domain.board.Board;
import lombok.Data;

@Data
public class UpdateBoardReqDto {
	private String nname;
	private String noticeContent;
	 
	
	public Board toEntity() {
		return Board.builder()
				.notice_nName(nname)
				.notice_content(noticeContent)
				.build();
}
}