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
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {

	private final BoardService boardService;


    @GetMapping("/noti")
	public String boardListForm(
			@RequestParam(name = "keyword", required = false) String keyword,
			@PageableDefault(page = 1) Pageable pageable,
			Model model) {
		Page<Noti> notiList = null;
		if (keyword != null) {
			notiList = boardService.findNotiListByKeyword(keyword, pageable);
		} else {
			notiList = boardService.findNotiListAll(pageable);
		}

		int blockLimit = 10;
		int startPage = ((int)(Math.ceil((double)pageable.getPageNumber()/blockLimit))-1)*blockLimit+1;
		int endPage = (startPage+blockLimit-1) > notiList.getTotalPages() ?
				notiList.getTotalPages() : startPage+blockLimit-1;
		endPage = Math.max(endPage, startPage);

		model.addAttribute("notiList", notiList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("keyword", keyword);
		return "board/noti";
	}
	@GetMapping("/qna")
	public String boardQnaForm(
			@RequestParam(name = "keyword", required = false) String keyword,
			@PageableDefault(page = 1) Pageable pageable,
			Model model) {

		Page<Qna> qnaList = null;
		if (keyword != null) {
			qnaList = boardService.findQnaListByKeyword(keyword, pageable);
		} else {
			qnaList = boardService.findQnaListAll(pageable);
		}

		int blockLimit = 10;
		int startPage = ((int)(Math.ceil((double)pageable.getPageNumber()/blockLimit))-1)*blockLimit+1;
		int endPage = (startPage+blockLimit-1) > qnaList.getTotalPages() ?
				qnaList.getTotalPages() : startPage+blockLimit-1;
		endPage = Math.max(endPage, startPage);

		log.info("qnaList : " + qnaList );

		model.addAttribute("qnaList", qnaList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("keyword", keyword);
		return "board/qna";
	}

	@GetMapping("/free")
	public String boardFreeForm(
			@RequestParam(name = "keyword", required = false) String keyword,
			@PageableDefault(page = 1) Pageable pageable,
			Model model
	) {
		Page<Free> freeList = null;
		if (keyword != null) {
			freeList = boardService.findFreeListByKeyword(keyword, pageable);
		} else {
			freeList = boardService.findFreeListAll(pageable);
		}

		int blockLimit = 10;
		int startPage = ((int)(Math.ceil((double)pageable.getPageNumber()/blockLimit))-1)*blockLimit+1;
		int endPage = (startPage+blockLimit-1) > freeList.getTotalPages() ?
				freeList.getTotalPages() : startPage+blockLimit-1;
		endPage = Math.max(endPage, startPage);

		log.info("freeList : " + freeList );

		model.addAttribute("freeList", freeList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("keyword", keyword);
		return "board/free";
	}
//	@GetMapping("/detail/{id}")
	@GetMapping("/detail/{id}")
	public String boardDetailForm(
			@PageableDefault(page = 1) Pageable pageable,
			@RequestParam(name = "boardType", required = false) String boardType,
			@PathVariable Long id,
			Model model
	) {
		model.addAttribute("boardType", boardType);
        switch (boardType) {
            case "free" -> {
                Free free = boardService.findFreeById(id);
                model.addAttribute("board", free);
            }
            case "qna" -> {
                Qna qna = boardService.findQnaById(id);
                model.addAttribute("board", qna);
            }
            case "noti" -> {
                Noti noti = boardService.findNotiById(id);
                model.addAttribute("board", noti);	
            }
            case "review" -> {
                Review review = boardService.findReviewById(id);
                model.addAttribute("board", review);
            }
        }
		return "board/detail";
	}
	@GetMapping("/write")
	public String boardWriteForm(
			Model model,
			@RequestParam(name = "boardType") String boardType
	) {
		model.addAttribute("boardType", boardType);
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
