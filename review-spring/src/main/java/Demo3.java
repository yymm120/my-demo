import com.google.common.collect.ImmutableMap;
import com.smbms.dao.UserMapper;
import com.smbms.pojo.User;
import com.smbms.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/** 传递参数的方式 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        // 1. 传一个简单参数
        test1_one_arg();
        // 2. 传多个简单参数
        test2_multi_args();
        // 3. 传复杂类型参数, 例如传一个JavaBean或者Map等
        test3_complex_arg();
        // 通常会将三个以上的参数封装成一个map, 然后再以第三种方式进行传递
    }

    /** 1. 传一个参数用什么方式? - #{参数名} */
    private static void test1_one_arg() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.findList1("孙");
    }

    /** 2. 传两个参数用什么方式? - 1. #{参数索引}, 2. #{注解参数名}*/
    private static void test2_multi_args() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users1 = mapper.findList2("孙", "1234567");
        List<User> users2 = mapper.findList3("孙", "1234567");
    }

    /** 3. 传一个复杂参数用什么方式? - Map: #{key}, JavaBean: #{fieldName}*/
    private static void test3_complex_arg() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = ImmutableMap.of("name", "孙", "phone", "1234567");
        User user = new User();
        user.setUserName("孙");
        user.setPhone("1234567");

        List<User> users1 = mapper.findList4(map);
        List<User> users2 = mapper.findList5(user);
    }
}
