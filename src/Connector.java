import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rekammedis", "root", "");
            return connection;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
