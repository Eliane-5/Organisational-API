import org.sql2o.*;

public class DB {
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/news_portal", "eliane", "19601963");
String connectionString = "jdbc:postgresql://ec2-54-197-241-96.compute-1.amazonaws.com:5432/ddljfgmh6f392k"; //!
    Sql2o sql2o = new Sql2o(connectionString, "hpbjbqclooplnk", "34ac0ce37c74bae21de7f36addc6250cbd862989713af26ca820b82355e825fd");

}
