package spring.teamproject.dabang.service.auth;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import spring.teamproject.dabang.domain.user.User;
import spring.teamproject.dabang.domain.user.UserRepository;
import spring.teamproject.dabang.web.dto.auth.LoginReqDto;
import spring.teamproject.dabang.web.dto.auth.SignupReqDto;
import spring.teamproject.dabang.web.dto.auth.UserEmailCheckReqDto;
import spring.teamproject.dabang.web.dto.auth.UserPasswordCheckReqDto;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final UserRepository userRepository;
	
	@Override
	public boolean checkUserEmail(UserEmailCheckReqDto userEmailCheckReqDto) throws Exception {
		System.out.println("AuthSer " +userEmailCheckReqDto.getEmail());
		
		return userRepository.findUserByUserEmail(userEmailCheckReqDto.getEmail()) == null;
	}
//
//	public User login(SignupReqDto signupReqDto) {
//
//	}
//	

	@Override
	public boolean signup() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkUserPassword(UserPasswordCheckReqDto userPasswordCheckReqDto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
    public boolean login(LoginReqDto loginReqDto) {
        // 단계 1: 제공된 이메일을 사용하여 데이터베이스에서 사용자 정보를 가져옵니다.
        String email = loginReqDto.getEmail();
        User user = null;
		try {
			user = userRepository.findUserByUserEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("au서비스 임플리에서 ");
		}

        if (user == null) {
            // 데이터베이스에서 사용자를 찾을 수 없는 경우, 로그인 실패
        	System.out.println("사용자 찾을 수 없음");
            return false;
        }

        // 단계 2: 제공된 비밀번호와 데이터베이스에 저장된 해시된 비밀번호를 비교합니다.
        String providedPassword = loginReqDto.getPassword();
        String hashedPassword = user.getUser_password(); // 사용자 엔티티에 해시된 비밀번호가 저장된 필드를 가정합니다.

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(providedPassword, hashedPassword)) {
            // 비밀번호가 일치하는 경우, 로그인 성공
        	System.out.println("로그인 성공");
            return true;
        } else {
            // 비밀번호가 일치하지 않는 경우, 로그인 실패
            return false;
        }
    }

}
