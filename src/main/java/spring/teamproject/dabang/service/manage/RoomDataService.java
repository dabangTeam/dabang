package spring.teamproject.dabang.service.manage;

import java.util.List;

import spring.teamproject.dabang.domain.manage.RoomData;
import spring.teamproject.dabang.web.dto.manage.ReadRoomInfoRespDto;

public interface RoomDataService {

	public List<RoomData> readRoomInfoRespDto(String address) throws Exception;
}
