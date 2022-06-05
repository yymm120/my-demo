package com.smbms.dao.impl;

import com.smbms.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl2 implements UserDao {
    @Override
    public Integer updateUser(String userName, int userRole) {
        System.out.println("UserDaoImpl2222修改用户成功》》》》》》》》》》");
        return 1;
    }
}
