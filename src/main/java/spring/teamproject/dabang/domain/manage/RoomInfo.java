package spring.teamproject.dabang.domain.manage;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

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
		private String sales_type;
		private String sales_address;
		private double sales_size;
		private int sales_info;
		private int building_use;
		private int building_approval;
		
		// 거래정보
		private int trnsc_type;
		private int price_info;
		private int public_admin_fee;
		private Date move_date;
		
		// 추가정보
		private int num_floors;
		private int total_floors;
		private int num_bathrooms;
		private int elevator;
		private int parking_availability;
		private int total_parking;
		
		// 시설정보
		private int fac_heating;
		private List<Integer> fac_aircnd;
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
		private int user_code;
		private LocalDateTime create_date;
		private LocalDateTime update_date;
		
		public ReadRoomInfoRespDto toReadRoomInfoDto() {
			return ReadRoomInfoRespDto.builder()
					.roomCode(room_code)
					.salesType(sales_type)
					.salesAddress(sales_address)
					.salesInfo(sales_info)
					.salesSize(sales_size)
					.buildingApproval(building_approval)
					.buildingUse(building_use)
					.trnscType(trnsc_type)
					.priceInfo(price_info)
					.publicAdminFee(public_admin_fee)
					.moveDate(move_date)
					.numFloors(num_floors)
					.totalFloors(num_floors)
					.numBathrooms(num_bathrooms)
					.elevator(elevator)
					.parkingAvailability(parking_availability)
					.totalParking(total_parking)
					.facAircnd(fac_aircnd)
					.facComm(fac_comm)
					.facHeating(fac_heating)
					.facOther(fac_other)
					.facSecurity(fac_security)
					.photoFilecode(photo_filecode)
					.photoFilename(photo_filename)
					.photoGeneral(photo_general)
					.descCode(desc_code)
					.descDetail(desc_detail)
					.descTitle(desc_title)
					.userCode(user_code)
					.createDate(create_date)
					.updateDate(update_date)
					.build();
					
		}
		
		public ReadRoomInfoRespDto toGetRoomInfoDto() {
			return ReadRoomInfoRespDto.builder()
					.roomCode(room_code)
					.trnscType(trnsc_type)
					.priceInfo(price_info)
					.salesType(sales_type)
					.salesAddress(sales_address)
					.descTitle(desc_detail)
					.updateDate(update_date)
					.build();
		}
		
		public CreateRoomInfoRespDto toCreateRoomInfoDto(boolean insertStatus) {
			return CreateRoomInfoRespDto.builder()
					.roomCode(room_code)
					.salesType(sales_type)
					.salesAddress(sales_address)
					.salesInfo(sales_info)
					.salesSize(sales_size)
					.buildingApproval(building_approval)
					.buildingUse(building_use)
					.trnscType(trnsc_type)
					.priceInfo(price_info)
					.publicAdminFee(public_admin_fee)
					.moveDate(move_date)
					.numFloors(num_floors)
					.totalFloors(num_floors)
					.numBathrooms(num_bathrooms)
					.elevator(elevator)
					.parkingAvailability(parking_availability)
					.totalParking(total_parking)
					.facAircnd(fac_aircnd)
					.facComm(fac_comm)
					.facHeating(fac_heating)
					.facOther(fac_other)
					.facSecurity(fac_security)
					.photoFilecode(photo_filecode)
					.photoFilename(photo_filename)
					.photoGeneral(photo_general)
					.descCode(desc_code)
					.descDetail(desc_detail)
					.descTitle(desc_title)
					.userCode(user_code)
					.createDate(create_date)
					.updateDate(update_date)
					.build();
			
		}
}
