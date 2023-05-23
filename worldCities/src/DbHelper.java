
import java.sql.*;

public class DbHelper {

    private String username = "root";
    private String password = "";
    private String dbUrl = "jdbc:mysql://localhost:3306/world";
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(dbUrl,username,password);
    }
    
    public void showErrorMessage(SQLException exception){
        System.out.println("Hata : " + exception.getMessage());
        System.out.println("Hata kodu : " + exception.getErrorCode());
    }
}
