package com.mapper;

import com.entry.User;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/11/23
 */
public interface UserMapper {
    List<User> queryUserList();

    User queryUserById(int id);

    List<User> queryUserLike(Map<String,Object> map);

    int addUser(Map<String,Object> map);

    int deleteUser(Map<String,Object> map);

    int updateUser(Map<String,Object> map);

    List<User> queryUserLimit(Map<String,Object> map);
}
