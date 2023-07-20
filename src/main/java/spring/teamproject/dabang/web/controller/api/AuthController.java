package spring.teamproject.dabang.web.controller.api;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.teamproject.dabang.handler.aop.annotation.ValidCheck;
import spring.teamproject.dabang.service.auth.AuthService;
import spring.teamproject.dabang.service.auth.PrincipalDetails;
import spring.teamproject.dabang.service.auth.PrincipalDetailsService;
import spring.teamproject.dabang.web.dto.CMRespDto;
import spring.teamproject.dabang.web.dto.auth.LoginReqDto;
import spring.teamproject.dabang.web.dto.auth.SignupReqDto;
import spring.teamproject.dabang.web.dto.auth.UserEmailCheckReqDto;
import spring.teamproject.dabang.web.dto.auth.UserPasswordCheckReqDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	private final AuthService authService;
	private final PrincipalDetailsService principalDetailsService;
	
	@ValidCheck
	@PostMapping("/welcome/join")
	public ResponseEntity<?> join(@RequestBody @Valid SignupReqDto signupReqDto, BindingResult bindingResult) {
		
		boolean status = false;
		System.out.println(signupReqDto.getPassword());
		try {
			status = principalDetailsService.addUser(signupReqDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "회원가입 실패", status));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "회원가입 성공", status));
	}
	
	@ValidCheck
	@GetMapping("/join/email/validation")
	public ResponseEntity<?> checkUserEmail(@Valid UserEmailCheckReqDto userEmailCheckReqDto, BindingResult bindingResult) {
		boolean status = false;
		System.out.println("Authcontroller " + userEmailCheckReqDto.getEmail());
		
		try {
			status = authService.checkUserEmail(userEmailCheckReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "이메일 중복검사 실패,서버오류", status));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "이메일 중복검사 완료", status));
	}
	
	@ValidCheck
	@GetMapping("/join/password/validation")
	public ResponseEntity<?> checkUserPassword(@Valid UserPasswordCheckReqDto userPasswordCheckReqDto, BindingResult bindingResult){
		boolean status = false;
		System.out.println("Authcontroller" + userPasswordCheckReqDto.getPassword());
		
		try {
			status = authService.checkUserPassword(userPasswordCheckReqDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new CMRespDto<>(1, "비밀번호 유효성 검사 성공", status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(-1, "비밀번호 유효성 검사 실패", status));
	}
	
	
	
	@GetMapping("/principal")
	public ResponseEntity<?> getPrincipal(@AuthenticationPrincipal PrincipalDetails principalDetails){
		if(principalDetails == null) {
			return  ResponseEntity.badRequest().body(new CMRespDto<>(-1, "principal is null", null));
		}
		return  ResponseEntity.ok().body(new CMRespDto<>(1, "success load", principalDetails.getUser()));
	}
	
	// 로그인 처리를 위한 메서드
	@ValidCheck
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid LoginReqDto loginReqDto, BindingResult bindingResult) {
		boolean status = false;

		// Validation 오류 체크
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "입력값이 올바르지 않습니다.", status));
		}

		// 로그인 처리
		try {
			status = authService.login(loginReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "로그인 실패", status));
		}

		if (status) {
			return ResponseEntity.ok().body(new CMRespDto<>(1, "로그인 성공", status));
		} else {
			return ResponseEntity.ok().body(new CMRespDto<>(0, "아이디 또는 비밀번호가 일치하지 않습니다.", status));
		}
	}

}
