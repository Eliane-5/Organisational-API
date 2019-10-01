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
}
