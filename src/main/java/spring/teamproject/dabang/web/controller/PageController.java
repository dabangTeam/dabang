package spring.teamproject.dabang.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

	@GetMapping({"/", "/index"})
	public String getPage() {
		return "/index";
	}

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
	}

	@GetMapping("/manage")
	public String manageRoom() {
		return "/uploadRoom/uploadRoom_insert";
	}
	
	@GetMapping("/manage/{roomCode}")
	public String manageRoom_update(@PathVariable int roomCode, Model model) {
		model.addAttribute("roomCode", roomCode);
		return "/uploadRoom/uploadRoom_update";
	}
	
	@GetMapping("/manage_result/{roomCode}")
	public String manageRoom_result(@PathVariable int roomCode, Model model) {
		model.addAttribute("roomCode", roomCode);
		return "/uploadRoom/uploadRoom_result";
	}
	
	@GetMapping("/roomInfo")
	public String getRoomInfo() {
		return "/menu/room-info";
	}
	
	@GetMapping("/room/interest")
	public String getRoomInterest() {
		return "/list/interest-list";
	}
	
}