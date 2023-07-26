package spring.teamproject.dabang.domain.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {
	
	public int saveBoard(Board board) throws Exception;
	public int saveBoardFiles(List<BoardFile> list) throws Exception; 
	
	public List<Board> getBoard(Map<String, Object> map) throws Exception;
	
	public List<Board> getBoardList(Map<String, Object> map) throws Exception;
}
