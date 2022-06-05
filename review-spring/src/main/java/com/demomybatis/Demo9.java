package com.demomybatis;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.smbms.dao.UserMapper;
import com.smbms.pojo.User;
import com.smbms.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;


public class Demo9 {


    /**
     * Demo9 动态SQL <br/>
     *  1. <if></if>
     *  2. <where>
     *      <if></if>
     *     </where>
     */
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        ObjectMapper objectMapper = new ObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        String userName1 = ""; Integer userRole1 = 0;
        String userName2 = "赵"; Integer userRole2 = 0;
        String userName3 = "赵"; Integer userRole3 = 1;

        /* list1: 动态SQL满足if时拼接AND
            <if test="userName != null and userName != ''">
            <if test="userRole != null and userRole != 0">
        */
        // Notice WHERE 1=1
        List<User> userList1 = userMapper.list1(userName1, userRole1);

        /* list2:
            <where>
                <if test="userName != null and userName != ''"></if>
                <if test="userRole != null and userRole != 0"></if>
            </where>
        */
        // Notice : <where>标签可以自动去掉多余的AND和OR, 也不需要 WHERE 1=1
        List<User> userList2 = userMapper.list2(userName2, userRole2);
        List<User> userList3 = userMapper.list2(userName3, userRole3);


        sqlSession.close();
    }
}
