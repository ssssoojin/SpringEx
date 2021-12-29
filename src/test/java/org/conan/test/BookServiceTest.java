package org.conan.test;

import static org.junit.Assert.assertNotNull;

import org.conan.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BookServiceTest {
	@Setter(onMethod_={@Autowired})
	private BookService service;
	
	@Test
	public void textExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testgetList() {
		log.info(service.getList().size());
	}
	
}
