package com.wyh.springbootspringdatajpa.test.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wyh.springbootspringdatajpa.SpringBootSpringdatajpaMain;
import com.wyh.springbootspringdatajpa.dao.AccountJpaSpecificationExecutorRepository;
import com.wyh.springbootspringdatajpa.entity.AccountEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootSpringdatajpaMain.class})
public class AccountJpaSpecificationExecutorTest {

	@Autowired
	private AccountJpaSpecificationExecutorRepository executor;
	
	@Test
	public void testFind() {
		/**
		 * Specification:规格、规范-封装查询条件
		 */
		Specification<AccountEntity> specification = new Specification<AccountEntity>() {
			private static final long serialVersionUID = 1L;
			/**
			 * return: Predicate：谓语-封装查询条件
			 * @param1 root Root<T>：-封装对象T的属性
			 * @param2 query CriteriaQuery<?>：查询准则-封装数据库关键字(select、from、order)
			 * @param3 CriteriaBuilder：构建准则-用来生成查询条件
			 */
			@Override
			public Predicate toPredicate(Root<AccountEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>() {
					private static final long serialVersionUID = 1L;
					{
						add(cb.equal(root.get("chinese"), "王闯"));
						add(cb.equal(root.get("account"), "wc"));
					}
				};
				Predicate[] p = new Predicate[2];
				return cb.and(list.toArray(p));
			}
		};
		executor.findAll(specification).forEach(System.out::println);
	}
	
	@Test
	public void testSimple() {
		Specification<AccountEntity> specification = new Specification<AccountEntity>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<AccountEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.or(
						cb.and(cb.equal(root.get("chinese"), "王闯"), cb.equal(root.get("account"), "wc")),
						cb.equal(root.get("id"), 1));
			}
		};
		executor.findAll(specification, PageRequest.of(0, 2, Sort.by(Direction.ASC, "id"))).forEach(System.out::println);
	}
	
}
