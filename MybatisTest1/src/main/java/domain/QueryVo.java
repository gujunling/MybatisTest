package domain;

/**
 * @author gjq
 * @create 2019-08-30-22:35
 */
public class QueryVo {

    private User user;

    public QueryVo() {
    }

    public QueryVo(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "user=" + user +
                '}';
    }
}
