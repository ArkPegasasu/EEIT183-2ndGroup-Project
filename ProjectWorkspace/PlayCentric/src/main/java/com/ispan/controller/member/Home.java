package com.ispan.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

	@GetMapping("/Home")
	public String processAction() {
		return "member/home";
	}
}
