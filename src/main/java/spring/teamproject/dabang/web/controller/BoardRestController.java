package spring.teamproject.dabang.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
//	@GetMapping("/{flag}/{BoardCode}")
//	public ResponseEntity<?> getBoard(@PathVariable String flag, @PathVariable int BoardCode) {
//		GetBoardRespDto getBoardRespDto = null;
//		if(flag.equals("pre") || flag.equals("next")) {
//			try {
//				getBoardRespDto = boardService.getBoard(flag, BoardCode);
//				if(getBoardRespDto == null) {
//					return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "datebase failed", null));
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "datebase error", null));
//			}			
//		}else {
//			return ResponseEntity.ok().body(new CMRespDto<>(1, "request failed", null));
//		}
//		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", getBoardRespDto));
//	}
	
//	@GetMapping("/file/download/{fileName}")
//	public ResponseEntity<?> downloadFile(@PathVariable String fileName) throws IOException {
//		Path path = Paths.get(filePath + "Board/" + fileName);
//		String contentType = Files.probeContentType(path);
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentDisposition(ContentDisposition.builder("attachment")
//														.filename(fileName, StandardCharsets.UTF_8)
//														.build());
//		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
//		Resource resource = new InputStreamResource(Files.newInputStream(path));
//		
//		return ResponseEntity.ok().headers(headers).body(resource);
//	}
	
//	@GetMapping("/list/{page}")
//	public ResponseEntity<?> getBoardList(@PathVariable int page, @RequestParam String searchFlag, @RequestParam String searchValue) {
//		List<GetBoardListRespDto> listDto = null;
//		try {
//			listDto = boardService.getBoardList(page, searchFlag, searchValue);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", listDto));
//		}
//		
//		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", listDto));
//	}
	
	
	
}







