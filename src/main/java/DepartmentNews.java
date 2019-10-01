import org.sql2o.Connection;

import java.util.List;

public class DepartmentNews extends News {
    public DepartmentNews(String title, String content, String dName){
        this.title = title;
        this.content = content;
        this.dName = dName;
    }
    public static List<DepartmentNews> all() {
        String sql = "SELECT * FROM news;";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(DepartmentNews.class);
        }
    }
    public static DepartmentNews find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM news where id=:id";
            DepartmentNews news = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(DepartmentNews.class);
            return news;
        }
    }
}
