package com.mapper;

import com.entity.account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
public interface accountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(account record);

    int insertSelective(account record);

    account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(account record);

    int updateByPrimaryKey(account record);

    int In(@Param("name") String name,@Param("money") double money);

    int Out(@Param("name") String name,@Param("money") double money);//这里如果是多个参数需要参数

    account selectByName(String name);
}