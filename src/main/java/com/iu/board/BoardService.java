package com.iu.board;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.util.Pager;

public interface BoardService {
	
	//list
	public ModelAndView list(Pager pager) throws Exception;
	
	//select
	public ModelAndView select(int num) throws Exception;
	//insert
	public ModelAndView insert(BoardDTO boardDTO, HttpSession session, List<MultipartFile> f1) throws Exception;
	//update
	public ModelAndView update(BoardDTO boardDTO, HttpSession session, List<MultipartFile> f1) throws Exception;
	//delete
	public ModelAndView delete(int num, HttpSession session) throws Exception;

}
