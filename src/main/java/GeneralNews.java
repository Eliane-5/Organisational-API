import org.sql2o.*;

import java.util.List;

public class GeneralNews extends News {
    public GeneralNews(String title, String content, String dName){
        this.title = title;
        this.content = content;
        this.dName = dName;
    }
    public static List<GeneralNews> all() {
        String sql = "SELECT * FROM news;";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(GeneralNews.class);
        }
    }
    public static GeneralNews find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM news where id=:id";
            GeneralNews news = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(GeneralNews.class);
            return news;
        }
    }
}
