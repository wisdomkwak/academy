package com.json.jsonroot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.json.jsonroot.model.BoardVO;

@Service
public class ServiceImpl implements jsonService {
	
	@Autowired
	private DAO dao;
	
	@Override
	public BoardVO get_whereid(int id) throws Exception {
		return dao.get_whereid(id);
	}

	@Override
	public void setInsert(BoardVO b) throws Exception {
		dao.setInsert(b);
	}

	@Override
	public java.util.List<BoardVO> selectall() throws Exception {
		return dao.selectall();
	}
	

}
