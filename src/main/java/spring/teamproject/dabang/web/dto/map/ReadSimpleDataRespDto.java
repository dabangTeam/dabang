package spring.teamproject.dabang.web.dto.map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReadSimpleDataRespDto {
	private int priceInfo; 			// 전세.월세
	private int numFloors;			// 방 층 
	private int exclusiveArea;		
	private int publicAdminFee;
	private String descTitle;
}
