package spring.teamproject.dabang.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping({"/", "/index"})
	public String getPage() {
		return "index";
	}
<<<<<<< HEAD
<<<<<<< HEAD
	
=======
>>>>>>> 6a628feb265ad13ff7da7284ac78200a7df996e0
=======
	
>>>>>>> a0112910fbf8af2cd79cd24093973798660f75f7

	@GetMapping("/search/map")
	public String getSearchMap() {
		return "/menu/search-map";
	}

	@GetMapping("/welcome")
	public String loadLoginStart() {
		return "/loginpages/loginStart";
	}
	
	@GetMapping("/welcome/join")
	public String JoinAgree() {
		return "/loginpages/join";
	}
	
	@GetMapping("/welcome/agree/join")
	public String Join() {
		return "/loginpages/joinAgree";
	}
	
	@GetMapping("/welcome/login")
	public String EmailLogin() {
		return "/loginpages/Login";
	}
<<<<<<< HEAD
<<<<<<< HEAD
	
<<<<<<< HEAD
	@GetMapping("/board")
	public String board() {
		return "/board";
	}
	
	@GetMapping("/account")
	public String account() {
		return "/account";
	}
	
	@GetMapping("/inquery")
	public String inquery() {
		return "/inquery";
=======
	@GetMapping("/manage")
	public String manageRoom() {
		return "/uploadRoom/uploadRoom_result";
>>>>>>> PJH
	}
=======
>>>>>>> 6a628feb265ad13ff7da7284ac78200a7df996e0
=======

>>>>>>> a0112910fbf8af2cd79cd24093973798660f75f7

}
