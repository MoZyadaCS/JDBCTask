import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// singleton class for database connection
public class DbConnection {
    private static String url = "jdbc:mysql://localhost:3306/iti";
    private static String user ="root";
    private static String password = "root";
    private static Connection connection;

    private DbConnection(){
    }
    public static Connection getConnection(){
        if(connection == null){
            try{
                connection = DriverManager.getConnection(url, user, password);
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
