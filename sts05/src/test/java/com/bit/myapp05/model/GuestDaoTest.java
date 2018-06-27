package com.bit.myapp05.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.bit.myapp05.model.entity.GuestVo;


public class GuestDaoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDataSource() throws SQLException {
		
		Resource resource=new ClassPathResource("applicationContext.xml");
		BeanFactory factory =new XmlBeanFactory(resource);
		
		GuestDao guestDao=(GuestDao) factory.getBean("guestDao");
		assertNotNull(guestDao);
		
		assertNotNull(guestDao.selectAll());
		assertTrue(guestDao.selectAll().size()>0);
		
		for(GuestVo bean : guestDao.selectAll()) {
			System.out.println(bean);
		}
		
	}

}

















