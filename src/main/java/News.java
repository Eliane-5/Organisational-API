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

    public String getdName() {
        return dName;
    }
}
