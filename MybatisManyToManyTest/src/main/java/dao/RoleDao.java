package dao;

import domain.Role;

import java.util.List;

/**
 * @author gjq
 * @create 2019-08-31-18:10
 */
public interface RoleDao {

    /**
     * 查询所有的角色信息
     *
     * @return
     */
    List<Role> findAll();
}
