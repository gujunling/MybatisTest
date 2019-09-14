package test;

import dao.UserDao;
import domain.User;
import mybatis.io.Resources;
import mybatis.sqlsession.SqlSession;
import mybatis.sqlsession.SqlSessionFactory;
import mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis的测试
 *
 * @author gjq
 * @create 2019-08-28-13:55
 */
public class MybatisTest {

    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);

        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();

        //4.使用SqlSession创建dao接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);

        //5.使用代理对象执行方法

        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

        //6.关闭资源
        session.close();
        is.close();

    }
}
