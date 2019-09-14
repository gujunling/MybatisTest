package mybatis.cfg;

/**
 * @author gjq
 * @create 2019-08-28-18:21
 */
public class Mapper {

    private String queryString;//SQL
    private String resultType;//实体类的全限定类名

    public Mapper() {
    }

    public Mapper(String queryString, String resultType) {
        this.queryString = queryString;
        this.resultType = resultType;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
