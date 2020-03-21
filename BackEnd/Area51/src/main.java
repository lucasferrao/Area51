import DataAccess.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {
    public static void main(String args[]) {

       DBConnection connect = new DBConnection();
       connect.getRecluseData();

    }
}
