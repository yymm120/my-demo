import com.smbms.dao.UserMapper;
import com.smbms.pojo.User;
import com.smbms.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 获取Mapper接口
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("userMapper: " + mapper);
        // 调用Mapper接口中的方法
        int count = mapper.count();
        List<User> userList = mapper.findAll();
        System.out.println("count = " + count);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
