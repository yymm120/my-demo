package com.smbms.dao;

import com.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int count();

    List<User> findAll();

    /** 1. 传一个简单参数 */
    List<User> findList1(String userName);

    /** 2. 传多个简单参数 - 下标 */
    List<User> findList2(String userName, String phone);

    /** 2. 传多个简单参数 - 注解 */
    List<User> findList3(@Param("userName") String userName, @Param("phone") String phone);

    /** 3. 传一个复杂参数 - Map */
    List<User> findList4(Map<String, Object> map);

    /** 3. 传一个复杂参数 - JavaBean */
    List<User> findList5(User user);

    /** com.demomybatis.Demo5.1 CRUD - create */
    int addUser(User user);

    /** com.demomybatis.Demo5.2 CRUD - delete */
    int delUser(int id);

    /** com.demomybatis.Demo5.3 CRUD - update*/
    int updUser(User user);

    /** com.demomybatis.Demo5.4 resultMap 自定义映射结果*/
    List<User> findAllResultMap();

    /* com.demomybatis.Demo6 association 定义一对一关系*/
    List<User> findAllUserForRoleInfo();

    /** com.demomybatis.Demo7 collection 定义一对多关系 */
    List<User> findAllUserForAddresses();

    /* Demo9 动态SQL - <if> */
    List<User> list1(@Param("userName") String userName1, @Param("userRole") Integer userRole1);
    /* Demo9 动态SQL - <where> <if>*/
    List<User> list2(@Param("userName") String userName1, @Param("userRole") Integer userRole1);
}
