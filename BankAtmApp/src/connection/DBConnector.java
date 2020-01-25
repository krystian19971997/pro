package connection;

import java.sql.*;

public class DBConnector {
      private static String URL="jdbc:mysql://localhost/bankomat";
      private static String USER = "root";
      private static String PASSWORD = "";

public static Connection connect(){
    Connection connection = null;
    try {
        connection=DriverManager.getConnection(URL,USER,PASSWORD);
        //System.out.println("polaczono z bazą");
    }catch (SQLException e){
        e.printStackTrace();
    }
    return connection;
}
    }
