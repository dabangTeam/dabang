package spring.teamproject.dabang.service.manage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.teamproject.dabang.domain.manage.RoomData;
import spring.teamproject.dabang.domain.manage.RoomDataRepository;
import spring.teamproject.dabang.web.dto.manage.ReadRoomInfoRespDto;

@Service
@RequiredArgsConstructor
public class RoomDataServiceImpl implements RoomDataService{

	private final RoomDataRepository roomDataRepository;

	@Override
	public List<RoomData> readRoomInfoRespDto(String address) throws Exception {
		List<RoomData> list = new ArrayList<RoomData>();
		list = roomDataRepository.readRoomData(address);
		return list;
	}
	
	
	
}