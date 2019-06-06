package com.mkx.seumedia.mappers;

import com.mkx.seumedia.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);
    User selectByPhone(String phone);
    User selectByEmail(String email);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}