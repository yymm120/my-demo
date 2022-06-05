package com.demospring.service.impl;


import com.demospring.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public int addUser(String userName, int userRole) {
        /* 抛出异常, 测试AOP异常增强 */
        int a = 1/0;
        System.out.println("userName: " + userName + "\t" + "userRole: " + userRole);
        return 0;
    }

    @Override
    public int delUser(int id) {
        System.out.println("delete user id is " + id);
        return 0;
    }
}
