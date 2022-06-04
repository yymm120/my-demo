import com.fasterxml.jackson.databind.ObjectMapper;
import com.smbms.dao.UserMapper;
import com.smbms.pojo.User;
import com.smbms.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class Demo6 {
    /**
     * association 一对一
     * 一个用户对应一个角色: user -> role
     * 查询所有用户对应的角色信息: findAllUserForRoleInfo()
     */
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAllUserForRoleInfo();

        ObjectMapper objectMapper = new ObjectMapper();
        String userJsonString = objectMapper.writeValueAsString(userList);
        System.out.println(userJsonString);
        sqlSession.close();
    }

}
