package spring.teamproject.dabang.web.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.teamproject.dabang.service.manage.ManageService;
import spring.teamproject.dabang.web.dto.CMRespDto;

@RestController
@RequestMapping("/api/v1/map")
@RequiredArgsConstructor
public class MapApiController {
	
	private final ManageService manageService;
	
	@GetMapping("/address")
	public ResponseEntity<?> getAddress() {
		
		List<String> list = new ArrayList<String>();
		
		try {
			list = manageService.readAddressList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "주소 리스트 불러오기 성공", list));
	}
	
	@GetMapping("/address/city")
	public ResponseEntity<?> getAddressSiDo() {
		
		List<String> list = new ArrayList<String>();
		try {
			list = manageService.readAddressCityList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "주소 리스트 불러오기 성공", list));
	}
	
	@GetMapping("/simple/roomData")
	public ResponseEntity<?> getSimpleData() {
		
		
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "주소 리스트 불러오기 성공", null));
	}

}
