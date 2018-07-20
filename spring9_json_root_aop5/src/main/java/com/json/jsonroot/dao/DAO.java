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
		System.out.println("����� get_whereid() �Դϴ�.");
		return sqlSession.selectOne("select_whereid",id);
	}
	
	public void setInsert(BoardVO b) throws Exception{
		sqlSession.insert("data_insert",b);
		throw new RuntimeException("������ ������ �߻����� insert�� ���� �ʵ��� �մϴ�.!!"); //�ν��͵����� �ѹ��Ŵ
	}
	
	public List<BoardVO> selectall() throws Exception{
		return sqlSession.selectList("select_all");
	}
}
