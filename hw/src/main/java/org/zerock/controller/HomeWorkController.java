package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.HomeWorkVO;
import org.zerock.service.HomeWorkService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@RequiredArgsConstructor
public class HomeWorkController {
	private final HomeWorkService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(HomeWorkVO home, RedirectAttributes rttr) {
		log.info("register");
		service.register(home);
		rttr.addFlashAttribute("result", home.getId());
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(Long id, Model model) {
		log.info("/get or modify");
		HomeWorkVO HomeWorkVO = service.get(id);
		model.addAttribute("home", HomeWorkVO);
	}
	
	@PostMapping("/remove")
	public String remove(Long id, RedirectAttributes rttr) {
		log.info("remove");
		
		if(service.remove(id)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(HomeWorkVO home, RedirectAttributes rttr) {
		log.info("modify");
		
		if(service.modify(home)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
}
