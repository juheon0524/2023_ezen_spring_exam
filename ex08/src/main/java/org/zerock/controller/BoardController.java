package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@RequiredArgsConstructor
public class BoardController {

	private final BoardService service;

	@GetMapping("/list")
	public void list(Model model) {
		log.info("list >> ");
		model.addAttribute("list", service.getList());

	}

	@GetMapping("/register")
	public void register() {

	}

	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("register : " + vo);

		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());

		return "redirect:/board/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(Long bno, Model model) {
		log.info("/get or modify");
		BoardVO boardVO = service.get(bno);
		model.addAttribute("board", boardVO);
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		log.info("remove");
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board,RedirectAttributes rttr) {
		log.info("modify");
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

}
