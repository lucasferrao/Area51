package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    
    public DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mGSj7yInIt", "mGSj7yInIt",
                    "YKEJ9H5Bdn");
            st = con.createStatement();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void getRecluseData(){
        try{
            String query = "SELECT * FROM recluse";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String recluse_name = rs.getString("recluse_name");
                System.out.println(recluse_name);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void getOfficerData(){
        try{
            String query = "SELECT * FROM officer";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String email = rs.getString("email");
                System.out.println(email);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void getVisitorData(){
        try{
            String query = "SELECT * FROM visitor";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String visitor_name = rs.getString("visitor_name");
                System.out.println(visitor_name);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void getVisitData(){
        try{
            String query = "SELECT * FROM visit";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String visit_date = rs.getString("visit_date");
                System.out.println(visit_date);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void getOccurrenceData(){
        try{
            String query = "SELECT * FROM occurrence";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String occurrence_description = rs.getString("occurrence_description");
                System.out.println(occurrence_description);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void getDeviceData(){
        try{
            String query = "SELECT * FROM device";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String type = rs.getString("type");
                System.out.println(type);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void getAlertData(){
        try{
            String query = "SELECT * FROM alert";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String type = rs.getString("type");
                System.out.println(type);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void getOccurrenceByAlertData(){
        try{
            String query = "SELECT * FROM occurrence_by_alert";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String id_occurrence = rs.getString("id_occurrence");
                System.out.println(id_occurrence);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
