package dao;

import domain.Account;

import java.util.List;

/**
 * @author gjq
 * @create 2019-08-31-16:38
 */
public interface AccountDao {


    /**
     * 查询所有账户
     *
     * @return
     */
    List<Account> findAll();

    /**
     * 根据id查询账户信息
     *
     * @param id
     * @return
     */
    Account findById(Integer id);


    /**
     * 查询所有账户信息，带有用户姓名和地址信息
     *
     * @return
     */
    List<Account> findAllAccount();
}
