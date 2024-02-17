package com.khit.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/resume")
@Controller
public class ResumeController {

	@GetMapping("/main")
	public String resumeMainForm(
		@RequestParam(value="title", required = false) String title,
		@RequestParam(value="name", required = false) String name,
		@RequestParam(value="birthday_year", required = false) String birthday_year,
		@RequestParam(value="birthday_month", required = false) String birthday_month,
		@RequestParam(value="birthday_day", required = false) String birthday_day,
		@RequestParam(value="gender", required = false) String gender,
		@RequestParam(value="phone", required = false) String phone,
		@RequestParam(value="email_prev", required = false) String email_prev,
		@RequestParam(value="email_next", required = false) String email_next,
		@RequestParam(value="zonecode", required = false) String zonecode,
		@RequestParam(value="address", required = false) String address,
		@RequestParam(value="edu_last_prev", required = false) String edu_last_prev,
		@RequestParam(value="edu_last_next", required = false) String edu_last_next,
		@RequestParam(value="edu_detail_prev", required = false) String edu_detail_prev,
		@RequestParam(value="edu_detail_next", required = false) String edu_detail_next,
		@RequestParam(value="career", required = false) String career,
		@RequestParam(value="military", required = false) String military,
		@RequestParam(value="license", required = false) String license,
		@RequestParam(value="certificate", required = false) String certificate,
		@RequestParam(value="language", required = false) String language,
		@RequestParam(value="growth", required = false) String growth,
		@RequestParam(value="specialty", required = false) String specialty,
		@RequestParam(value="exp", required = false) String exp,
		Model model
	) {
		model.addAttribute("title", title); //이력서 제목
		model.addAttribute("name", name);    //이름
		model.addAttribute("birthday_year", birthday_year);   //생년-년도
		model.addAttribute("birthday_month", birthday_month);   //생년-월
		model.addAttribute("birthday_day", birthday_day);   //생년-일
		model.addAttribute("gender", gender); //성별
		model.addAttribute("phone", phone);  //핸드폰 번호
		model.addAttribute("email_prev", email_prev);  //이메일
		model.addAttribute("email_next", email_next);  //이메일
		model.addAttribute("zonecode", zonecode);  //우편 주소
		model.addAttribute("address", address);  //주소
		model.addAttribute("edu_last_prev", edu_last_prev);  //최종학력 앞
		model.addAttribute("edu_last_next", edu_last_next);  //최종학력 뒤
		model.addAttribute("edu_detail_prev", edu_detail_prev);  //상세학력 앞
		model.addAttribute("edu_detail_next", edu_detail_next);  //상세학력 뒤
		model.addAttribute("career", career);  //경력
		model.addAttribute("military", military);  //병력사항
		model.addAttribute("license", license);  //면허증
		model.addAttribute("certificate", certificate);  //자격증
		model.addAttribute("language", language);  //어학능력
		model.addAttribute("growth", growth);  //성장과정
		model.addAttribute("specialty", specialty);  //장단점 및 특기
		model.addAttribute("exp", exp);  //경험 및 경력

		return "resume/main";
	}


}
