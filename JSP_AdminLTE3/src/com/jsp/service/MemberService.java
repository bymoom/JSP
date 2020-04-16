package com.jsp.service;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;

public interface MemberService {

	//dao는 쿼리문 단위로 메서드 만들기
	//service는 기능 단위로 메서드 만들기
	
	//로그인 (NotFoundIDException, InvalidPasswordException : 직접 만들었음)
	void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException;
	
	//회원 리스트 조회
	List<MemberVO> getMemberList() throws SQLException;
	
	//회원 정보 조회
	MemberVO getMember(String id) throws SQLException;
	
	//회원 등록
	void regist(MemberVO member) throws SQLException;
	
	//회원 수정
	void modify(MemberVO member) throws SQLException;
	
	//회원 삭제
	void remove(String id) throws SQLException;
	
	//회원 정지
	void disabledMember(String id) throws SQLException;
	
	//회원 활성화
	void enabledMember(String id) throws SQLException;
	
}
