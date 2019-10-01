import org.sql2o.*;

import java.util.List;

public abstract class News {
    public String title;
    public String content;
    public String dName;
    public int id;

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
}
