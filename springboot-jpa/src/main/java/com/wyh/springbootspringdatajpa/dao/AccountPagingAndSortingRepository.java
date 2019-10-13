package com.wyh.springbootspringdatajpa.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wyh.springbootspringdatajpa.entity.AccountEntity;

public interface AccountPagingAndSortingRepository extends PagingAndSortingRepository<AccountEntity, Long> {

}
