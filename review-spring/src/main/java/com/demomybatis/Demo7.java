package com.demomybatis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smbms.dao.UserMapper;
import com.smbms.pojo.User;
import com.smbms.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Demo7 {
    /**
     * collection 一对多, 自动映射会被取材, 需要提升到FULL才能自动映射
     * 一个用户对应多个收货人地址: user -> address
     * 查询所有用户对应的联系人信息: findAllUserForAddresses()
     */
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.findAllUserForAddresses();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String s = objectMapper.writeValueAsString(users);
        System.out.println(s);
        sqlSession.close();
    }
}
