package spring.teamproject.dabang.service;

import java.util.List;

import spring.teamproject.dabang.domain.board.Board;
import spring.teamproject.dabang.web.dto.board.AddBoardReqDto;
import spring.teamproject.dabang.web.dto.board.GetBoardListRespDto;
import spring.teamproject.dabang.web.dto.board.GetBoardRespDto;


public interface BoardService {
	public boolean addBoard(AddBoardReqDto addBoardReqDto) throws Exception;
	
	
	public List<GetBoardListRespDto> getBoardList(int page, String searchFlag, String searchValue) throws Exception;
	
	public List<Board> getBoardList(int UserCode) throws Exception;
}
