package spring.teamproject.dabang.service.manage;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.teamproject.dabang.domain.manage.RoomInfo;
import spring.teamproject.dabang.domain.manage.RoomInfoRepository;
import spring.teamproject.dabang.web.dto.manage.CreateRoomInfoReqDto;
import spring.teamproject.dabang.web.dto.manage.CreateRoomInfoRespDto;
import spring.teamproject.dabang.web.dto.manage.ReadRoomInfoRespDto;

@RequiredArgsConstructor
@Service
public class ManageServiceImpl implements ManageService{
	
	private final RoomInfoRepository roomInfoRepository;

	@Override
	public ReadRoomInfoRespDto readRoomInfo(int roomcode) throws Exception {
		return roomInfoRepository.getRoomInfoByRoomcode(roomcode).toReadRoomInfoDto();
	}

	@Override
	public CreateRoomInfoRespDto createBoard(CreateRoomInfoReqDto createRoomInfoReqDto) throws Exception {
		
		RoomInfo RoomInfoEntity = createRoomInfoReqDto.toEntity();
				
		boolean insertStatus = roomInfoRepository.save(createRoomInfoReqDto.toEntity()) > 0;
		
		return RoomInfoEntity.toCreateRoomInfoDto(insertStatus);
	}
	
}
