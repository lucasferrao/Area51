package area51.servlets;


//import javax.jms.Connection;

import java.sql.Connection;

import java.util.*;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Utilizador~
 */
public class DataBase {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://remotemysql.com:3306/YrTGCBVRUv?autoReconnect=true&useSSL=false";
    private static final String USER = "YrTGCBVRUv";
    private static final String PASS = "8hjO0RSz1p";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            return (Connection) DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }

    }

    public static ArrayList<String> getDDate() {
        Connection conn = DataBase.getConnection();
        PreparedStatement stmt = null;
        ArrayList<String> sol = new ArrayList<>();

        try {

            String sql = "SELECT id_alert, alert_type, id_device, alert_date, alert_hour, id_officer FROM alert";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();


            while (rs.next()) {
                StringBuilder json = new StringBuilder();

                json.append('{');
                for(int i = 1; i <= meta.getColumnCount(); i++) {
                    json.append('"').append(i - 1).append('"');
                    json.append(':').append('"').append(rs.getString(i)).append('"');
                    json.append(',');
                }

                json.deleteCharAt(json.length() - 1);

                json.append('}');

                sol.add(json.toString());
            }

            conn.close();
            stmt.close();
            rs.close();
            System.out.println(sol);
        } catch (Exception se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }//Handle errors for Class.forName
        finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do

            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }
        return sol;
    }
}