package com.wyh.springbootspringdatajpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyh.springbootspringdatajpa.entity.AccountEntity;

public interface AccountCrudRepository extends CrudRepository<AccountEntity, Long> {
	
	public List<AccountEntity> findByPassword(String password);

}
