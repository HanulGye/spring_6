package com.iu.member;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class MemberService {
	@Inject
	private MemberDAO memberDAO;
	
	public ModelAndView join(MemberDTO memberDTO)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		int result = memberDAO.join(memberDTO);
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}
	
	public ModelAndView idCheck(String id)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		String resultId = memberDAO.idCheck(id);
		// 0 -> 중복아님 / 1 -> 중복
		int result = 0;
		
		if(resultId!=null) {
			result = 1;
		}
		
		modelAndView.addObject("result", result);
		
		return modelAndView;
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return memberDAO.login(memberDTO);
	}
	
	public int update(MemberDTO memberDTO) throws Exception{
		return memberDAO.update(memberDTO);
	}
	
	public int delete(String id) throws Exception{
		return memberDAO.delete(id);
	}

}
