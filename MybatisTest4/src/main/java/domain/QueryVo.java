package domain;

import java.util.List;

/**
 * @author gjq
 * @create 2019-08-30-22:35
 */
public class QueryVo {

    private User user;

    private List<Integer> ids;

    public QueryVo() {
    }

    public QueryVo(User user, List<Integer> ids) {
        this.user = user;
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "user=" + user +
                ", ids=" + ids +
                '}';
    }
}
