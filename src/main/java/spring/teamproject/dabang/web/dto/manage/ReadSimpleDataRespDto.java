package spring.teamproject.dabang.web.dto.manage;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReadSimpleDataRespDto {
	private int numFloors;
	private int exclusiveArea;
	private int publicAdminFee;
	private String descTitle;
}
