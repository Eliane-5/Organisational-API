public class Departments {
    private String dName;
    private String description;
    private int employeeNo;
    public Departments(String dName, String description, int employeeNo){
        this.dName = dName;
        this.description = description;
        this.employeeNo = employeeNo;
    }

    public String getdName() {
        return dName;
    }

    public String getDescription() {
        return description;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }
}
