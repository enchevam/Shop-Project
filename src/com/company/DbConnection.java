package com.company;

import java.sql.*;

public class DbConnection {
    public static Connection con = null;

    public static Connection connect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "bobito12");
            System.out.println("You are connected!");

        } catch (Exception exception) {
            System.out.println(exception);
        } /*finally {
            if (con != null) try {
                con.close();
            } catch (Exception e) {
            }
        }*/
        return con;
    }
}
