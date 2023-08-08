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
import spring.teamproject.dabang.web.dto.board.UpdateBoardReqDto;

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
	public List<Board> getBoardList(int usercode) throws Exception {
		// TODO Auto-generated method stub
		
		List<Board> boardlist = boardRepository.getBoard(usercode);
		
		return boardlist;
	}

	@Override
	public boolean UpdateBoard(UpdateBoardReqDto updateBoardReqDto) throws Exception {
		return boardRepository.updateBoardByBoardCode(updateBoardReqDto.toEntity()) > 0;
	}
	@Override
	public boolean deleteBoard(int UserCode) throws Exception {
		return boardRepository.remove(UserCode) > 0;
	}
}	







