package com.smbms.dao;

import com.smbms.pojo.User;

import java.util.List;

public interface UserMapper {
    int count();

    List<User> findAll();
}
