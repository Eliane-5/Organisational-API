import org.sql2o.*;

import java.util.List;

public class Users {
    private String fName;
    private String sName;
    private String position;
    private String department;
    public Users(String fName, String sName, String position, String department){
        this.fName = fName;
        this.sName = sName;
        this.position = position;
        this.department = department;
    }

    public String getFName() {
        return fName;
    }

    public String getSName() {
        return sName;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO users (fName, sName, position, department) VALUES (:fName, :sName, :position, :department)";
            con.createQuery(sql)
                    .addParameter("fName", this.fName)
                    .addParameter("sName", this.sName)
                    .addParameter("position", this.position)
                    .addParameter("department", this.department)
                    .executeUpdate();
        }
    }
    public static List<Users> all() {
        String sql = "SELECT * FROM users";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Users.class);
        }
    }
}
