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
<<<<<<< HEAD

=======
>>>>>>> 1b729a54df47f8f2373d44dbf556bcff662f51d1
=======

>>>>>>> PJH
=======
>>>>>>> ae3dafeb040fae082730416a3df22aa8661a3b11

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
		return "/loginpages/login";
	}
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

=======
	
>>>>>>> 1b729a54df47f8f2373d44dbf556bcff662f51d1
=======

>>>>>>> PJH
=======

>>>>>>> ae3dafeb040fae082730416a3df22aa8661a3b11
	@GetMapping("/board")
	public String board() {
		return "/board";
	}
	@GetMapping("/result_board")
	public String result_board() {
		return "/result_board";
	}
	
	@GetMapping("/account")
	public String account() {
		return "/account";
	}
	
	@GetMapping("/inquery")
	public String inquery() {
		return "/inquery";
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		
	}
	
	
	@GetMapping("/manage")
	public String manageRoom() {
		return "/uploadRoom/uploadRoom_result";
=======
	}
		
=======
	}

>>>>>>> ae3dafeb040fae082730416a3df22aa8661a3b11
	@GetMapping("/manage")
	public String manageRoom() {
		return "/uploadRoom/uploadRoom_result";
	}
<<<<<<< HEAD

>>>>>>> 1b729a54df47f8f2373d44dbf556bcff662f51d1
=======
	}
	
	@GetMapping("/manage")
	public String manageRoom() {
		return "/uploadRoom/uploadRoom_insert";
	}

>>>>>>> PJH
=======
	

>>>>>>> ae3dafeb040fae082730416a3df22aa8661a3b11

}
	
}