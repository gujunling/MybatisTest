package dao;

import domain.User;

import java.util.List;

/**
 * @author gjq
 * @create 2019-08-28-13:27
 */
public interface UserDao {

    /**
     * 查询所有用户
     *
     * @return
     */
    //@Select("select * from user ")
    List<User> findAll();

    /**
     * 保存方法
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新方法
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     *
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据姓名模糊查询用户信息
     *
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     *
     * @return
     */
    int findTotal();

    /*  *//**
     * 根据QueryVo中的条件查询用户信息
     * @param vo
     * @return
     *//*
    List<User> findUserByVo(QueryVo vo);*/
}
