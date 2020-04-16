package com.jsp.service;


import com.jsp.dao.MemberDaoImpl;
import com.jsp.dto.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDaoImpl dao;
	private static MemberServiceImpl service;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}
	
	@Override
	public MemberVO memData(String id) {
		return dao.memData(id);
	}
	
}
