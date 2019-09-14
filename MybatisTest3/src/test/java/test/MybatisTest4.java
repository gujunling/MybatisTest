package test;

import dao.AccountDao;
import dao.UserDao;
import domain.Account;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author gjq
 * @create 2019-08-31-16:43
 */
public class MybatisTest4 {

    private InputStream is;
    private SqlSession session;
    private UserDao userDao;

    @Before  //用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);

        //3.使用工厂生产SqlSession对象
        session = factory.openSession();

        //4.使用SqlSession创建dao接口的代理对象
        userDao = session.getMapper(UserDao.class);
    }


    @After   //用于在测试方法执行之后执行
    public void destory() {

        //提交事务
        session.commit();

        //6.关闭资源
        session.close();

        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 测试查询所有账户信息的方法
     */
    @Test
    public void test1() {

        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }


   /* *//**
     * 测试根据id查询账户信息方法
     *//*
    @Test
    public void test2() {

        //执行方法
        Account account = accountDao.findById(2);
        System.out.println(account);
    }


    *//**
     * 测试查询账户信息和用户姓名、地址信息的方法
     *//*
    @Test
    public void test3() {

        //执行方法
        List<Account> accounts = accountDao.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
*/
}
