package Area51.dataaccess;

import Area51.business.*;
import Area51.business.Recluse;

import java.sql.*;
import java.time.LocalTime;
import java.util.Date;

public class DBConnection {
    private Connection con;
    private Statement st;
    private ResultSet rs;


    public DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com/YrTGCBVRUv?useSSL=false", "YrTGCBVRUv",
                    "8hjO0RSz1p");
            st = con.createStatement();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public Recluse getRecluseDataByID(int id_recluse){
        Area51.business.Recluse recluse = new Area51.business.Recluse();

        try{
            String query = "SELECT * FROM recluse WHERE id_recluse=" + id_recluse;
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            System.out.println(query.isEmpty());

            while(rs.next()){
                String recluse_name = rs.getString("recluse_name");
                Date birthdate = rs.getDate("birthdate");
                String genre = rs.getString("genre");
                String disease = rs.getString("disease");
                String cause = rs.getString("cause");
                String cell = rs.getString("cell");
                recluse.setRecluse_name(recluse_name);
                recluse.setBirthdate(birthdate);
                recluse.setGenre(genre);
                recluse.setDisease(disease);
                recluse.setCause(cause);
                recluse.setCell(cell);

            }

        }catch(Exception e){
            System.out.println(e);
        }

        return recluse;
    }

    /**
    public List<Recluse> getAllRecluses(){
        try{
            List<Recluse> recluses = new ArrayList<Recluse>();
            String query = "SELECT * FROM recluse";
            rs = st.executeQuery(query);
            System.out.println(rs);
            while(rs.next()){


                Recluse r = new Recluse();
                String recluse_name = rs.getString("recluse_name");
                System.out.println(recluse_name);
                return recluses;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return getAllRecluses(); //?????
    }
     **/

    public Officer getOfficerDataByID(int id_officer){
        Area51.business.Officer officer = new Area51.business.Officer();

        try{
            String query = "SELECT * FROM recluse WHERE id_recluse = " + id_officer;
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            System.out.println(query.isEmpty());

            while(rs.next()){
                int id_officer_login = rs.getInt("id_officer_login");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String address = rs.getString("address");
                int phone_number = rs.getInt("phone_number");
                officer.setIdOfficerLogin(id_officer_login);
                officer.setEmail(email);
                officer.setPassword(password);
                officer.setAddress(address);
                officer.setPhoneNumber(phone_number);

            }

        }catch(Exception e){
            System.out.println(e);
        }

        return officer;
    }

    public Visitor getVisitorDataByID(int id_visitor){
        Area51.business.Visitor visitor = new Area51.business.Visitor();

        try{
            String query = "SELECT * FROM recluse WHERE id_recluse=" + id_visitor;
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            System.out.println(query.isEmpty());

            while(rs.next()){
                String visitor_name = rs.getString("visitor_name");
                int nif = rs.getInt("nif");
                visitor.setName(visitor_name);
                visitor.setNif(nif);

            }

        }catch(Exception e){
            System.out.println(e);
        }

        return visitor;
    }

    public Visit getVisitDataByID(int id_visit){
        Area51.business.Visit visit = new Area51.business.Visit();

        try{
            String query = "SELECT * FROM recluse WHERE id_recluse=" + id_visit;
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            System.out.println(query.isEmpty());

            while(rs.next()){
                Date date = rs.getDate("date");
                Time checkin = rs.getTime("checkin");
                Time checkout = rs.getTime("checkout");
                visit.setDate(date);
                visit.setCheckin(checkin);
                visit.setCheckout(checkout);

            }

        }catch(Exception e){
            System.out.println(e);
        }

        return visit;
    }

    /**
    public void getDeviceDataByID(int id_device){
        Area51.business. visit = new Area51.business.Visit();

        try{
            String query = "SELECT * FROM recluse WHERE id_recluse=" + id_visit;
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            System.out.println(query.isEmpty());

            while(rs.next()){
                Date date = rs.getDate("date");
                Time checkin = rs.getTime("checkin");
                Time checkout = rs.getTime("checkout");
                visit.setDate(date);
                visit.setCheckin(checkin);
                visit.setCheckout(checkout);

            }

        }catch(Exception e){
            System.out.println(e);
        }

        return visit;
    }
     **/

    public Alert getAlertDataByID(int id_alert){
        Area51.business.Alert alert = new Area51.business.Alert();

        try{
            String query = "SELECT * FROM recluse WHERE id_recluse=" + id_alert;
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            System.out.println(query.isEmpty());

            while(rs.next()){
                String type = rs.getString("type");
                Date alert_date = rs.getDate("alert_date");
                Time alert_hour = rs.getTime("alert_hour");
                alert.setType(type);
                alert.setDate((java.sql.Date) alert_date);
                alert.setHour(alert_hour);

            }

        }catch(Exception e){
            System.out.println(e);
        }

        return alert;
    }

    public Occurrence getOccurrenceDataByID(int id_occurrence){
        Area51.business.Occurrence occurrence = new Area51.business.Occurrence();

        try{
            String query = "SELECT * FROM recluse WHERE id_recluse=" + id_occurrence;
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            System.out.println(query.isEmpty());

            while(rs.next()){
                String occurrence_description = rs.getString("occurrence_description");
                String subject = rs.getString("subject");
                Date occurrence_date = rs.getDate("occurrence_date");
                occurrence.setDescription(occurrence_description);
                occurrence.setSubject(subject);
                occurrence.setDate((java.sql.Date) occurrence_date);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        return occurrence;
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
