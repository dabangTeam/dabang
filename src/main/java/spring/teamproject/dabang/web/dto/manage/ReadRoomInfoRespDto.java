package spring.teamproject.dabang.web.dto.manage;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReadRoomInfoRespDto {
	
		// 매물정보
		private int roomCode;
		private String salesType;
		private String salesAddress;
		private double salesSize;
		private int salesInfo;
		private int buildingUse;
		private int buildingApproval;
		
		// 거래정보
		private int trnscType;
		private int priceInfo;
		private int publicAdminFee;
		private Date moveDate;
		
		// 추가정보
		private int numFloors;
		private int totalFloors;
		private int numBathrooms;
		private int elevator;
		private int parkingAvailability;
		private int totalParking;
		
		// 시설정보
		private int facHeating;
		private List<Integer> facAircnd;
		private int facComm;
		private int facOther;
		private int facSecurity;
		
		// 사진등록
		private String photoGeneral;
		private String photoFilename;
		private String photoFilecode;
		
		// 상세설명
		private String descTitle;
		private String descDetail;
		private String descCode;
		
		// 유저정보 및 업로드
		private int userCode;
		private LocalDateTime createDate;
		private LocalDateTime updateDate;

}
