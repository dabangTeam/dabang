package spring.teamproject.dabang.web.dto.map;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReadSimpleDataRespDto {
	private int roomCode;
	private String salesType;				// 원룸, 오피스텔, 아파트
	private String AddressRoad; 			// 도로명주소
	private String AddressJibun;			// 지번주소
	private String sizeExclusiveP;			// 전용면적 평수
	private int sizeExclusiveM;				// 전용면적 제곱미터
	private String sizeSupplyP;				// 공급면적 평수
	private int sizeSupplyM;				// 공급면적 제곱미터
	private int roomCount;					// 방수
	private String roomInfoChar;			// 방특징
	private String buildingUse;				// 건축물 용도
	private LocalDate BuildingApprovalDate;	// 승인 날짜
	private String trnseType;				// 전월세 중
	private int depositPrice;				// 전세
	private int monthlyPriceDeposit;		// 보증금
	private int monthlyPrice;				// 월세
	private int managementFee;				// 관리비
	private String possibleMoved;			// 입주가능날짜
	private String possibleMoveDate;		// 입주가능날짜
	private String totalFloors;				// 전체 층 수
	private String numFloor;				// 해당 층 수
	private int numBathrooms;				// 욕실 수
	private String elevator;				// 엘리베이터
	private String parkingAvailability;		// 주차가능여부
	private int totalParking;				// 주차가능 수
	private int numFloors;					// 방 층/전체 층 
	private int salesSize;					// 전용면적/공급면적
	private int publicAdminFee;				// 관리비
	private String descTitle;				// 추가설명 제목
}
