package com.demomybatis;

import com.smbms.dao.UserMapper;
import com.smbms.pojo.User;
import com.smbms.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;



public class Demo10 {
    public static void main(String[] args) throws IOException {

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(15L);
        user.setUserName("赵六");
        user.setUserCode("6666");
        //user.setUserPassword("123123");

        /* Demo10 动态SQL - set 标签用在update里面, 它可以自动去掉尾部的逗号 */
        /* <set>
            <if> userCode=#{userCode}, </if>
           </set>*/
        //修改用户
        int count = userMapper.updateUserForDynamicSQL(user);
        System.out.println("影响行数："+count);

        sqlSession.commit();
        sqlSession.close();

    }

}
