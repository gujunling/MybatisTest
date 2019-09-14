package mybatis.sqlsession;

/**
 * @author gjq
 * @create 2019-08-28-17:40
 */
public interface SqlSessionFactory {


    /**
     * 用于打开一个新的SqlSession对象
     *
     * @return
     */
    SqlSession openSession();
}
