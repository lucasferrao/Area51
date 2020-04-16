/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package area51.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utilizador~
 */
public class DbConnection {
    
    /**
     * @param args the command line arguments
     */
    Connection con;

    public static void main(String[] args) {
        // TODO code application logic here
        Connection con;
        Statement st;
        ResultSet rs;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/YrTGCBVRUv?autoReconnect=true&useSSL=false", "YrTGCBVRUv", "8hjO0RSz1p");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM alert");

            while (rs.next()) {
                System.out.println("ID do alerta : " + rs.getInt("id_alert") + " Tipo de Alerta : " + rs.getString("alert_type") + " Data : " + rs.getString("alert_date"));
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    Statement st;
    ResultSet rs;
        public Connection getCon () {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/YrTGCBVRUv?autoReconnect=true&useSSL=false", "YrTGCBVRUv", "8hjO0RSz1p");
                st = con.createStatement();
                rs = st.executeQuery("SELECT * FROM officer");

                while (rs.next())
                    System.out.println(rs.getString("id_officer_login") + rs.getString("login_password"));
            } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        } return con;
    }
}
