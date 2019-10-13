package com.wyh.springbootmybatis.mapper;

import com.wyh.springbootmybatis.entity.UserEntity;

public interface UserMapper {
	
	UserEntity selectById(long id);
	
}