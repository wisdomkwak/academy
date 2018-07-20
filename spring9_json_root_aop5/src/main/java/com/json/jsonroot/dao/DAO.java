package com.json.jsonroot.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.json.jsonroot.model.BoardVO;

@Repository
public class DAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public BoardVO get_whereid(int id) throws Exception{
		System.out.println("여기는 get_whereid() 입니다.");
		return sqlSession.selectOne("select_whereid",id);
	}
	
	public void setInsert(BoardVO b) throws Exception{
		sqlSession.insert("data_insert",b);
		throw new RuntimeException("강제로 오류를 발생시켜 insert가 되지 않도록 합니다.!!"); //인스터됫지만 롤백시킴
	}
	
	public List<BoardVO> selectall() throws Exception{
		return sqlSession.selectList("select_all");
	}
}
