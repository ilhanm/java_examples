package com.ilhan.hb_onetoone_uni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbcConnection {
    public static void main(String[] args){
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";
        try{
            System.out.println("Connecting to database: "+ jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful !");

        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
}
