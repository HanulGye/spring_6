package com.hanul.board.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.util.Pager;

@Service
public class MemoService {

	@Inject
	private MemoDAO memoDAO;
	
	public List<MemoDTO> list(Pager pager) throws Exception{
		pager.makeRow();
		return memoDAO.list(pager);
	}
	
	public MemoDTO select(int num) throws Exception{
		return memoDAO.select(num);
	}
}
