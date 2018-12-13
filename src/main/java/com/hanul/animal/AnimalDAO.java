package com.hanul.animal;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class AnimalDAO {

	@Inject
	private SqlSession sqlSession;
	private String NAMESPACE = "animalMapper.";
	
	public int insert(AnimalDTO animalDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"insert", animalDTO);
	}
	
	public AnimalDTO select(int num) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"select", num);
	}
	
	public List<AnimalDTO> list() throws Exception{
		return sqlSession.selectList(NAMESPACE+"list");
	}
}
