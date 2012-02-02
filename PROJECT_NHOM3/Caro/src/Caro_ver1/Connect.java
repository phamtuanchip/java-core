/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caro_ver1;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author TTBH-Lenovo
 */
public class Connect {

    public static Connection Con() {
// can add Library: sqljdbc.jar
        String url = "jdbc:sqlserver://localhost:1433;database=Caro2";
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = java.sql.DriverManager.getConnection(url, "sa", "123456");
// if(conn!=null) System.out.println("Connection Successful!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Can not connect to database !", "Database Eror", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
}
