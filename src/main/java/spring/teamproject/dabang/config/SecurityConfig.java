package spring.teamproject.dabang.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import lombok.RequiredArgsConstructor;
import spring.teamproject.dabang.config.auth.AuthFailureHandler;
import spring.teamproject.dabang.service.auth.PrincipalOauth2UserService;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final PrincipalOauth2UserService principalOauth2UserService;
	
	 @Bean public BCryptPasswordEncoder passwordEncoder() { 
		 return new BCryptPasswordEncoder(); 
		 }
	 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
		
			http.authorizeRequests()
					.antMatchers("/api/v1/grant/test/user/**")
					.access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
					
					.antMatchers("/api/v1/grant/test/manager/**")
					.access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
					
					.antMatchers("/api/v1/grant/test/admin/**")
					.access("hasRole('ROLE_ADMIN')")
					
					.antMatchers("/", "/index")
					.authenticated()
					.anyRequest()
					.permitAll()
					.and()							
					.formLogin()						//5) 로그인 방식은 form 로그인을 사용하겠다
					.loginPage("/welcome/login")
					.loginProcessingUrl("/welcome/login")
					.defaultSuccessUrl("/index")
					.failureHandler(new AuthFailureHandler())
					
					.and()
					.oauth2Login()
					.userInfoEndpoint()
					.userService(principalOauth2UserService)
					.and()
					.defaultSuccessUrl("/index")
					
					 .and()
		                .rememberMe()
		                .rememberMeParameter("custom-remember-me") // Remember Me 파라미터의 이름을 변경할 수 있습니다. 기본값은 "remember-me"
		                .tokenValiditySeconds(60) // 로그인 유지 시간을 초 단위로 설정합니다. 여기서는 7일을 설정한 예시입니다.
		                .rememberMeServices(tokenBasedRememberMeServices()); // Remember Me 기능에 사용할 RememberMeServices 빈을 설정합니다.
			 	
				
		}
	
		// RememberMeServices 빈을 등록합니다.
	    public TokenBasedRememberMeServices tokenBasedRememberMeServices() {
	        TokenBasedRememberMeServices rememberMeServices = new TokenBasedRememberMeServices("your-secret-key", userDetailsService());
	        return rememberMeServices;
	    }
}
