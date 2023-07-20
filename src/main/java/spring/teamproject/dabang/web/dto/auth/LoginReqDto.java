package spring.teamproject.dabang.web.dto.auth;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;


@Data
public class LoginReqDto {
	
	    @NotBlank(message = "이메일 주소를 입력해주세요.")
	    @Email(message = "올바른 이메일 주소를 입력해주세요.")
	    private String email;

	    @NotBlank(message = "비밀번호를 입력해주세요.")
	    private String password;

	

}
