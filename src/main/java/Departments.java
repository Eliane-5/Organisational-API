import org.sql2o.*;

import java.util.List;

public class Departments {
    private String dName;
    private String description;
    private int employeeNo;
    private int id;
    public Departments(String dName, String description, int employeeNo){
        this.dName = dName;
        this.description = description;
        this.employeeNo = employeeNo;
    }

    public String getDName() {
        return dName;
    }

    public String getDescription() {
        return description;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }
    public int getId() {
        return id;
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO departments (dName, description, employeeNo) VALUES (:dName, :description, :employeeNo)";
            this.id = (int) con.createQuery(sql)
                    .addParameter("dName", this.dName)
                    .addParameter("description", this.description)
                    .addParameter("employeeNo", this.employeeNo)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Departments> all() {
        String sql = "SELECT * FROM departments";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Departments.class);
        }
    }
}
