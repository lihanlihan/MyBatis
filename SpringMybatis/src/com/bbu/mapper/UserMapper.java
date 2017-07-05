package com.bbu.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bbu.model.User;

public interface UserMapper {

	//�ҵ�����user��û���ҵ�����null
	@Select("select * from tb_user where loginname = #{loginname} and password = #{password}")
	User findWithLoginnameAndPassword(@Param("loginname")String loginname, @Param("password")String password);
}
