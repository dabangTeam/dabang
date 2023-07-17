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

=======
>>>>>>> 1b9df6c1d203f8a38b685c9a0e0a020ce35f1cae
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
		return "/loginpages/emailLogin";
	}
<<<<<<< HEAD
	
=======
>>>>>>> 1b9df6c1d203f8a38b685c9a0e0a020ce35f1cae

}
