package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import org.apache.ibatis.io.Resources;
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
 * @create 2019-08-31-10:18
 */
public class MybatisTest2 {

    private InputStream is;
    private UserDao userDao;

    @Before  //用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);

        //3.使用工厂对象，创建dao对象
        userDao = new UserDaoImpl(factory);
    }


    @After   //用于在测试方法执行之后执行
    public void destory() {

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
     * 测试查询所有方法
     */
    @Test
    public void test1() {

        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }


    /**
     * 测试保存方法
     */

    @Test
    public void test2() {
        User user = new User();
        user.setUsername("哈哈哈");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("河南省周口市");
        System.out.println("保存操作之前" + user);
        //执行保存方法
        userDao.saveUser(user);
        System.out.println("保存操作之后" + user);
    }


    /**
     * 测试更新方法
     */
    @Test
    public void test3() {
        User user = new User();
        user.setId(51);
        user.setUsername("嘿嘿嘿");

        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("河南省周口市");

        //执行保存方法
        userDao.updateUser(user);
    }


    /**
     * 测试删除方法
     */
    @Test
    public void test4() {

        //执行删除方法
        userDao.deleteUser(51);
    }


    /**
     * 测试根据id查询用户信息方法
     */
    @Test
    public void test5() {

        //执行方法
        User user = userDao.findById(49);
        System.out.println(user);
    }


    /**
     * 测试模糊查询用户信息方法
     */
    @Test
    public void test6() {

        //执行方法
        /*方法一*/
        List<User> users = userDao.findByName("%王%");
        /*方法二*/
       // List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }


    /**
     * 测试查询用户总数方法
     */
    @Test
    public void test7() {

        int total = userDao.findTotal();
        System.out.println(total);
    }


}
