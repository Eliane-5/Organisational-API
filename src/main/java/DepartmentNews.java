import org.sql2o.Connection;

import java.util.List;

public class DepartmentNews extends News {
    public static final String DATABASE_TYPE = "Department";

    public DepartmentNews(String title, String content, String dName){
        this.title = title;
        this.content = content;
        this.dName = dName;
        type = DATABASE_TYPE;
    }
    public static List<DepartmentNews> all() {
        String sql = "SELECT * FROM news WHERE type='Department';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(DepartmentNews.class);
        }
    }
    public static DepartmentNews find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM news where id=:id";
            DepartmentNews news = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(DepartmentNews.class);
            return news;
        }
    }
}
