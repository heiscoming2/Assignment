package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.ABoardDto;

@Repository
public class ABoardDoaImpl implements ABoardDao{

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ABoardDto> selectList() {
		List<ABoardDto> list = new ArrayList<ABoardDto>();
		
		try {
			list=sqlSession.selectList(NAMESPACE+"selectList");
		} catch (Exception e) {
			System.out.println("[error] : select list");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ABoardDto selectOne(int bno) {
		ABoardDto dto = null;
		
		try {
			dto=sqlSession.selectOne(NAMESPACE+"selectOne", bno);
		} catch (Exception e) {
			System.out.println("[error] : selectOne");
			e.printStackTrace();
		}
		
		
		return dto;
	}

	@Override
	public int insert(ABoardDto dto) {
		int res=0;
		
		try {
			res=sqlSession.insert(NAMESPACE+"insert",dto);
		} catch (Exception e) {
			System.out.println("[error] : insert");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(ABoardDto dto) {
		int res=0;
		try {
			res= sqlSession.update(NAMESPACE+"update",dto);
		} catch (Exception e) {
			System.out.println("[error] : update");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int bno) {
		int res=0;
		try {
			res=sqlSession.delete(NAMESPACE+"delete",bno);
		} catch (Exception e) {
			System.out.println("[error]");
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
}
