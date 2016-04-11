/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


/**
 *
 * @author hidro
 */

public class DataConnect {
        private static String url="jdbc:mysql://127.0.0.1:3306/online_lib";
        private static String name="root";
        private static String pwd="96496950";
        private static String driver="com.mysql.jdbc.Driver";
    
        public static Connection getConnection() {
        try {
            Class.forName(driver);
            Connection con=(Connection) DriverManager.getConnection(url, name, pwd);
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->"
                    + ex.getMessage());
            return null;
        }
    }
 
    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
    public DataConnect() {
    }
    
}
