package com.iu.s6;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hanul.board.memo.MemoDTO;
import com.hanul.board.memo.MemoService;
import com.iu.util.Pager;

//@Controller
@RestController
//restController : return 을 json으로 받기 위한 annotation (resonseBody) 메서드에 자동으로 붙이는 컨트롤러 
@RequestMapping("/memo/**")
public class MemoController {

	@Inject
	private MemoService memoService;
	
	@RequestMapping(value="memoList", method=RequestMethod.GET)
	public void memoList() throws Exception {}
	
	@RequestMapping(value="zzzz")
	public ModelAndView list(Pager pager)throws Exception{
		List<MemoDTO> ar =  memoService.list(pager);
		ModelAndView modelAndView = new ModelAndView();
		String result = "["; 
		result = result+"{\"writer\": \""+ar.get(0).getWriter()+"\", \"contents\": \""+ar.get(0).getContents()+"\"}";
		result = result+"]";
		//위는 직접 json 형태로 만들어서 보내는 방식.(너무 복잡하기에 쓰지 않음)

		JSONArray array = new JSONArray();
		
		for(int i=0;i<ar.size();i++) {
			JSONObject obj = new JSONObject();
			obj.put("writer", ar.get(i).getWriter());
			obj.put("contents", ar.get(i).getContents());
			array.add(obj);
		}
		//위는 simple json library 사용하여 data 담아준 형태 
		
		
		
		
		modelAndView.addObject("data", array);
		modelAndView.setViewName("common/list");
		return modelAndView;
	}
	@RequestMapping(value="list")
	//@ResponseBody
	public List<MemoDTO> list2(Pager pager) throws Exception{
		List<MemoDTO> ar =  memoService.list(pager);
		return ar;
	}
	
	@RequestMapping(value="select")
	//@ResponseBody
	public MemoDTO select(int num) throws Exception{
		MemoDTO memoDTO = memoService.select(num);
		return memoDTO;
	}
	
	@RequestMapping(value="jtest1")
	//@ResponseBody
	public Map<String, MemoDTO> jtest1() throws Exception{
		Map<String, MemoDTO> map = new HashMap<String, MemoDTO>();
		MemoDTO memoDTO = new MemoDTO();
		memoDTO.setNum(1);
		map.put("f1", memoDTO);
		memoDTO = new MemoDTO();
		memoDTO.setNum(2);
		map.put("f2", memoDTO);
		return map;	
	}
	
	@RequestMapping(value="jtest2")
	@ResponseBody
	public int jtest2() throws Exception{
		return 10;
	} 
	
}
