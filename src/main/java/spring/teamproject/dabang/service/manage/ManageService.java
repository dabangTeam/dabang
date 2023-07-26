package spring.teamproject.dabang.service.manage;

import spring.teamproject.dabang.web.dto.manage.CreateRoomInfoReqDto;
import spring.teamproject.dabang.web.dto.manage.CreateRoomInfoRespDto;
import spring.teamproject.dabang.web.dto.manage.ReadRoomInfoRespDto;

public interface ManageService {

	public ReadRoomInfoRespDto readRoomInfo(int roomcode) throws Exception;
	public CreateRoomInfoRespDto createBoard(CreateRoomInfoReqDto createRoomInfoReqDto) throws Exception;
}
