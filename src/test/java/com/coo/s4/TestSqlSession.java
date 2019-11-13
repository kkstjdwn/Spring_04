package com.coo.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestSqlSession extends TestAbstractCase {
	
	@Inject
	private SqlSession sqlSession;
	
	@Inject
	private DataSource dataSource;
	
	@Test
	public void test() throws Exception{
		assertNotNull(sqlSession);
		
//		assertNotNull(dataSource); // <-- 객체가 생성되는지 안되는지
//		assertNotNull(dataSource.getConnection()); // <-- 연결이 되는지 안되는지 
	}

}
