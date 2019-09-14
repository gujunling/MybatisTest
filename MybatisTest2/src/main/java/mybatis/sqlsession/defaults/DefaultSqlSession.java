package mybatis.sqlsession.defaults;

import mybatis.cfg.Configuration;
import mybatis.sqlsession.SqlSession;
import mybatis.sqlsession.proxy.MapperProxy;
import mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SqlSession的实现类
 *
 * @author gjq
 * @create 2019-08-28-18:49
 */
public class DefaultSqlSession implements SqlSession {


    private Configuration cfg;

    private Connection connection;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 创建代理对象
     *
     * @param daoInterfaceClass dao的接口字节码，而不是dao的接口实现类
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {

        T daoProxy = (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), connection));

        return daoProxy;
    }


    /**
     * 释放资源
     */
    public void close() {

        if (connection != null) {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
