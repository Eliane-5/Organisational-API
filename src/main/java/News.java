import org.sql2o.*;

public class News {
    private String title;
    private String content;
    private String dName;
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
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO news (title, content,dName) VALUES (:title, :content, :dName)";
            con.createQuery(sql)
                    .addParameter("title", this.title)
                    .addParameter("content", this.content)
                    .addParameter("dName", this.dName)
                    .executeUpdate();
        }
    }
}
