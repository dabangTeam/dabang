package spring.teamproject.dabang.web.dto.board;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetBoardRespDto {
	
	private int boardCode;
	private String boardTitle;
	private String boardNname;
	private int userCode;
	private String createDate;
	private int boardCount;
	private String boardContent;
	private List<Map<String, Object>> downloadFiles;
}
