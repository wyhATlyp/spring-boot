package com.wyh.springbootspringdatajpa.test.repository;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wyh.springbootspringdatajpa.SpringBootSpringdatajpaMain;
import com.wyh.springbootspringdatajpa.dao.AccountCrudRepository;
import com.wyh.springbootspringdatajpa.entity.AccountEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootSpringdatajpaMain.class})
public class AccountCrudRepositoryTest extends RepositoryTest {
	
	@Autowired
	private AccountCrudRepository accountCrudRepository;
	
	@Test
	public void testSave() {
		accountCrudRepository.save(createEntity("wc", "王闯", "123456"));
	}
	
	/**
	 * save()方法中如果ID存在则执行更新操作
	 */
	@Test
	public void testUpdate() {
		AccountEntity accountEntity = createEntity("wangchuang", "王闯", "123456");
		accountEntity.setId(21L);
		accountCrudRepository.save(accountEntity);
	}
	
	@Test
	public void testFindById() {
		Optional<AccountEntity> optional = accountCrudRepository.findById(1L);
		System.out.println(optional.get());
	}
	
	@Test
	public void testAll() {
		accountCrudRepository.findAll().forEach(System.out::println);
	}
	
	@Test
	public void testDelete() {
		accountCrudRepository.deleteById(21L);
	}

}
