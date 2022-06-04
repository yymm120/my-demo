import com.smbms.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {
        // step0: 读取Mybatis核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // step1: 创建SQL会话工厂解析器
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // step2: 解析文件获取会话工厂
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        // step3: 获取SQL会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // step4: 执行SQL语句, count
        Object count = sqlSession.selectOne("UserMapper.count");
        // step5: 执行SQL语句, findAll
        List<Object> objects = sqlSession.selectList("UserMapper.findAll");
        // step6: 遍历所有user
        for (Object object : objects) {
            User user = (User) object;
            System.out.println(user.getUserName());
        }
    }

}
