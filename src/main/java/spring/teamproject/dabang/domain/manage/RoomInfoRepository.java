package spring.teamproject.dabang.domain.manage;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomInfoRepository {
	
	public RoomInfo getRoomInfoByRoomcode(int roomcode);
	
	public RoomInfo getRoomListByRoomcode(int roocdode);
	
	public int save(RoomInfo roomInfo);
	
	public int updateRoomInfoByRoomcode(RoomInfo roomInfo);
	
	public int remove(int roomcode);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<String> getAddressList();
	public List<String> getAddressCityList();
	public List<String> getSimpleDataList();
}
