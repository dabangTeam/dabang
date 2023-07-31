package spring.teamproject.dabang.web.dto.manage;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Data;
import spring.teamproject.dabang.domain.manage.RoomInfo;

@Data
public class CreateRoomInfoReqDto {
	
		// 매물정보
		private int roomCode;
		private int salesType;
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
	
	public RoomInfo toEntity() {
		return RoomInfo.builder()
				.room_code(roomCode)
				.sales_type(salesType)
				.sales_address(salesAddress)
				.sales_info(salesInfo)
				.sales_size(salesSize)
				.building_approval(buildingApproval)
				.building_use(buildingUse)
				.trnsc_type(trnscType)
				.price_info(priceInfo)
				.public_admin_fee(publicAdminFee)
				.move_date(moveDate)
				.num_floors(numFloors)
				.total_floors(totalFloors)
				.num_bathrooms(numBathrooms)
				.elevator(elevator)
				.parking_availability(parkingAvailability)
				.total_parking(totalParking)
				.fac_aircnd(facAircnd)
				.fac_comm(facComm)
				.fac_heating(facHeating)
				.fac_other(facOther)
				.fac_security(facSecurity)
				.photo_filecode(photoFilecode)
				.photo_filename(photoFilename)
				.photo_general(photoGeneral)
				.desc_code(descCode)
				.desc_detail(descDetail)
				.desc_title(descTitle)
				.user_code(userCode)
				.create_date(createDate)
				.update_date(updateDate)
				.build();
	}
	
}
