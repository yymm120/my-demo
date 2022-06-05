package com.demomybatis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smbms.dao.UserMapper;
import com.smbms.pojo.User;
import com.smbms.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;


public class Demo11 {

    /**
     * Demo11: trim代替 if, where if, set
     * ---
     */
    static ObjectMapper objectMapper;
    static SqlSession sqlSession;
    static UserMapper userMapper;

    static {
        try {
            objectMapper = new ObjectMapper();
            sqlSession = MyBatisUtil.getSqlSession();
            userMapper = sqlSession.getMapper(UserMapper.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterAll
    static void before(){
        sqlSession.close();
    }

    /**
     * Demo11.1 trim 代替 where,
     * <where> 提供了SQL的WHERE 1=1子查询语句, 并且能够自动去除AND
     * <trim>代替<where>只需要设置prefix="WHERE 1=1", prefixOverrides="AND"
     */
    @Test
    void test1(){
        String userName = "赵";
        Integer userRole = 3;
        List<User> users = userMapper.list_trim(userName, userRole);
    }

    /**
     * Demo11.2 trim 代替 set, 只需要 prefix="SET" suffixOverrides=","
     */
    @Test
    void test2(){
        User user = new User();
        user.setId(15L); user.setUserName("赵六2"); user.setUserCode("6666");
        //user.setUserPassword("123123");

        //修改用户
        int count = userMapper.updateUser_trim(user);
        System.out.println("影响行数："+count);

        //提交事务
        sqlSession.commit();
    }

    /**
     * Demo11.2 trim 动态处理指定的内容
     * prefix="(" suffix=")" suffixOverrides=","
     * prefix="VALUES(" suffix=")" suffixOverrides=","
     * SQL:
     *   - INSERT INTO smbms(userName, roleName) VALUES(#{userName}, #{userRole})
     */
    @Test
    void test3(){
        User user = new User(); user.setUserName("A3"); user.setUserCode("222");
        //user.setUserPassword("1111");

        //添加用户
        int count = userMapper.addUser_trim(user);
        System.out.println("影响行数："+count);

        //提交事务
        sqlSession.commit();
    }

}
