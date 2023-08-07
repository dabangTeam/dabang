package spring.teamproject.dabang.domain.manage;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomDataRepository {
	public List<RoomData> readRoomData(String address) throws Exception;
}
