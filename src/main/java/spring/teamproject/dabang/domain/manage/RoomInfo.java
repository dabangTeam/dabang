package spring.teamproject.dabang.domain.manage;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.teamproject.dabang.web.dto.manage.CreateRoomInfoRespDto;
import spring.teamproject.dabang.web.dto.manage.ReadRoomInfoRespDto;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomInfo {
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
		
		public ReadRoomInfoRespDto toReadRoomInfoDto() {
			return ReadRoomInfoRespDto.builder()
					.room_code(room_code)
					.sales_type(sales_type)
					.sales_address(sales_address)
					.sales_info(sales_info)
					.sales_size(sales_size)
					.buildingApproval(buildingApproval)
					.buildingUse(buildingUse)
					.trnsc_type(trnsc_type)
					.price_info(price_info)
					.publicAdminFee(publicAdminFee)
					.moveDate(moveDate)
					.numfloors(numfloors)
					.totalfloors(totalfloors)
					.num_bathrooms(num_bathrooms)
					.elevator(elevator)
					.parkingAvailability(parkingAvailability)
					.totalParking(totalParking)
					.fac_aircnd(fac_aircnd)
					.fac_comm(fac_comm)
					.fac_heating(fac_heating)
					.fac_other(fac_other)
					.fac_security(fac_security)
					.photo_filecode(photo_filecode)
					.photo_filename(photo_filename)
					.photo_general(photo_general)
					.desc_code(desc_code)
					.desc_detail(desc_detail)
					.desc_title(desc_title)
					.usercode(usercode)
					.createdate(createdate)
					.updatedate(updatedate)
					.build();
					
		}
		
		public CreateRoomInfoRespDto toCreateRoomInfoDto(boolean insertStatus) {
			return CreateRoomInfoRespDto.builder()
					.room_code(room_code)
					.sales_type(sales_type)
					.sales_address(sales_address)
					.sales_info(sales_info)
					.sales_size(sales_size)
					.buildingApproval(buildingApproval)
					.buildingUse(buildingUse)
					.trnsc_type(trnsc_type)
					.price_info(price_info)
					.publicAdminFee(publicAdminFee)
					.moveDate(moveDate)
					.numfloors(numfloors)
					.totalfloors(totalfloors)
					.num_bathrooms(num_bathrooms)
					.elevator(elevator)
					.parkingAvailability(parkingAvailability)
					.totalParking(totalParking)
					.fac_aircnd(fac_aircnd)
					.fac_comm(fac_comm)
					.fac_heating(fac_heating)
					.fac_other(fac_other)
					.fac_security(fac_security)
					.photo_filecode(photo_filecode)
					.photo_filename(photo_filename)
					.photo_general(photo_general)
					.desc_code(desc_code)
					.desc_detail(desc_detail)
					.desc_title(desc_title)
					.usercode(usercode)
					.createdate(createdate)
					.updatedate(updatedate)
					.build();
			
		}
}
