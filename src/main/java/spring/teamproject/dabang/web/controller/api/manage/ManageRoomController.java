package spring.teamproject.dabang.web.controller.api.manage;

import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import spring.teamproject.dabang.service.manage.ManageService;
import spring.teamproject.dabang.web.dto.CMRespDto;
import spring.teamproject.dabang.web.dto.manage.CreateRoomInfoReqDto;
import spring.teamproject.dabang.web.dto.manage.CreateRoomInfoRespDto;
import spring.teamproject.dabang.web.dto.manage.ReadRoomInfoRespDto;
import spring.teamproject.dabang.web.dto.manage.UpdateRoomInfoReqDto;

@Slf4j
@RestController
@RequestMapping("api/v1/manage")
@RequiredArgsConstructor
public class ManageRoomController {
	
	private final ManageService manageService;
	
	@GetMapping("/list/{roomcode}")
	public ResponseEntity<?> getRoomList(@PathVariable int roomcode) {
		ReadRoomInfoRespDto readRoomInfoRespDto = null;
		log.info("룸리스트 정보 >>> ", readRoomInfoRespDto.getRoomCode());

		
		try {
			readRoomInfoRespDto = manageService.getRoomList(roomcode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "리스트 불러오기 실패", readRoomInfoRespDto));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "리스트 불러오기 성공", readRoomInfoRespDto));
	}
	
	@GetMapping("/content/{roomcode}")
	public ResponseEntity<?> getRoomInfo(@PathVariable int roomcode) {
		
		ReadRoomInfoRespDto readRoomInfoRespDto = null;
		
		try {
			readRoomInfoRespDto = manageService.readRoomInfo(roomcode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "방정보 조회 실패", readRoomInfoRespDto));

		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "방정보 조회 성공", readRoomInfoRespDto));
	}
	
	@PostMapping("/content")
	public ResponseEntity<?> addRoomInfo(@RequestBody CreateRoomInfoReqDto createRoomInfoReqDto) {
		
		CreateRoomInfoRespDto createRoomInfoRespDto = null;
		
		try {
			createRoomInfoRespDto = manageService.createRoomInfo(createRoomInfoReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "방등록 실패", createRoomInfoRespDto));

		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "방등록 성공", createRoomInfoRespDto));
	}
	
	@PutMapping("/content/{roomcode}")
	public ResponseEntity<?> updateRoomInfo(@PathVariable int roomcode, @RequestBody UpdateRoomInfoReqDto updateRoomInfoReqDto) {
		boolean status = false;
		updateRoomInfoReqDto.setRoomCode(roomcode);

		try {
			status = manageService.updateRoomInfo(updateRoomInfoReqDto);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "수정 실패", status));
		}	
		return ResponseEntity.ok().body(new CMRespDto<>(1, "수정 성공", status));
	}

	@DeleteMapping("/content/delete/{roomcode}")
	public ResponseEntity<?> deleteRoomInfo(@PathVariable int roomcode) {
		
		boolean status = false;
		
		try {
			status = manageService.deleteRoomInfo(roomcode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1,"삭제 실패", status));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1,"삭제 성공", status));
	}
	
}
