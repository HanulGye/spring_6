package com.iu.s6;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hanul.animal.AnimalDTO;
import com.hanul.animal.AnimalService;

@Controller
@RequestMapping(value="/ani/**")
public class AnimalController {
	
	@Inject
	private AnimalService animalService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list() throws Exception{
		ModelAndView modelAndView = animalService.list();
		return modelAndView;
	}
	
	@RequestMapping(value="write", method=RequestMethod.GET)
	public ModelAndView writeForm(ModelAndView modelAndView) throws Exception{
		modelAndView.setViewName("ani/write");
		return modelAndView;
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public ModelAndView write(AnimalDTO animalDTO, HttpSession session, MultipartFile multipartFile) throws Exception{
		ModelAndView modelAndView = animalService.insert(animalDTO,session,multipartFile);
		return modelAndView;
	}
	
	@RequestMapping(value="select", method=RequestMethod.GET)
	public ModelAndView select(int num) throws Exception{
		ModelAndView modelAndView = animalService.select(num);
		return modelAndView;
	}
	
}
