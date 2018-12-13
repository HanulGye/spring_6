package com.hanul.animal;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.util.FileSaver;

@Service
public class AnimalService {

	@Inject
	private AnimalDAO animalDAO;
	private ModelAndView modelAndView = new ModelAndView();
	
	
	public ModelAndView insert(AnimalDTO animalDTO, HttpSession session, MultipartFile multipartFile) throws Exception{
		
		
		FileSaver fileSaver = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/animal");
		System.out.println(realPath);
		if(multipartFile.isEmpty()) {
			animalDTO.setFname("animal-01.jpg");
			animalDTO.setOname("animal-01.jpg");
		}else {
			String fname = fileSaver.saveFile(realPath, multipartFile);
			animalDTO.setFname(fname);
			animalDTO.setOname(multipartFile.getOriginalFilename());	
			
		}
		
		
		
		animalDAO.insert(animalDTO);
		modelAndView.setViewName("redirect:./list");
		modelAndView.addObject("msg", "등록 성공");
		return modelAndView;
	}
	
	public ModelAndView select(int num) throws Exception{
		AnimalDTO animalDTO = animalDAO.select(num);
		modelAndView.setViewName("ani/select");
		modelAndView.addObject("dto", animalDTO);
		return modelAndView;
	}
	
	public ModelAndView list() throws Exception{
		List<AnimalDTO> ar = animalDAO.list();
		modelAndView.setViewName("ani/list");
		modelAndView.addObject("list", ar);
		return modelAndView;
	}
}
