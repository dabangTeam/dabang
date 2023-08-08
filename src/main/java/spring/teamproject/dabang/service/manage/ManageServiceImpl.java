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
		
		List<Integer> facAircndList = convertStringToList(createRoomInfoReqDto.getFacAircnd());
		createRoomInfoReqDto.setFacAircndList(facAircndList);
		
		List<Integer> facCommList = convertStringToList(createRoomInfoReqDto.getFacComm());
	    createRoomInfoReqDto.setFacCommList(facCommList);

	    List<Integer> facSecList = convertStringToList(createRoomInfoReqDto.getFacSecurity());
	    createRoomInfoReqDto.setFacSecList(facSecList);

	    List<Integer> facOtherList = convertStringToList(createRoomInfoReqDto.getFacOther());
	    createRoomInfoReqDto.setFacOtherList(facOtherList);
		/*
		 * String[] facAircndArray = createRoomInfoReqDto.getFacAircnd().split(",");
		 * List<Integer> facAircndList = new ArrayList<>();
		 * 
		 * for(String s : facAircndArray) { facAircndList.add(Integer.parseInt(s)); }
		 * 
		 * createRoomInfoReqDto.setFacAircndList(facAircndList);
		 
	    String[] facCommArray = createRoomInfoReqDto.getFacComm().split(",");
	    List<Integer> facCommList = new ArrayList<>();
	    
	    for(String s : facCommArray) {
	    	facCommList.add(Integer.parseInt(s));
	    }
	    createRoomInfoReqDto.setFacCommList(facCommList);
	    
	    String[] facSecArray = createRoomInfoReqDto.getFacSecurity().split(",");
	    List<Integer> facSecList = new ArrayList<>();
	    
	    for(String s : facSecArray) {
	    	facSecList.add(Integer.parseInt(s));
	    }
	    createRoomInfoReqDto.setFacSecList(facSecList);
	    
	    String[] facOtherArray = createRoomInfoReqDto.getFacOther().split(",");
	    List<Integer> facOtherList = new ArrayList<>();
	    
	    for(String s : facOtherArray) {
	    	facOtherList.add(Integer.parseInt(s));
	    }
	    createRoomInfoReqDto.setFacOtherList(facOtherList);
	    */
		
		RoomInfo RoomInfoEntity = createRoomInfoReqDto.toEntity();
				
		boolean insertStatus = roomInfoRepository.save(createRoomInfoReqDto.toEntity()) > 0;
		
		return RoomInfoEntity.toCreateRoomInfoDto(insertStatus);
	}

	@Override
	public boolean updateRoomInfo(UpdateRoomInfoReqDto updateRoomInfoReqDto) throws Exception {
		
		List<Integer> facAircndList = convertStringToList(updateRoomInfoReqDto.getFacAircnd());
		updateRoomInfoReqDto.setFacAircndList(facAircndList);
		
		List<Integer> facCommList = convertStringToList(updateRoomInfoReqDto.getFacComm());
		updateRoomInfoReqDto.setFacCommList(facCommList);

	    List<Integer> facSecList = convertStringToList(updateRoomInfoReqDto.getFacSecurity());
	    updateRoomInfoReqDto.setFacSecList(facSecList);

	    List<Integer> facOtherList = convertStringToList(updateRoomInfoReqDto.getFacOther());
	    updateRoomInfoReqDto.setFacOtherList(facOtherList);
		
		/*
		 * String[] facAircndArray = updateRoomInfoReqDto.getFacAircnd().split(",");
		 * List<Integer> facAircndList = new ArrayList<>();
		 * 
		 * for(String s : facAircndArray) { facAircndList.add(Integer.parseInt(s)); }
		 * 
		 * updateRoomInfoReqDto.setFacAircndList(facAircndList);
		 * 
		 * String[] facCommArray = updateRoomInfoReqDto.getFacComm().split(",");
		 * List<Integer> facCommList = new ArrayList<>();
		 * 
		 * for(String s : facCommArray) { facCommList.add(Integer.parseInt(s)); }
		 * updateRoomInfoReqDto.setFacCommList(facCommList);
		 * 
		 * String[] facSecArray = updateRoomInfoReqDto.getFacSecurity().split(",");
		 * List<Integer> facSecList = new ArrayList<>();
		 * 
		 * for(String s : facSecArray) { facSecList.add(Integer.parseInt(s)); }
		 * updateRoomInfoReqDto.setFacSecList(facSecList);
		 * 
		 * String[] facOtherArray = updateRoomInfoReqDto.getFacOther().split(",");
		 * List<Integer> facOtherList = new ArrayList<>();
		 * 
		 * for(String s : facOtherArray) { facOtherList.add(Integer.parseInt(s)); }
		 * updateRoomInfoReqDto.setFacOtherList(facOtherList);
		 */
		
		RoomInfo roomInfoEntity = updateRoomInfoReqDto.toEntity();
		
		return roomInfoRepository.updateRoomInfoByRoomcode(roomInfoEntity) > 0;
	}

	@Override
	public boolean deleteRoomInfo(int roomcode) throws Exception{
		
		return roomInfoRepository.remove(roomcode) > 0;
	}

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
	
	// 반복구문을 메서드로 분리.
	private List<Integer> convertStringToList(String data) {
		String[] dataArray = data.split(",");
	    List<Integer> dataList = new ArrayList<>();

	    for(String s : dataArray) {
	        dataList.add(Integer.parseInt(s));
	    }

	    return dataList;
	}
	
	
}



