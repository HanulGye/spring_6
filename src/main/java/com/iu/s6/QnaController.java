package com.iu.s6;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.qna.QnaDTO;
import com.iu.board.qna.QnaService;
import com.iu.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {

	@Inject
	QnaService qnaService;
	
	@RequestMapping(value="qnaList")
	public ModelAndView list(Pager pager) throws Exception{
		ModelAndView modelAndView = qnaService.list(pager);
		return modelAndView;
	}
	
	@RequestMapping(value="qnaSelect")
	public ModelAndView select(int num) throws Exception{
		ModelAndView modelAndView = qnaService.select(num);
		return modelAndView;
	}
	
	@RequestMapping(value="qnaWrite", method=RequestMethod.GET)
	public ModelAndView writeForm(ModelAndView modelAndView) {
		modelAndView.addObject("board", "qna");
		modelAndView.setViewName("board/boardWrite");
		return modelAndView;
	}
	
	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public ModelAndView writeProcess(BoardDTO boardDTO, HttpSession session, List<MultipartFile> f1) throws Exception {
		ModelAndView modelAndView = qnaService.insert(boardDTO, session, f1);
		return modelAndView;
	}
	
	@RequestMapping(value="qnaUpdate", method=RequestMethod.GET)
	public ModelAndView updateForm(int num) throws Exception{
		ModelAndView modelAndView = qnaService.select(num);
		modelAndView.setViewName("board/boardUpdate");
		return modelAndView;
	}
	
	@RequestMapping(value="qnaUpdate", method=RequestMethod.POST)
	public ModelAndView updateProcess(BoardDTO boardDTO, HttpSession session, List<MultipartFile> f1) throws Exception{
		ModelAndView modelAndView =  qnaService.update(boardDTO, session, f1);
		return modelAndView;
	}
	
	@RequestMapping(value="qnaDelete", method=RequestMethod.POST)
	public ModelAndView delete(int num, HttpSession session) throws Exception {
		ModelAndView modelAndView =  qnaService.delete(num, session);
		return modelAndView;
	}
	
	@RequestMapping(value="qnaReply", method=RequestMethod.GET)
	public ModelAndView replyForm(ModelAndView modelAndView, int num) {
		modelAndView.addObject("board", "qna");
		modelAndView.addObject("num", num);
		modelAndView.setViewName("board/boardReply");
		return modelAndView;
	}
	
	@RequestMapping(value="qnaReply", method=RequestMethod.POST)
	public ModelAndView replyProcess(QnaDTO qnaDTO, HttpSession session, List<MultipartFile> f1) throws Exception{
		ModelAndView modelAndView =  qnaService.reply(qnaDTO, session, f1);
		return modelAndView;
	}
}
