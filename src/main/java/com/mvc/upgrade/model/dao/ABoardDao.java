package com.mvc.upgrade.model.dao;

import java.util.List;

import com.mvc.upgrade.model.dto.ABoardDto;

public interface ABoardDao {

	String NAMESPACE = "aboard.";
	
	public List<ABoardDto> selectList();
	public ABoardDto selectOne(int bno);
	public int insert(ABoardDto dto);
	public int update(ABoardDto dto);
	public int delete(int bno);
}
