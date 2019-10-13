package com.wyh.springbootspringdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wyh.springbootspringdatajpa.entity.AccountEntity;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {

}
