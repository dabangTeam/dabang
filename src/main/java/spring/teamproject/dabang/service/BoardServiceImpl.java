package spring.teamproject.dabang.service;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import spring.teamproject.dabang.domain.board.Board;
import spring.teamproject.dabang.domain.board.BoardRepository;
import spring.teamproject.dabang.web.dto.board.AddBoardReqDto;
import spring.teamproject.dabang.web.dto.board.GetBoardListRespDto;
import spring.teamproject.dabang.web.dto.board.GetBoardRespDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
//	@Value("${file.path}")
//	private String filePath;
	
	private final BoardRepository boardRepository;
	
	@Override
	public boolean addBoard(AddBoardReqDto addBoardReqDto) throws Exception {
		
		Predicate<String> predicate = (filename) -> !filename.isBlank();
		

//		Board Board = addBoardReqDto.toEntity();
//		
//		log.info(">>>{}:", Board);
//		BoardRepository.saveBoard(Board);
		
//		if(predicate.test(addBoardReqDto.getFile().get(0).getOriginalFilename())) {
//			
//			List<BoardFile> BoardFiles = new ArrayList<BoardFile>();
//			
//			for(MultipartFile file : addBoardReqDto.getFile()) {
//				String originFilename = file.getOriginalFilename();
//				String tempFilename = UUID.randomUUID().toString().replaceAll("-", "") + "_" + originFilename;
//				
//				Path uploadPath = Paths.get(filePath, "Board/" + tempFilename);
//				
//				File f = new File(filePath + "Board");
//				if(!f.exists()) {
//					f.mkdir();
//				}
//					
//				Files.write(uploadPath, file.getBytes());
//				
//				BoardFiles.add(BoardFile.builder()
//										.board_code(Board.getBoard_code())
//										.file_name(tempFilename)
//										.build());
//				
//				
//				}
//				BoardRepository.saveBoardFiles(BoardFiles);
//			};
		return boardRepository.saveBoard(addBoardReqDto.toEntity()) == 1;
	}
	

	
	@Override
	public List<GetBoardListRespDto> getBoardList(int page, String searchFlag, String searchValue) throws Exception {

		int index = (page - 1) * 10;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("index", index);
		map.put("search_flag", searchFlag);
		map.put("search_value", searchValue == null ? "" : searchValue);
		
		List<GetBoardListRespDto> list = new ArrayList<GetBoardListRespDto>();
		
		boardRepository.getBoardList(map).forEach(Board -> {
			list.add(Board.toListDto());
		});		
		return list;
	}

	@Override
	public List<Board> getBoardList(int UserCode) throws Exception {
		List<Board> boardlist = boardRepository.getBoard(UserCode);
		
		return boardlist;
	}

}







