package com.jsp.ibatis.config;

import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * Mapper(member.xml)의 sql문을 수행하기 위해서 SqlMapClient 객체를 생성한다.
 * SqlMapClient 객체 생성시 환경설정파일(SqlMapConfig.xml)을 재료로 한다.
 */
public class SqlMapClientFactory {
	
	private static SqlMapClient smc;
	
	static {
		try {
			//1-1. xml문서 읽어오기
			//설정파일의 인코딩 설정
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("com/jsp/ibatis/config/SqlMapConfig.xml"); //ibatis가 사용할 기능들이 들어있는 파일
			
			//1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체(sqlMapClient) 생성
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		}catch(Exception ex){ }
	}
	
	//dao에서 사용할 수 있도록 smc를 리턴한다.
	public static SqlMapClient getSMClient(){
		return smc;
	}
	
}
