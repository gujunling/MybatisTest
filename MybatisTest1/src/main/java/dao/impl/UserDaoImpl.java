package dao.impl;

import dao.UserDao;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author gjq
 * @create 2019-08-31-10:11
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        //根据factory获取SqlSession对象
        SqlSession session = factory.openSession();

        //调用SqlSession中的方法，实现查询列表
        List<User> users = session.selectList("dao.UserDao.findAll");//参数就是能获取配置信息的key

        //释放资源
        session.close();

        return users;
    }

    public void saveUser(User user) {
        //根据factory获取SqlSession对象
        SqlSession session = factory.openSession();

        //调用SqlSession中的方法，实现保存
        session.insert("dao.UserDao.saveUser",user);

        //提交事务
        session.commit();
        //释放资源
        session.close();
    }

    public void updateUser(User user) {
        //根据factory获取SqlSession对象
        SqlSession session = factory.openSession();

        //调用SqlSession中的方法，实现更新
        session.update("dao.UserDao.updateUser",user);

        //提交事务
        session.commit();
        //释放资源
        session.close();
    }

    public void deleteUser(Integer id) {
        //根据factory获取SqlSession对象
        SqlSession session = factory.openSession();

        //调用SqlSession中的方法，实现删除
        session.update("dao.UserDao.deleteUser",id);

        //提交事务
        session.commit();
        //释放资源
        session.close();
    }

    public User findById(Integer id) {
        //根据factory获取SqlSession对象
        SqlSession session = factory.openSession();

        //调用SqlSession中的方法，实现根据id查询用户信息
        User user = session.selectOne("dao.UserDao.findById",id);

        //提交事务
        session.commit();
        //释放资源
        session.close();

        return user;
    }

    public List<User> findByName(String username) {
        //根据factory获取SqlSession对象
        SqlSession session = factory.openSession();

        //调用SqlSession中的方法，实现模糊查询
        List<User> users = session.selectList("dao.UserDao.findByName",username);//参数就是能获取配置信息的key

        //释放资源
        session.close();

        return users;
    }

    public int findTotal() {

        //根据factory获取SqlSession对象
        SqlSession session = factory.openSession();

        //调用SqlSession中的方法，实现查询总记录数
        Integer count = session.selectOne("dao.UserDao.findTotal");//参数就是能获取配置信息的key

        //释放资源
        session.close();

        return count;
    }
}
