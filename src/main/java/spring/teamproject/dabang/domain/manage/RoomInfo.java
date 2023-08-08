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
import spring.teamproject.dabang.web.dto.map.ReadSimpleDataRespDto;

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
		private int user_code;
		private LocalDateTime create_date;
		private LocalDateTime update_date;
		
		public ReadRoomInfoRespDto toReadRoomInfoDto() {
			return ReadRoomInfoRespDto.builder()
					.roomCode(room_code)
					.salesType(sales_type)
					.unregisteredCheck(unregistered_check)
					.salesAddressMainRoad(sales_address_main_road)
					.salesAddressMainJibeon(sales_address_main_jibeon)
					.salesAddressDong(sales_address_dong)
					.salesAddressHo(sales_address_ho)
					.salesExclusiveP(sales_exclusive_p)
					.salesExclusiveM(sales_exclusive_m)
					.salesSupplyP(sales_supply_p)
					.salesSupplyM(sales_supply_m)
					.roomInfoCount(room_info_count)
					.roomInfoLivingroom(room_info_livingroom)
					.roomInfoChar(room_info_char)
					.buildingUse(building_use)
					.buildingApproval(building_approval)
					.buildingApprovalDate(building_approval_date)
					
					.trnscType(trnsc_type)
					.depositPrice(deposit_price)
					.monthlyPriceDeposit(monthly_price_deposit)
					.monthlyPrice(monthly_price)
					.publicManagement(public_management)
					.managementFee(management_fee)
					.possibleMoved(possible_moved)
					.possibleMovedDate(building_approval_date)
					.possibleMovedCheck(possible_moved_check)
					
					.totalFloors(total_floors)
					.numFloor(num_floor)
					.numBathrooms(num_bathrooms)
					.elevator(elevator)
					.parkingAvailability(parking_availability)
					.totalParking(total_parking)
					
					.facHeating(fac_heating)
					.facAircnd(fac_aircnd)
					.facComm(fac_comm)
					.facOther(fac_other)
					.facSecurity(fac_security)
					
					.photoGeneral(photo_general)
					.photoFilecode(photo_filecode)
					.photoFilename(photo_filename)
					
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
					.depositPrice(deposit_price)
					.monthlyPriceDeposit(monthly_price_deposit)
					.monthlyPrice(monthly_price)
					.salesType(sales_type)
					.salesAddressMainRoad(sales_address_main_road)
					.salesAddressMainJibeon(sales_address_main_jibeon)
					.salesAddressDong(sales_address_dong)
					.salesAddressHo(sales_address_ho)
					.descTitle(desc_detail)
					.updateDate(update_date)
					.build();
		}
		
		public CreateRoomInfoRespDto toCreateRoomInfoDto(boolean insertStatus) {
			return CreateRoomInfoRespDto.builder()
					.roomCode(room_code)
					.salesType(sales_type)
					.unregisteredCheck(unregistered_check)
					.salesAddressMainRoad(sales_address_main_road)
					.salesAddressMainJibeon(sales_address_main_jibeon)
					.salesAddressDong(sales_address_dong)
					.salesAddressHo(sales_address_ho)
					.salesExclusiveP(sales_exclusive_p)
					.salesExclusiveM(sales_exclusive_m)
					.salesSupplyP(sales_supply_p)
					.salesSupplyM(sales_supply_m)
					.roomInfoCount(room_info_count)
					.roomInfoLivingroom(room_info_livingroom)
					.roomInfoChar(room_info_char)
					.buildingUse(building_use)
					.buildingApproval(building_approval)
					.buildingApprovalDate(building_approval_date)
					
					.trnscType(trnsc_type)
					.depositPrice(deposit_price)
					.monthlyPriceDeposit(monthly_price_deposit)
					.monthlyPrice(monthly_price)
					.publicManagement(public_management)
					.managementFee(management_fee)
					.possibleMoved(possible_moved)
					.possibleMovedDate(building_approval_date)
					.possibleMovedCheck(possible_moved_check)
					
					.totalFloors(total_floors)
					.numFloor(num_floor)
					.numBathrooms(num_bathrooms)
					.elevator(elevator)
					.parkingAvailability(parking_availability)
					.totalParking(total_parking)
					
					.facHeating(fac_heating)
					.facAircnd(fac_aircnd)
					.facComm(fac_comm)
					.facOther(fac_other)
					.facSecurity(fac_security)
					
					.photoGeneral(photo_general)
					.photoFilecode(photo_filecode)
					.photoFilename(photo_filename)
					
					.descCode(desc_code)
					.descDetail(desc_detail)
					.descTitle(desc_title)
					
					.userCode(user_code)
					.createDate(create_date)
					.updateDate(update_date)
					.build();
		}
		
		public ReadRoomInfoRespDto toReadAddressDto() {
			return ReadRoomInfoRespDto.builder()
					.salesAddressMainRoad(sales_address_main_road)
					.salesAddressMainJibeon(sales_address_main_jibeon)
					.salesAddressDong(sales_address_dong)
					.salesAddressHo(sales_address_ho)
					.build();
		}
		
<<<<<<< HEAD
=======
		/*
		 * public ReadSimpleDataRespDto toSimpleDataDto() { return
		 * ReadSimpleDataRespDto.builder() .numFloor(num_floor)
		 * .publicAdminFee(public_admin_fee) .descTitle(desc_title) .build(); }
		 */
		
>>>>>>> PJH
}
