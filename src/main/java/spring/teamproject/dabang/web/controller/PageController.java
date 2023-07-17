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
	@GetMapping("/search/map")
	public String getSearchMap() {
		return "/menu/search-map";
	}
=======
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
		return "/loginpages/emailLogin";
	}
	
>>>>>>> b86b8bfbc9dee84f8dcce1ecfe263d337f40991c
}
