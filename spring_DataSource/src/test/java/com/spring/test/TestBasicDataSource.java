package com.spring.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dto.MemberVO;

/**
 *  DB에 connection이 잘 되는지(ojdbc) 테스트
 *  (다른 요소 다 제외하고 이것만 테스트)
 */
//인스턴스 테스트 : 컨테이너 안에 있는 인스턴스 테스트(인스턴스 사용에 문제가 없는가)
//JUnit 테스트 : 클래스 안에 있는 메서드들 테스트하는 것(잘 만들었는가)
@RunWith(SpringJUnit4ClassRunner.class)
//읽어와서 spring container를 만든다
@ContextConfiguration("classpath:/com/spring/context/root-context.xml")
public class TestBasicDataSource {

	//@Autowired : 스프링에 있는 어노테이션
	//변수 타입(BasicDataSource)을 보고 context(root-context.xml)에 있는 인스턴스를 가져온다(wire=묶다)
	@Autowired
	private BasicDataSource dataSource;
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//(메서드)테스트할때마다 실행한다
	@Before
	public void init() throws SQLException{
		conn = dataSource.getConnection();
	}
	
	//test어노테이션이 있어야 테스트한다
	//메서드명에 어떤 것을 테스트하는지 적을것(테스트 결과에 메서드명이 출력되기 때문)
	@Test
	public void testConnection() throws SQLException{
		Connection conn = this.conn;
		Assert.assertNotEquals(null, conn); //=conn이 null이 아니기를 기대한다
	}
	
	@Test
	public void testSqlInjection() throws SQLException{
		final String id = "mimi";
		
		String sql = "select * from member where id='" + id + "'";
		
		this.stmt = this.conn.createStatement();
		this.rs = this.stmt.executeQuery(sql);
		
		MemberVO member = null;
		if(rs.next()) {
			member = new MemberVO();
			member.setId(rs.getString("id"));
		}
		
		Assert.assertEquals(id, member.getId()); //id가 mimi이길 기대한다
	}
	
	@After
	public void end() throws SQLException{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
	}

}
