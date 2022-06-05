package com.demospring.service.impl;


import com.demospring.service.UserService;
import com.smbms.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service("userService")  //实例化当前类，存入Spring容器，唯一标识默认为类名,首字母小写
public class UserServiceImpl implements UserService {

    //从Spring容器中获取userDao的实现类，注入当前对象 -byType
    //从Spring容器中获取唯一标识为userDaoImpl2的实现类，注入当前对象 -byName
    @Autowired
    @Qualifier("userDaoImpl2")
    private UserDao userDao;

    @Override
    public int addUser(String userName, int userRole) {
        /* 抛出异常, 测试AOP异常增强 */
        // int a = 1/0;
        System.out.println("userName: " + userName + "\t" + "userRole: " + userRole);
        return 0;
    }

    @Override
    public int delUser(int id) {
        System.out.println("delete user id is " + id);
        return 0;
    }
}
