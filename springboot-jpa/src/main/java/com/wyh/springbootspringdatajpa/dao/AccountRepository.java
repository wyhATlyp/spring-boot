package com.wyh.springbootspringdatajpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.wyh.springbootspringdatajpa.entity.AccountEntity;

public interface AccountRepository extends Repository<AccountEntity, Long> {
	
	/**
	 * -根据方法名称命名查询
	 * -方法名要求：findBy(关键字) + 属性名称(首字母大写) + 筛选条件Equals(可省略)
	 * @param account
	 * @return
	 */
	List<AccountEntity> findAll();
	List<AccountEntity> findByChinese(String chinese);
	List<AccountEntity> findByChineseAndPassword(String chinese, String password);
	List<AccountEntity> findByAccountLike(String account);

	/**
	 * @Query实现HQL
	 * nativeQuery true:SQL false:HQL(默认)
	 * @param account
	 * @return
	 */
	@Query("from AccountEntity where account = ?1")
	List<AccountEntity> queryByAccountHQL(String account);
	@Query(value = "select * from t_account where f_account = ?1", nativeQuery = true)
	List<AccountEntity> queryByAccountSQL(String account);
	
	@Query("update AccountEntity set password = ?1 where account = ?2")
	@Modifying
	void updatePasswordByAccount(String password, String account);
	
}
