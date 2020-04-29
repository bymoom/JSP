package com.jsp.utils;

import javax.servlet.http.HttpServletRequest;

import com.jsp.request.PageMaker;
import com.jsp.request.SearchCriteria;

public class CreatePageMaker {

	public static PageMaker make(HttpServletRequest request) throws Exception{
		
		int page = Integer.parseInt(request.getParameter("page"));
		int perPageNum = Integer.parseInt(request.getParameter("perPageNum"));
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		PageMaker pageMaker = new PageMaker();
		SearchCriteria cri = new SearchCriteria();
		
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		
		if(searchType != null && keyword != null) {
			cri.setSearchType(searchType);
			cri.setKeyword(keyword);
		}
		
		pageMaker.setCri(cri);
		
		return pageMaker;
		
	}
}
