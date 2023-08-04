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
	private int notice_code;
	private int notice_type;
	private String notice_title;
	private int notice_number;
	private int user_code;
	private String user_id;
	private String notice_content;
	
	
	private int file_code;
	private String file_name;
	private LocalDateTime create_date;
	
	private int total_board_count;
	
	public GetBoardListRespDto toListDto() {
		return GetBoardListRespDto.builder()
				.boardCode(notice_code)
				.boardType(notice_type)
				.boardTitle(notice_title)
				.boardNumber(notice_number)
				.boardContent(notice_content)
				.createDate(create_date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))

				.build();
	}
}











