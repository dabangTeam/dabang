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
public class CreateRoomInfoRespDto {
		// 매물정보
<<<<<<< HEAD
			private int room_code;
			private int sales_type;
			private String sales_address;
			private double sales_size;
			private int sales_info;
			private int buildingUse;
			private int buildingApproval;
			
			// 거래정보
			private int trnsc_type;
			private int price_info;
			private int publicAdminFee;
			private Date moveDate;
			
			// 추가정보
			private int numfloors;
			private int totalfloors;
			private int num_bathrooms;
			private int elevator;
			private int parkingAvailability;
			private int totalParking;
			
			// 시설정보
			private int fac_heating;
			private int fac_aircnd;
			private int fac_comm;
			private int fac_other;
			private int fac_security;
			
			// 사진등록
			private String photo_general;
			private String photo_filename;
			private String photo_filecode;
			
			// 상세설명
			private String desc_title;
			private String desc_detail;
			private String desc_code;	
			
			// 유저정보 및 업로드
			private int usercode;
			private LocalDateTime createdate;
			private LocalDateTime updatedate;
=======
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
		private int facAircnd;
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
>>>>>>> PJH
}
