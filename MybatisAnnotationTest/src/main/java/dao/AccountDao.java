package dao;

import domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author gjq
 * @create 2019-09-01-20:09
 */
public interface AccountDao {

    /**
     * 查询所有账户信息
     *
     * @return
     */
    @Select("select * from account")
    @Results(id = "AccountMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "money", column = "money"),
            @Result(property = "user", column = "uid",one = @One(select = "dao.UserDao.findById",fetchType = FetchType.EAGER) )
    })
    List<Account> findAll();


    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @Select("select * from account where id = #{id} ;")
    @ResultMap("AccountMap")
    Account findById(Integer id);
}
