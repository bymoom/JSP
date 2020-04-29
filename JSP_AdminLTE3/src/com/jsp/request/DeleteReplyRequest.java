package com.jsp.request;

import java.util.Date;

import com.jsp.dto.ReplyVO;

public class DeleteReplyRequest {

	/**
	 * 댓글 삭제할때는 rno만 필요하기 때문에 toReplyVO 메소드 안 만듦
	 */
	private int bno; //페이징 설정하기 위해 값 받음
	private int rno;
	private int page; //페이징 설정하기 위해 값 받음
	
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
