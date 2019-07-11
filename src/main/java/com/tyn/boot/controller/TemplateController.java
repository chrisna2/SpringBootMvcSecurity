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
}
