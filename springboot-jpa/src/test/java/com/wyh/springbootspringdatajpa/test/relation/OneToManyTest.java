package com.wyh.springbootspringdatajpa.test.relation;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wyh.springbootspringdatajpa.SpringBootSpringdatajpaMain;
import com.wyh.springbootspringdatajpa.dao.AccountCrudRepository;
import com.wyh.springbootspringdatajpa.entity.AccountEntity;
import com.wyh.springbootspringdatajpa.entity.ProjectEntity;
import com.wyh.springbootspringdatajpa.test.repository.RepositoryTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootSpringdatajpaMain.class})
public class OneToManyTest extends RepositoryTest {
	
	@Autowired
	private AccountCrudRepository accoutRepository;

	@Test
	public void testSave() {
		//创建一个projcet
		ProjectEntity projectEntity = new ProjectEntity();
		projectEntity.setProjectCode("manage");
		projectEntity.setProjectName("管理系统");
		//创建多个account
		AccountEntity a1 = createEntity("admin", "超级管理员", "666666");
		AccountEntity a2 = createEntity("LYP", "龙艳平", "666666");
		//关联
		a1.setProject(projectEntity);
		a2.setProject(projectEntity);
		//保存
		accoutRepository.saveAll(new ArrayList<AccountEntity>() {
			private static final long serialVersionUID = 1L;

			{
				add(a1);
				add(a2);
			}
		});
	}
	
	@Test
	public void testFind() {
		accoutRepository.findByPassword("666666").forEach((t) -> {
			System.out.println(t);
			System.out.println(t.getProject());
		});
	}
	
}
