package com.jsp.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jsp.dto.MemberVO;
import com.jsp.ibatis.config.SqlMapClientFactory;

public class MemberDaoImpl implements MemberDao {

	private static MemberDaoImpl dao;
	private SqlMapClient client;
	
	private MemberDaoImpl(){
		client = SqlMapClientFactory.getSMClient();
	}
	
	public static MemberDaoImpl getInstance() {
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}
	
	@Override
	public MemberVO memData(String id) {
		MemberVO getVo = null;
		try {
			getVo = (MemberVO) client.queryForObject("login.memData", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getVo;
	}

}
