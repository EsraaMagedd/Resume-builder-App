
package Screens;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingletonClass {

     static Connection connection;
     static ConnectionSingletonClass connectionSingletonClass;

     ConnectionSingletonClass(){
        try {
          
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://ESRAA-MAGED\\SQLEXPRESS:1433;databaseName=ResumeBuilderDB16;integratedSecurity=true;encrypt=true;trustServerCertificate=true");
            
          //  Statement stat=(Statement) connection.createStatement();        
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    };

    public static Connection getConnection()
    {
        if (connectionSingletonClass == null) {

            connectionSingletonClass = new ConnectionSingletonClass();
            System.out.println(" connectionSingletonClass "+connection.hashCode());
        }

        return connection;
    }
}
