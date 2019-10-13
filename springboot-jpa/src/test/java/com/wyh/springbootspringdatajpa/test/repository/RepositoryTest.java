package com.wyh.springbootspringdatajpa.test.repository;

import java.sql.Timestamp;

import com.wyh.springbootspringdatajpa.entity.AccountEntity;

public class RepositoryTest {
	
	public AccountEntity createEntity(String account, String chinese, String password) {
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setAccount(account);
		accountEntity.setChinese(chinese);
		accountEntity.setPassword(password);
		accountEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
		return accountEntity;
	}
	
}
