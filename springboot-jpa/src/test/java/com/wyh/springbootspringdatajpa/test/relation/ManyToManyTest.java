package com.wyh.springbootspringdatajpa.test.relation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wyh.springbootspringdatajpa.SpringBootSpringdatajpaMain;
import com.wyh.springbootspringdatajpa.dao.AccountCrudRepository;
import com.wyh.springbootspringdatajpa.entity.AccountEntity;
import com.wyh.springbootspringdatajpa.entity.RoleEntity;
import com.wyh.springbootspringdatajpa.test.repository.RepositoryTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootSpringdatajpaMain.class)
public class ManyToManyTest extends RepositoryTest {

	@Autowired
	private AccountCrudRepository repository;
	
	@Test
	public void testSave() {
		//创建账户
		AccountEntity a1 = createEntity("admin1", "超级管理员1", "n-n");
		AccountEntity a2 = createEntity("admin2", "超级管理员2", "n-n");
		List<AccountEntity> accounts = new ArrayList<AccountEntity>() {
			private static final long serialVersionUID = 1L;
			{add(a1);add(a2);}
		};
		
		//创建角色
		RoleEntity r1 = new RoleEntity();
		r1.setName("上帝角色");
		RoleEntity r2 = new RoleEntity();
		r2.setName("一般角色");
		List<RoleEntity> roles = new ArrayList<RoleEntity>() {
			private static final long serialVersionUID = 1L;
			{add(r1);add(r2);}
		};
		//关联
		a1.setRoles(roles);
		a2.setRoles(roles);
		
		r1.setAccounts(accounts);
		r2.setAccounts(accounts);
		//保存
		repository.saveAll(accounts);
	}
	
	@Test
	public void testFind() {
		repository.findByPassword("n-n").forEach((t) -> {
			System.out.println(t);
			t.getRoles().forEach(System.out::println);
		});
	}
	
}
