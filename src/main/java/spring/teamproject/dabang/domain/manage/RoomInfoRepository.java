package spring.teamproject.dabang.domain.manage;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomInfoRepository {
	
	public RoomInfo getRoomInfoByRoomcode(int roomcode);
	
	public int save(RoomInfo roomInfo);

}
