package spring.teamproject.dabang.service.manage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.teamproject.dabang.domain.manage.RoomInfo;
import spring.teamproject.dabang.domain.manage.RoomInfoRepository;
import spring.teamproject.dabang.web.dto.manage.CreateRoomInfoReqDto;
import spring.teamproject.dabang.web.dto.manage.CreateRoomInfoRespDto;
import spring.teamproject.dabang.web.dto.manage.ReadRoomInfoRespDto;
import spring.teamproject.dabang.web.dto.manage.UpdateRoomInfoReqDto;

@RequiredArgsConstructor
@Service
public class ManageServiceImpl implements ManageService{
	
	private final RoomInfoRepository roomInfoRepository;

	@Override
	public ReadRoomInfoRespDto readRoomInfo(int roomcode) throws Exception {
		
		return roomInfoRepository.getRoomInfoByRoomcode(roomcode).toReadRoomInfoDto();
	}
	
	@Override
	public ReadRoomInfoRespDto getRoomList(int roomcode) throws Exception {
		return roomInfoRepository.getRoomListByRoomcode(roomcode).toGetRoomInfoDto();
	}

	@Override
	public CreateRoomInfoRespDto createRoomInfo(CreateRoomInfoReqDto createRoomInfoReqDto) throws Exception {
		
		RoomInfo RoomInfoEntity = createRoomInfoReqDto.toEntity();
				
		boolean insertStatus = roomInfoRepository.save(createRoomInfoReqDto.toEntity()) > 0;
		
		return RoomInfoEntity.toCreateRoomInfoDto(insertStatus);
	}

	@Override
	public boolean updateRoomInfo(UpdateRoomInfoReqDto updateRoomInfoReqDto) throws Exception {
		
		RoomInfo roomInfoEntity = updateRoomInfoReqDto.toEntity();
		
		return roomInfoRepository.updateRoomInfoByRoomcode(roomInfoEntity) > 0;
	}

	@Override
	public boolean deleteRoomInfo(int roomcode) throws Exception{
		
		return roomInfoRepository.remove(roomcode) > 0;
	}
<<<<<<< HEAD

	@Override
	public List<String> readAddressList() throws Exception {
		
		List<String> list = new ArrayList<String>();
		
		list = roomInfoRepository.getAddressList();
		
		return list;
	}

	@Override
	public List<String> readAddressCityList() throws Exception {
		List<String> list = new ArrayList<String>();
		
		list = roomInfoRepository.getAddressCityList();
		
		return list;
	}

=======
>>>>>>> PJH
	
	
}
