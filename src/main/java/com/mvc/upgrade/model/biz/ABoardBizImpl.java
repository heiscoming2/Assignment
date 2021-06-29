package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mvc.upgrade.model.dao.ABoardDao;
import com.mvc.upgrade.model.dto.ABoardDto;

public class ABoardBizImpl implements ABoardBiz{
	@Autowired
	private ABoardDao dao;

	@Override
	public List<ABoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public ABoardDto selectOne(int bno) {
		return dao.selectOne(bno);
	}

	@Override
	public int insert(ABoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(ABoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int bno) {
		return dao.delete(bno);
	}

}
