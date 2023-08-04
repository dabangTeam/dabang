package spring.teamproject.dabang.service.manage;

import java.util.List;

import spring.teamproject.dabang.web.dto.manage.CreateRoomInfoReqDto;
import spring.teamproject.dabang.web.dto.manage.CreateRoomInfoRespDto;
import spring.teamproject.dabang.web.dto.manage.ReadRoomInfoRespDto;
import spring.teamproject.dabang.web.dto.manage.UpdateRoomInfoReqDto;

public interface ManageService {

<<<<<<< HEAD
=======
	public ReadRoomInfoRespDto readRoomInfo(int roomcode) throws Exception;
	public ReadRoomInfoRespDto getRoomList(int roomcode) throws Exception;
>>>>>>> PJH
	public CreateRoomInfoRespDto createRoomInfo(CreateRoomInfoReqDto createRoomInfoReqDto) throws Exception;
	
	public ReadRoomInfoRespDto readRoomInfo(int roomcode) throws Exception;
	
	public List<String> readAddressList() throws Exception; // kjh 작업중
	
	public List<String> readAddressCityList() throws Exception;
	
	public boolean updateRoomInfo (UpdateRoomInfoReqDto updateRoomInfoReqDto) throws Exception;
	
	public boolean deleteRoomInfo (int roomcode) throws Exception;
	
}
