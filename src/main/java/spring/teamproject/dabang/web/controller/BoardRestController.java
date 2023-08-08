package spring.teamproject.dabang.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import spring.teamproject.dabang.domain.board.Board;
import spring.teamproject.dabang.service.BoardService;
import spring.teamproject.dabang.web.dto.CMRespDto;
import spring.teamproject.dabang.web.dto.board.AddBoardReqDto;
import spring.teamproject.dabang.web.dto.board.GetBoardRespDto;
import spring.teamproject.dabang.web.dto.board.UpdateBoardReqDto;

@RestController
@RequestMapping("/api/v1/board")
@Slf4j
@RequiredArgsConstructor
public class BoardRestController {
	
	private final BoardService boardService;
	
//	@Value("${file.path}")
//	private String filePath;
	
	@PostMapping("/post")
	public ResponseEntity<?> addBoard(@RequestBody AddBoardReqDto addBoardReqDto) {
//		log.info(">>>{}:", addBoardReqDto);
//		log.info(">>> fileName: {}", addBoardReqDto.getFile().get(0).getOriginalFilename());
//		log.info("filePath: {}", filePath);
		
		boolean BoardCode = false;
		try {
			BoardCode = boardService.addBoard(addBoardReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "Failed", addBoardReqDto));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "complete creation", addBoardReqDto));
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getTodoList(@RequestParam int usercode){
		List<Board> list = null;
		try {
			list = boardService.getBoardList(usercode);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "Failed", list));
	}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "complete creation", list));
	}
	@PutMapping("/put/{usercode}")
	public ResponseEntity<?> setContentTodo(@PathVariable int usercode, @RequestBody UpdateBoardReqDto updateBoardReqDto){
		
		boolean status = false;
		updateBoardReqDto.setUsercode(usercode);
		try {
			status = boardService.UpdateBoard(updateBoardReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(1,"failed",status));
		}
		return ResponseEntity.internalServerError().body(new CMRespDto<>(1,"success",status));
	}
	
	@DeleteMapping("/delete/{usercode}")
	public ResponseEntity<?> setdeleteTodo(@PathVariable int usercode){
		
		boolean status = false;
		
		try {
			status = boardService.deleteBoard(usercode);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1,"failed",status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1,"success",status));
	}
	

	
	
	
}







