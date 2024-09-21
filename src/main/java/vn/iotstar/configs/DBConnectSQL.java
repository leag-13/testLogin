package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData; // Sử dụng java.sql.DatabaseMetaData

public class DBConnectSQL {
    private final String serverName = "localhost";
    private final String dbName = "ltweb";
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "sa";
    private final String password = "123";

    public Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
            if (instance == null || instance.trim().isEmpty())
                url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;

            conn = DriverManager.getConnection(url, userID, password);

            if (conn != null) {
                DatabaseMetaData dm = conn.getMetaData(); // Sử dụng java.sql.DatabaseMetaData
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }

            return conn;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            System.out.println(new DBConnectSQL().getConnection());
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
