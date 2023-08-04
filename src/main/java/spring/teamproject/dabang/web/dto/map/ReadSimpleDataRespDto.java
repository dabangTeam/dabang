package spring.teamproject.dabang.web.dto.map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReadSimpleDataRespDto {
	private int roomCode;
	private String salesType;		// 원룸, 오피스텔, 아파트
	private int priceInfo; 			// 전세.월세 
	private int numFloors;			// 방 층/전체 층 
	private int salesSize;			// 전용면적/공급면적
	private int publicAdminFee;		// 관리비
	private String descTitle;		// 추가설명 제목
}
