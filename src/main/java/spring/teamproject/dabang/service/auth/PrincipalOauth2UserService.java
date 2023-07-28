package spring.teamproject.dabang.service.auth;


import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import spring.teamproject.dabang.domain.user.User;
import spring.teamproject.dabang.domain.user.UserRepository;

@RequiredArgsConstructor
@Slf4j
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService{
	
	private final UserRepository userRepository;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("시작");
		
		OAuth2User oAuth2User = super.loadUser(userRequest);
		log.info(">>>> ClientRegistration: {} " + userRequest.getClientRegistration());
		log.info(">>>> oAuth2User: {} ", oAuth2User);
		
		String provider = null;
		ClientRegistration clientRegistration = userRequest.getClientRegistration();
		Map<String, Object> attributes = oAuth2User.getAttributes();
		System.out.println(" >>>>>>>>>>>>>>>>>> !!!!!!!!!!!!!!!!!!!!!!!! attributes" + attributes);
		
		provider = clientRegistration.getClientName();
		log.info(">>> provider: {} " + provider);
		User user = getOAuth2User(provider, attributes);
		
		log.info(">>> user3: {} " + user);
		
		return new PrincipalDetails(user, attributes);
	}
	
	private User getOAuth2User(String provider, Map<String, Object> attributes) throws OAuth2AuthenticationException {
	    User user = null;
	    String oauth2_id = null;
	    String id = null;
	    Map<String, Object> response = null;
	    String email = null; // email 변수를 선언합니다.

	    if (provider.equalsIgnoreCase("kakao")) {
	        response = attributes;
	        System.out.println("attribues" + attributes);
	        System.out.println("response" + response);
	        Map<String, Object> kakaoAccount = (Map<String, Object>) response.get("kakao_account");
	        email = (String) kakaoAccount.get("email");

	        if (email == null) {
	            // 이메일이 없으면 에러 처리
	            throw new OAuth2AuthenticationException("Email not found in Kakao response!");
	        }

	        id = response.get("id").toString();
	        oauth2_id = provider + "_" + id;
	    } else if (provider.equalsIgnoreCase("facebook")) {
	        response = (Map<String, Object>) attributes.get("response");
	        id = (String) response.get("id");
	        oauth2_id = provider + "_" + id;
	    } else {
	        throw new OAuth2AuthenticationException("DATABASE Error!");
	    }
	    

	    try {
	        user = userRepository.findOAuth2UserByUsername(oauth2_id);
	        if (user == null) {
	            // DB에 사용자 정보가 없는 경우, 새로운 사용자로 등록
	            user = User.builder()
	                    .user_email(email)
	                    .user_password(new BCryptPasswordEncoder().encode(id))
	                    .user_checkpassword(new BCryptPasswordEncoder().encode(id))
	                    .oauth2_id(oauth2_id)
	                    .user_roles("ROLE_USER")
	                    .user_provider(provider)
	                    .build();
	            log.info("Before userRepository.save(user)");
	            userRepository.save(user);
	            log.info("After userRepository.save(user)");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new OAuth2AuthenticationException("DATABASE Error");
	    }

//	    // 이메일을 가져왔으므로 이제 아래 코드에서 email 변수를 사용할 수 있습니다.
//	    try {
//	        user = userRepository.findOAuth2UserByUsername(oauth2_id);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        throw new OAuth2AuthenticationException("DATABASE Error!");
//	    }
//
//	    System.out.println(id);
//	    System.out.println(">>>>>>>> response" + response);
//
//
//	    if (user == null) {
//	        // DB에 사용자 정보가 없는 경우, 새로운 사용자로 등록
//	        user = User.builder()
//	                .user_email(email)
//	                .user_password(new BCryptPasswordEncoder().encode(id))
//	                .user_checkpassword(new BCryptPasswordEncoder().encode(id))
//	                .oauth2_id(oauth2_id)
//	                .user_roles("ROLE_USER")
//	                .user_provider(provider)
//	                .build();
//	        try {
//	            userRepository.save(user);
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            throw new OAuth2AuthenticationException("DATABASE Error");
//	        }
//	    }


	    return user;
	}
	

}
