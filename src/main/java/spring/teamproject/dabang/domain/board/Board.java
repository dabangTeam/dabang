package spring.teamproject.dabang.domain.board;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import spring.teamproject.dabang.web.dto.board.GetBoardListRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Board {
	private int board_code;
	private int board_type;
	private String board_title;
	private int board_number;
	private int user_code;
	private String user_id;
	private String board_content;
	private int board_count;
	
	
	private int file_code;
	private String file_name;
	private LocalDateTime create_date;
	
	private int total_board_count;
	
	public GetBoardListRespDto toListDto() {
		return GetBoardListRespDto.builder()
				.boardCode(board_code)
				.boardType(board_type)
				.boardTitle(board_title)
				.boardNumber(board_number)
				.userId(user_id)
				.createDate(create_date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
				.boardCount(board_count)
				.totalboardCount(total_board_count)
				.build();
	}
}











