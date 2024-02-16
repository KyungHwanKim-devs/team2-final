package com.khit.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/resume")
@Controller
public class ResumeController {
	
	@GetMapping("/main")
	public String resumeMainForm() {
		return "resume/main";
	}

}
