package test;

import dao.UserDao;
import domain.QueryVo;
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
 * mybatis的测试
 *
 * @author gjq
 * @create 2019-08-28-13:55
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
/*
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
*/

    /**
     * 测试更新方法
     */
/*
    @Test
    public void test3() {
        User user = new User();
        user.setId(48);
        user.setUsername("嘿嘿嘿");

        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("河南省周口市");

        //执行保存方法
        userDao.updateUser(user);
    }
*/

    /**
     * 测试删除方法
     */
/*
    @Test
    public void test4() {
        //执行删除方法
        userDao.deleteUser(48);
    }
*/

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
        //List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询用户总数方法
     */
/*
    @Test
    public void test7() {
        int total = userDao.findTotal();
        System.out.println(total);
    }
*/


    /**
     * 测试根据QueryVo中的条件查询用户信息方法
     */
    @Test
    public void test8() {

        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        //执行方法
        List<User> users = userDao.findUserByVo(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

}
