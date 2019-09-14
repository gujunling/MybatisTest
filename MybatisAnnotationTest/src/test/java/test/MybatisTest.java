package test;

import dao.UserDao;
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
import java.util.Date;
import java.util.List;

/**
 * @author gjq
 * @create 2019-09-01-17:49
 */
public class MybatisTest {

    private InputStream is;
    private SqlSession session;
    private UserDao userDao;

    @Before  //用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        //3.使用工厂生产SqlSession对象
        session = factory.openSession();

        //4.使用SqlSession创建dao接口的代理对象
        userDao = session.getMapper(UserDao.class);

    }


    @After   //用于在测试方法执行之后执行
    public void destory() {
        session.commit();
        session.close();
        //关闭资源
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试查询所有用户信息的方法
     */
    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    /**
     * 测试保存用户信息方法
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("小贱人");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("河南省郑州市");
        userDao.saveUser(user);

    }

    /**
     * 测试更新用户信息的方法
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(50);
        user.setUsername("小妹妹");
        user.setAddress("河南省许昌市");
        user.setSex("女");
        user.setBirthday(new Date());
        System.out.println(userDao);
        userDao.updateUser(user);
        System.out.println(user);
    }


    /**
     * 测试删除用户的方法
     */
    @Test
    public void testDelete() {
        userDao.deleteUser(57);
    }


    /**
     * 测试根据id查询用户的方法
     */
    @Test
    public void testFindById() {
        User user = userDao.findById(50);
        System.out.println(user);
    }

    /**
     * 测试模糊查询的方法
     */
    @Test
    public void testFindByName() {
        List<User> users = userDao.findUserByName("%%哈");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录数的方法
     */
    @Test
    public void testFindTotal() {
        Integer count = userDao.findTotal();
        System.out.println(count);
    }
}
