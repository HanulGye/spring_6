package com.hanul.board.memo;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.util.Pager;

@Repository
public class MemoDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "memoMapper.";
	
	public List<MemoDTO> list(Pager pager) {
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}
	
	public MemoDTO select(int num) {
		return sqlSession.selectOne(NAMESPACE+"select", num);
	}
	
}
