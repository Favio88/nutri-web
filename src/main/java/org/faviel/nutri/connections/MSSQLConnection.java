package org.faviel.nutri.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSQLConnection {

    private static final String strConnection = "jdbc:sqlserver://"
            + "74.208.198.44:1433;"
            + "database=nutri;"
            + "user=nutri;"
            + "password=nutr1_2025;"
            + "encrypt=true;"
            + "trustServerCertificate=true;"
            + "loginTimeout=30;";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(strConnection);
    }
}
