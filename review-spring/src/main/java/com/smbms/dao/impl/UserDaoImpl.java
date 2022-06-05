package com.smbms.dao.impl;

import com.smbms.dao.UserDao;
import org.springframework.stereotype.Repository;



@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public Integer updateUser(String userName, int userRole) {
        System.out.println("UserDaoImpl修改用户成功》》》》》》》》》》");
        return 1;
    }
}
