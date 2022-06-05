package com.demomybatis;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.smbms.dao.UserMapper;
import com.smbms.pojo.User;
import com.smbms.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * Mybatis缓存: 当使用相同的sql查询时, 会先从内存中获取查询结果<br/>
 * 1. Mybatis 默认开启一级缓存, 作用域SqlSession <br/>
 * 2. Mybatis 默认关闭二级缓存, 作用域同一个映射Mapper文件<br/>
 *    - 开启二级缓存需要配置Mapper映射文件
 */
public class Demo8 {

    public static void main(String[] args) throws IOException {
        //获取会话，获取Mapper接口
        SqlSession sqlSesssion = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSesssion.getMapper(UserMapper.class);
        ObjectMapper objectMapper = new ObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        List<User> userList1 = userMapper.findList1("孙");
        System.out.println("第一次查询："+ objectMapper.writeValueAsString(userList1));

        //一级缓存生效
        List<User> userList2 = userMapper.findList1("孙");
        System.out.println("第二次查询："+ objectMapper.writeValueAsString(userList2));

        //关闭会话
        sqlSesssion.close();

        //开启新的会话，一级缓存失效，二级缓存生效
        SqlSession sqlSession2 = MyBatisUtil.getSqlSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

        List<User> userList3 = userMapper2.findList1("孙");
        System.out.println("第三次查询："+ objectMapper.writeValueAsString(userList3));

        sqlSession2.close();
    }
}
