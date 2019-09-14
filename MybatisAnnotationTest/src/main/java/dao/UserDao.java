package dao;

import domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author gjq
 * @create 2019-09-01-17:27
 */
public interface UserDao {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Select("select * from user")
    @Results(id = "UserMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address"),
            @Result(property = "accounts", column = "id",many = @Many(select = "dao.AccountDao.findById",fetchType = FetchType.LAZY) )
    })
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user
     */
    @Insert("insert into user(username,birthday,sex,address)values(#{username},#{birthday},#{sex},#{address})")
    void saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer id);

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id} ;")
    @ResultMap("UserMap")
    User findById(Integer id);

    /**
     * 根据用户名进行模糊查询
     *
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username} ")
    List<User> findUserByName(String username);

    /**
     * 查询总记录数
     *
     * @return
     */
    @Select("select count(*) from user ")
    int findTotal();

}
