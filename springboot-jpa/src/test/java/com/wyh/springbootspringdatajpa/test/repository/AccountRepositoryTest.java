package com.wyh.springbootspringdatajpa.test.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wyh.springbootspringdatajpa.SpringBootSpringdatajpaMain;
import com.wyh.springbootspringdatajpa.dao.AccountRepository;
import com.wyh.springbootspringdatajpa.entity.AccountEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootSpringdatajpaMain.class})
public class AccountRepositoryTest extends RepositoryTest {
	
	@Autowired
	private AccountRepository accountRepository;
	
	/**
	 * Repository接口通过方法名实现查询
	 */
	@Test
	public void testQueryByName() {
		List<AccountEntity> lists = new ArrayList<AccountEntity>(); 
		lists = accountRepository.findAll();
		System.out.println("findAll");
		lists.stream().forEach(System.out::println);
		
		System.out.println("findByChinese-王宇恒");
		lists = accountRepository.findByChinese("王宇恒");
		lists.stream().forEach(System.out::println);
		
		System.out.println("findByChineseAndPassword-王宇恒 111111");
		lists = accountRepository.findByChineseAndPassword("王宇恒", "111111");
		lists.stream().forEach(System.out::println);
		
		System.out.println("findByAccountLike-w%");
		lists = accountRepository.findByAccountLike("w%");
		lists.stream().forEach(System.out::println);
	}
	
	/**
	 * Repository接口通过@Query注解实现查询
	 */
	@Test
	public void testQueryByAnnotation() {
		List<AccountEntity> lists = new ArrayList<AccountEntity>(); 
		System.out.println("queryByAccountHQL-wyh");
		lists = accountRepository.queryByAccountHQL("wyh");
		lists.stream().forEach(System.out::println);
		
		System.out.println("queryByAccountSQL-wyh");
		lists = accountRepository.queryByAccountSQL("wyh");
		lists.stream().forEach(System.out::println);
	}
	
	/**
	 * Repository接口实现更新功能
	 */
	@Test
	@Transactional
	@Rollback(false)
	public void testUpdate() {
		System.out.println("updatePasswordByAccount-147258 wyh");
		accountRepository.updatePasswordByAccount("147258", "wyh");
	}
	
}
