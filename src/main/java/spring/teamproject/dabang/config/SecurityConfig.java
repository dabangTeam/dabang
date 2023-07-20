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

import lombok.RequiredArgsConstructor;
import spring.teamproject.dabang.config.auth.AuthFailureHandler;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	/*
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */

	
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
					.failureHandler(new AuthFailureHandler());
			 	
				
		}
}
