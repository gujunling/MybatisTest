package mybatis.sqlsession.defaults;

import mybatis.cfg.Configuration;
import mybatis.sqlsession.SqlSession;
import mybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory接口的实现类
 *
 * @author gjq
 * @create 2019-08-28-18:43
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     *
     * @return
     */
    public SqlSession openSession() {

        return new DefaultSqlSession(cfg);
    }
}
