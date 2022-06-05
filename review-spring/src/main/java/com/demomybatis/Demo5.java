package com.demomybatis;

import com.google.common.collect.ImmutableMap;
import com.smbms.dao.UserMapper;
import com.smbms.pojo.User;
import com.smbms.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/** 传递参数的方式 */
public class Demo5 {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName("罗");
        user.setUserPassword("123456");
        user.setUserCode("123");

        // com.demomybatis.Demo5.1 CRUD - create
        int addCount = mapper.addUser(user);
        // com.demomybatis.Demo5.2 CRUD - update
        user.setUserName("张");
        int updCount = mapper.updUser(user);
        // com.demomybatis.Demo5.3 CRUD - delete
        int delCount = mapper.delUser(1);
        sqlSession.commit(); // 提交变更
        // com.demomybatis.Demo5.4 resultMap 自定义映射结果
        List<User> users = mapper.findAllResultMap();
        for (User u : users) {
            System.out.println(u.getUserName() + ", " + u.getUserRoleName());
        }

        sqlSession.close();
    }
}
