package com.demomybatis;

import com.smbms.pojo.User;
import com.smbms.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Object count = sqlSession.selectOne("UserMapper.count");
        List<Object> lists = sqlSession.selectList("UserMapper.findAll");
        for (Object list : lists) {
            User user = (User) list;
            System.out.println(user);
        }
        sqlSession.close();
    }
}
