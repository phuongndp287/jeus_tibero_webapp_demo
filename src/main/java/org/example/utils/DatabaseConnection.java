package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    //Postgresql
    //private static String url = "jdbc:postgresql://localhost:5433/postgres";
    //private static String user = "postgres";
    //private static String password = "postgres";
    //private static String driver = "org.postgresql.Driver";

    //Tibero

    private static String url = "jdbc:tibero:thin:@localhost:8629:tibero7 ";
    private static String user = "syscat";
    private static String password = "";
    private static String driver = "com.tmax.tibero.jdbc.TbDriver";

    public static Connection conn;

//    public static Connection getConnection() {
//        try ( Connection conn = DriverManager.getConnection(url,user,password)) {
//           if ( conn != null ) {
//               System.out.println("Connected to the database!");
//           }
//           else {
//               System.out.println("Failed to make connection!");
//           }
//        } catch (SQLException e) {
//            System.err.println("Failed to establish a database connection:");
//            e.printStackTrace();
//        }
//        return conn;
//    }

    public static Connection getConnection () {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }
        return null;
    }

    public boolean isConnected() {
        try {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}