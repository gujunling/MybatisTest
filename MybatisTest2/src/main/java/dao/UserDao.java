package dao;

import domain.User;
import mybatis.annotations.Select;

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
    @Select("select * from user ")
    public List<User> findAll();
}
