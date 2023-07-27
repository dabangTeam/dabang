package spring.teamproject.dabang.web.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.teamproject.dabang.web.dto.CMRespDto;

@RestController
public class MapApiController {
	
	
	@GetMapping("/address/list")
	public ResponseEntity<?> getAddressList() {
		
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "주소 리스트 불러오기 성공", null));
	}
}
