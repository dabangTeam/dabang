package spring.teamproject.dabang.web.dto.manage;

import java.sql.Date;
import java.time.LocalDateTime;

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
}
