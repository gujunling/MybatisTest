package dao;

import domain.QueryVo;
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
/*

    */
/**
     * 保存方法
     *
     * @param user
     *//*

    void saveUser(User user);

    */
/**
     * 更新方法
     *
     * @param user
     *//*

    void updateUser(User user);

    */
/**
     * 根据id删除用户
     *
     * @param id
     *//*

    void deleteUser(Integer id);
*/

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

  /*  *//**
     * 查询总用户数
     *
     * @return
     *//*
    int findTotal();*/

    /**
     * 根据QueryVo中的条件查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);


    /**
     * 根据传入的参数进行条件查询
     * @param user  查询的条件可能是姓名，可能是性别，也可能是地址，可能参数都有，也可能只有一个
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据QueryVo中提供的id集合，查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
