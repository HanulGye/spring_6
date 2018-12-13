package com.iu.board.qna;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	@Inject
	private FileDAO fileDAO;
	
	@Override
	public ModelAndView list(Pager pager) throws Exception {
		int totalCount=qnaDAO.totalCount(pager);
		//row
		pager.makeRow();
		//pageing
		pager.makePage(totalCount);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/boardList");
		modelAndView.addObject("list", qnaDAO.list(pager));
		modelAndView.addObject("pager", pager);
		modelAndView.addObject("board", "qna");
		return modelAndView;
		
	}

	@Override
	public ModelAndView select(int num) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		BoardDTO boardDTO = qnaDAO.select(num);
		if(boardDTO!=null) {
			modelAndView.setViewName("board/boardSelect");
			modelAndView.addObject("dto", boardDTO);
		}else {
			modelAndView.setViewName("redirect:./qnaList");
			modelAndView.addObject("msg", "글이 없습니다.");
		}
		modelAndView.addObject("board", "qna");
		return modelAndView;
	}

	@Override
	public ModelAndView insert(BoardDTO boardDTO, HttpSession session, List<MultipartFile> f1) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int num = qnaDAO.getNum();
		int result = qnaDAO.insert(boardDTO);
		if(result<1) {
			throw new Exception();
		}
		FileSaver fileSaver = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/qna");
		for(MultipartFile multipartFile:f1) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fname = fileSaver.saveFile(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(num);
			fileDTO.setFname(fname);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDTO.setKind("q");
			result = fileDAO.insert(fileDTO);
			if(result<1) {
				throw new Exception();
			}
		}
		modelAndView.setViewName("redirect:./qnaList");
		modelAndView.addObject("msg", "WriteSuccess");
		return modelAndView;
	}

	@Override
	public ModelAndView update(BoardDTO boardDTO, HttpSession session, List<MultipartFile> f1) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int result = qnaDAO.update(boardDTO);
		if(result<1) {
			throw new Exception();
		}
		FileSaver fileSaver = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/qna");
		for(MultipartFile multipartFile:f1) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fname = fileSaver.saveFile(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setFname(fname);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDTO.setKind("q");
			result = fileDAO.insert(fileDTO);
			if(result<1) {
				throw new Exception();
			}
		}
		modelAndView.setViewName("redirect:./qnaSelect?num="+boardDTO.getNum());
		modelAndView.addObject("msg", "Update Success");
		return modelAndView;
	}

	@Override
	public ModelAndView delete(int num, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int result = qnaDAO.delete(num);
		if(result<1) {
			throw new Exception();
		}
		FileDTO fileDTO = new FileDTO();
		fileDTO.setNum(num);
		fileDTO.setKind("q");
		List<FileDTO> ar = fileDAO.list(fileDTO);
		
		result = fileDAO.deleteAll(fileDTO);
		if(result<1) {
			throw new Exception();
		}
		
		String realPath = session.getServletContext().getRealPath("resources/qna");
		for(FileDTO fileDTO2:ar) {
			File file = new File(realPath, fileDTO2.getFname());
			file.delete();
		}
		modelAndView.setViewName("redirect:./qnaList");
		modelAndView.addObject("msg", "Delete Success");
		return modelAndView;
		
	}
	
	public ModelAndView reply (QnaDTO qnaDTO, HttpSession session, List<MultipartFile> f1) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		//부모의 ref, step, depth
		
		BoardDTO pDto = qnaDAO.select(qnaDTO.getNum());
		QnaDTO pQnaDTO = (QnaDTO)pDto;
		qnaDAO.replyUpdate(pQnaDTO);
		qnaDTO.setRef(pQnaDTO.getRef());
		qnaDTO.setStep(pQnaDTO.getStep()+1);
		qnaDTO.setDepth(pQnaDTO.getDepth()+1);
		
		int num = qnaDAO.getNum();
		qnaDTO.setNum(num);
		
		int result = qnaDAO.reply(qnaDTO);
		if(result<1) {
			throw new Exception();
		}
		FileSaver fileSaver = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/qna");
		for(MultipartFile multipartFile:f1) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fname = fileSaver.saveFile(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(num);
			fileDTO.setFname(fname);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDTO.setKind("q");
			result = fileDAO.insert(fileDTO);
			if(result<1) {
				throw new Exception();
			}
		}
		
		modelAndView.setViewName("redirect:./qnaList");
		
		return modelAndView;
	}
}










