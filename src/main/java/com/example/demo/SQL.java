package com.example.demo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class SQL{
    //these are variables i declare in the beginning of my code
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jtschema";
    private Connection connection = null;
    public static Statement statement = null;

    public void initSQLServer() {
        try {
            Class.forName(DRIVER).newInstance();
            try {
                connection = DriverManager.getConnection(DATABASE_URL, "root", "Dropatrain!248");
                statement = connection.createStatement();
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

