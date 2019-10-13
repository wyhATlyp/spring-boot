package com.wyh.springbootspringdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wyh.springbootspringdatajpa.entity.AccountEntity;

public interface AccountJpaSpecificationExecutorRepository extends JpaSpecificationExecutor<AccountEntity>, JpaRepository<AccountEntity, Long> {

}
