package com.khit.recruit.controller;

import com.khit.recruit.entity.Noti;
import com.khit.recruit.entity.Review;
import com.khit.recruit.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@RequestMapping("/rboard")
@RequiredArgsConstructor
@Controller
public class RBoardController {

	private final BoardService boardService;
	
	@GetMapping("/list")
	public String boardListForm(
			@PageableDefault(page = 1) Pageable pageable,
			Model model
	) {
		Page<Review> reviewList = boardService.findReviewListAll(pageable);

		log.info("reviewList : " + reviewList );

		int blockLimit = 10;
		int startPage = ((int)(Math.ceil((double)pageable.getPageNumber()/blockLimit))-1)*blockLimit+1;
		int endPage = (startPage+blockLimit-1) > reviewList.getTotalPages() ?
				reviewList.getTotalPages() : startPage+blockLimit-1;
		endPage = Math.max(endPage, startPage);

		model.addAttribute("reviewList", reviewList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		return "rboard/list";
	}
	@GetMapping("/detail")
	public String boardDetailForm() {
		return "rboard/detail";
	}
	@GetMapping("/write")
	public String boardWriteForm() {
		return "rboard/write";
	}

}
