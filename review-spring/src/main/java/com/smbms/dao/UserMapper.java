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

    /** Demo5.1 CRUD - create */
    int addUser(User user);

    /** Demo5.2 CRUD - delete */
    int delUser(int id);

    /** Demo5.3 CRUD - update*/
    int updUser(User user);

    /** Demo5.4 resultMap 自定义映射结果*/
    List<User> findAllResultMap();
}
