import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.*;


public class App {
    public static void main(String[] args){
//      Making a home pathway
        get("/",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine() );
//        create a new user form
        get("/user/new", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newUser-form.hbs");
        }, new HandlebarsTemplateEngine());
//      post the user entered
        post("/user/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String fName = request.queryParams("fName");
            String sName = request.queryParams("sName");
            String position = request.queryParams("position");
            String department = request.queryParams("department");
            Users newUser = new Users(fName,sName,position,department);
            model.put("user", newUser);
            newUser.save();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
//      show all users in the db
        get("/allUsers", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Users> users = Users.all();
            model.put("user", users);
            return new ModelAndView(model, "allUsers.hbs");
        }, new HandlebarsTemplateEngine());
//      show new department form
        get("/dept/new", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newDept-form.hbs");
        }, new HandlebarsTemplateEngine());
//        post the department entered
        post("/dept/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String dName = request.queryParams("dName");
            String description = request.queryParams("description");
            Integer employeeNo = Integer.parseInt(request.queryParams("employeeNo"));
            Departments newDept = new Departments(dName,description,employeeNo);
            model.put("department", newDept);
            newDept.save();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
//        show all departments in the db
        get("/allDepts", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Departments> departments = Departments.all();
            model.put("departments", departments);
            return new ModelAndView(model, "allDepts.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
