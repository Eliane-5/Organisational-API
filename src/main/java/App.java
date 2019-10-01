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
    }
}
