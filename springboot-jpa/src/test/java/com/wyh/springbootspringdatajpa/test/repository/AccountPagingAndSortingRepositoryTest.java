package com.wyh.springbootspringdatajpa.test.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wyh.springbootspringdatajpa.SpringBootSpringdatajpaMain;
import com.wyh.springbootspringdatajpa.dao.AccountPagingAndSortingRepository;
import com.wyh.springbootspringdatajpa.entity.AccountEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootSpringdatajpaMain.class})
public class AccountPagingAndSortingRepositoryTest extends RepositoryTest {
	
	@Autowired
	private AccountPagingAndSortingRepository repository;
	
	/**
	 * #排序
	 */
	@Test
	public void testSort() {
		repository.findAll(Sort.by(Direction.DESC, "id")).forEach(System.out::println);;
	}
	
	/**
	 * #分页
	 */
	@Test
	public void testPaging() {
		Page<AccountEntity> page = repository.findAll(PageRequest.of(1, 3, Sort.by(Direction.DESC, "id")));
		System.out.println("总页数:" + page.getTotalPages());
		System.out.println("总条数:" + page.getTotalElements());
		page.getContent().stream().forEach(System.out::println);
	}

}
