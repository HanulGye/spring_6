package com.iu.file;

import java.net.URLEncoder;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.iu.util.FileSaver;

@Service
public class FileService {
	@Inject
	private FileDAO fileDAO;
	
	public ModelAndView delete(int fnum)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = fileDAO.delete(fnum);
		mv.setViewName("common/result");
		mv.addObject("result", result);
		return mv;
	}
	
	public String se2(PhotoDTO photoDTO, HttpSession session) throws Exception{
		String realPath = session.getServletContext().getRealPath("resources/upload");
		FileSaver fileSaver = new FileSaver();
		String fname=fileSaver.saveFile(realPath, photoDTO.getFiledata());
		
		
		String contextName = session.getServletContext().getContextPath();
		String result = "&bNewLine=true&sFileName="+URLEncoder.encode(photoDTO.getFiledata().getOriginalFilename(), "UTF-8");
		result = result+"&sFileURL="+contextName+"/resources/upload/"+URLEncoder.encode(fname, "UTF-8");
		//URLEncoder - 파일명을 utf-8로 인코딩
		
		return "redirect:"+photoDTO.getCallback()+"?callback_func="+photoDTO.getCallback_func()+result;
	}

}
