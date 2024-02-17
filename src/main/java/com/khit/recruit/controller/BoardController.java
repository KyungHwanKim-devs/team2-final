package com.khit.recruit.controller;

import com.khit.recruit.entity.Free;
import com.khit.recruit.entity.Noti;
import com.khit.recruit.entity.Qna;
import com.khit.recruit.entity.Review;
import com.khit.recruit.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {

	private final BoardService boardService;


    @GetMapping("/noti")
	public String boardListForm(
			@PageableDefault(page = 1) Pageable pageable,
			Model model) {

		Page<Noti> 	notiList = boardService.findNotiListAll(pageable);

		log.info("notiList : " + notiList );

		int blockLimit = 10;
		int startPage = ((int)(Math.ceil((double)pageable.getPageNumber()/blockLimit))-1)*blockLimit+1;
		int endPage = (startPage+blockLimit-1) > notiList.getTotalPages() ?
				notiList.getTotalPages() : startPage+blockLimit-1;
		endPage = Math.max(endPage, startPage);

		model.addAttribute("notiList", notiList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		return "board/noti";
	}
	@GetMapping("/qna")
	public String boardQnaForm(
			@PageableDefault(page = 1) Pageable pageable,
							   Model model) {

		Page<Qna> qnaList = boardService.findQnaListAll(pageable);

		log.info("qnaList : " + qnaList );

		int blockLimit = 10;
		int startPage = ((int)(Math.ceil((double)pageable.getPageNumber()/blockLimit))-1)*blockLimit+1;
		int endPage = (startPage+blockLimit-1) > qnaList.getTotalPages() ?
				qnaList.getTotalPages() : startPage+blockLimit-1;
		endPage = Math.max(endPage, startPage);

		model.addAttribute("qnaList", qnaList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		return "board/qna";
	}

	@GetMapping("/free")
	public String boardFreeForm(
			@PageableDefault(page = 1) Pageable pageable,
			Model model
	) {
		Page<Free> freeList = boardService.findFreeListAll(pageable);

		log.info("freeList : " + freeList );

		int blockLimit = 10;
		int startPage = ((int)(Math.ceil((double)pageable.getPageNumber()/blockLimit))-1)*blockLimit+1;
		int endPage = (startPage+blockLimit-1) > freeList.getTotalPages() ?
				freeList.getTotalPages() : startPage+blockLimit-1;
		endPage = Math.max(endPage, startPage);

		model.addAttribute("freeList", freeList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		return "board/free";
	}
	@GetMapping("/detail")
	public String boardDetailForm() {
		return "board/detail";
	}
	@GetMapping("/write")
	public String boardWriteForm(
			Model model,
			@RequestParam(name = "boardType") String boardType
	) {
		switch (boardType) {
			case "free":
				model.addAttribute("board", new Free());
				break;
			case "qna":
				model.addAttribute("board", new Qna());
				break;
			case "noti":
				model.addAttribute("board", new Noti());
				break;
		}
		return "board/write";
	}

	@PostMapping("/write")
	public String boardWritePost(
			Noti noti,
			Qna qna,
			Free free,
			BindingResult bindingResult
	) {
		log.info("noti : " + noti.toString());
		log.info("qna : " + qna.toString());
		log.info("Free : " + free.toString());
		if (bindingResult.hasErrors()) {
			log.info("has errors....." + bindingResult.toString());
			return "board/write";
		}
		try {
			boardService.notiSave(noti);
		} catch (Exception e) {
			log.info("notiSave error....." + e.getMessage());
			return "board/write";
		}
		return "redirect:/board/noti";
	}

}
