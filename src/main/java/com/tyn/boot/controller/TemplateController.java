package com.tyn.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {
	
	@GetMapping("/leaf")
	public String leaf(Model model) {
		model.addAttribute("name","hynukee");
		return "leaf";
	}
	@GetMapping("/myPage")
	public String myPage() {
		return "myPage";
	}
	@GetMapping("/helloPage")
	public String helloPage(Model model) {
		return "helloPage";
	}
}
