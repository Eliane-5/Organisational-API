import org.sql2o.*;

import java.util.List;

public class News {
    private String title;
    private String content;
    private String dName;
    private int id;

    public News(String title, String content, String dName){
        this.title = title;
        this.content = content;
        this.dName = dName;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDName() {
        return dName;
    }
    public int getId() {
        return id;
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO news (title, content,dName) VALUES (:title, :content, :dName)";
            this.id = (int) con.createQuery(sql)
                    .addParameter("title", this.title)
                    .addParameter("content", this.content)
                    .addParameter("dName", this.dName)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<News> all() {
        String sql = "SELECT * FROM news";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(News.class);
        }
    }
    public static News find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM news where id=:id";
            News news = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(News.class);
            return news;
        }
    }
}
