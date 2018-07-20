package com.json.jsonroot.action;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.json.jsonroot.dao.jsonService;
import com.json.jsonroot.model.BoardVO;

@Controller
public class JsonAction {

	@Autowired
	private jsonService service;

	@RequestMapping(value = "/start2")
	public ModelAndView start() {
		ModelAndView a = new ModelAndView();
		a.setViewName("start2");
		return a;
	}

	/*
	 * @ResponseBody�� jackson�� �̿��Ͽ� JSON ����ϱ�
	 * 
	 * @ResponseBody��? �޼��忡 @ResponseBody Annotation�� �Ǿ� ������ return�Ǵ� ���� View�� ���ؼ�
	 * ��µǴ� ���� �ƴ϶� HTTP Response Body�� ���� �������� �˴ϴ�.
	 */

	@RequestMapping(value = "/jsontest3")
	@ResponseBody
	public Object jsonTest3() throws Exception {
		List<BoardVO> li = new ArrayList<BoardVO>();
		li = service.selectall(); // select * from products order by id
		return li;
	}

	@RequestMapping(value = "/jsontest2")
	@ResponseBody
	public Object insert_ok(BoardVO save)throws Exception {
		service.setInsert(save); //�����մϴ�.
		
		//select * from products where id = #{id}
		save = service.get_whereid(save.getId());
		return save;
		
	}

}
