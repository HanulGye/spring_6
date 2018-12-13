package com.iu.s6;

import java.util.Enumeration;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.iu.file.FileService;

@Controller
@RequestMapping(value="/file/**")
public class FileController {
	
	@Inject
	private FileService fileService;
	
	@RequestMapping(value="delete")
	public ModelAndView delete(int fnum) throws Exception {
		ModelAndView mv= fileService.delete(fnum);
		return mv;
	}
	
	@RequestMapping(value="photoUpload",method=RequestMethod.POST)
	public void se2(MultipartHttpServletRequest request) {
		 
		Enumeration<Object> en = request.getParameterNames();
		 
		 while(en.hasMoreElements()) {
			 String name=(String)en.nextElement();
			 System.out.println(name);
		 }
		 
		 
		
	}

}
