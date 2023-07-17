package spring.teamproject.dabang.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping({"/", "/index"})
	public String getPage() {
		return "index";
	}
	
	@GetMapping("/search/map")
	public String getSearchMap() {
		return "/menu/search-map";
	}
}
