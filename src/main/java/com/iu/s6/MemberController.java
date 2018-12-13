package com.iu.s6;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {

	@Inject
	MemberService memberService;
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public ModelAndView joinForm(ModelAndView modelAndView) {
		modelAndView.setViewName("member/join");
		return modelAndView;
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public ModelAndView joinProcess(MemberDTO memberDTO, ModelAndView modelAndView) throws Exception{
		modelAndView =  memberService.join(memberDTO);
		return modelAndView;
		
	}
	
	@RequestMapping(value="idCheck", method=RequestMethod.GET)
	public ModelAndView idcheck(String id) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", memberService.idCheck(id));
		modelAndView.setViewName("member/join");
		return modelAndView;
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView loginForm(ModelAndView modelAndView) {
		modelAndView.setViewName("member/login");
		return modelAndView;
	}
	
}
