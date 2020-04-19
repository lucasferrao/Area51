package Area51.dataaccess;

import Area51.business.*;
import Area51.business.Recluse;
import Area51.business.exceptions.WrongCredentialsException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the class that connects to database.
 *
 * @author A89262
 * @version 20200329
 */
public class DBConnection {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement preparedStmt;


    /**
     * Method that connects to database.
     */
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

    /**
     * Method that insert a new recluse to database.
     *
     * @param recluse_name recluse's name.
     * @param birthdate recluse's birthdate.
     * @param genre recluse's genre.
     * @param disease recluse's disease.
     * @param cause recluse's cause.
     * @param cell recluse's cell.
     * @return the new recluse's data.
     */
    public Recluse newRecluse(String recluse_name, LocalDate birthdate, String genre, String disease,
                              String cause, String cell){
        Recluse recluse = new Recluse();

        try {
            String query = "INSERT INTO recluse (recluse_name, birthdate, genre, disease, cause, cell)" +
                    " VALUES (?, ?, ?, ?, ?, ?);";
            preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, recluse_name);
            preparedStmt.setDate(2, java.sql.Date.valueOf(birthdate));
            preparedStmt.setString(3, genre);
            preparedStmt.setString(4, disease);
            preparedStmt.setString(5, cause);
            preparedStmt.setString(6, cell);

            preparedStmt.executeUpdate();

            recluse.setRecluseName(recluse_name);
            recluse.setBirthdate(birthdate);
            recluse.setGenre(genre);
            recluse.setDisease(disease);
            recluse.setCause(cause);
            recluse.setCell(cell);

            System.out.println("Records from Database");


        } catch (Exception e){
            e.printStackTrace();
        }

        return recluse;
    }

    /**
     * Method that gives data from a recluse.
     *
     * @param id_recluse recluse's id
     * @return recluse's data
     */
    public Recluse getRecluseDataByID(int id_recluse){
        Recluse recluse = new Recluse();

        try{
            String query = "SELECT * FROM recluse WHERE id_recluse = " + id_recluse;
            rs = st.executeQuery(query);
            System.out.println("Records from Database");

            while(rs.next()){
                String recluse_name = rs.getString("recluse_name");
                Date birthdate = rs.getDate("birthdate");
                String genre = rs.getString("genre");
                String disease = rs.getString("disease");
                String cause = rs.getString("cause");
                String cell = rs.getString("cell");
                recluse.setRecluseName(recluse_name);
                recluse.setBirthdate(birthdate.toLocalDate());
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
     * Method that gives the number of rows of a table.
     *
     * @param table_name database table's name
     * @return a count
     */
    public int getCountRows(String table_name){
        int count = 0;

        try{
            String query = "SELECT COUNT(*)FROM " + table_name + ";";
            rs = st.executeQuery(query);
            rs.next();
            count += rs.getInt(1);

        }catch(Exception e){
            System.out.println(e);
        }

        return count;
    }

    /**
     * Method that shows all officers from database.
     *
     * @return a list with all officers
     */
    public List<Officer> getAllOfficers(){
         List<Officer> officers = new ArrayList<Officer>();

         try{
             String query = "SELECT * FROM officer";
             rs = st.executeQuery(query);
             while(rs.next()){

                 Officer officer = new Officer();
                 String id_officer_login = rs.getString("id_officer_login");
                 String email = rs.getString("email");
                 String login_password = rs.getString("login_password");
                 String officer_address = rs.getString("officer_address");
                 int phone_number = rs.getInt("phone_number");
                 officer.setIdOfficerLogin(id_officer_login);
                 officer.setEmail(email);
                 officer.setPassword(login_password);
                 officer.setAddress(officer_address);
                 officer.setPhoneNumber(phone_number);

                 officers.add(officer);
            }
         }catch(Exception e){
             e.printStackTrace();
         }

         return officers;
    }

    /**
     * Gives all data from all recluses.
     *
     * @return a list of all recluses
     */
    public List<Recluse> getAllRecluses(){
        List<Recluse> recluses = new ArrayList<Recluse>();

        try{
            String query = "SELECT * FROM recluse";
            rs = st.executeQuery(query);
            while(rs.next()){

                Recluse recluse = new Recluse();
                String recluse_name = rs.getString("recluse_name");
                Date birthdate = rs.getDate("birthdate");
                String genre = rs.getString("genre");
                String disease = rs.getString("disease");
                String cause = rs.getString("cause");
                String cell = rs.getString("cell");
                recluse.setRecluseName(recluse_name);
                recluse.setBirthdate(birthdate.toLocalDate());
                recluse.setGenre(genre);
                recluse.setDisease(disease);
                recluse.setCause(cause);
                recluse.setCell(cell);

                recluses.add(recluse);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return recluses;
    }


    /**
     * Method that gives data from a officer.
     *
     * @param id_officer officer's id.
     * @return officer's data
     */
    public Officer getOfficerDataByID(int id_officer){
        Officer officer = new Officer();

        try{
            String query = "SELECT * FROM officer WHERE id_officer = " + id_officer;
            rs = st.executeQuery(query);
            System.out.println("Records from Database");

            while(rs.next()){
                String id_officer_login = rs.getString("id_officer_login");
                String email = rs.getString("email");
                String login_password = rs.getString("login_password");
                String officer_address = rs.getString("officer_address");
                int phone_number = rs.getInt("phone_number");
                officer.setIdOfficerLogin(id_officer_login);
                officer.setEmail(email);
                officer.setPassword(login_password);
                officer.setAddress(officer_address);
                officer.setPhoneNumber(phone_number);

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return officer;
    }

    /**
     * Method that gives data from a visitor.
     *
     * @param id_visitor visitor's id.
     * @return visitor's data
     */
    public Visitor getVisitorDataByID(int id_visitor){
        Visitor visitor = new Visitor();

        try{
            String query = "SELECT * FROM visitor WHERE id_visitor = " + id_visitor;
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
            e.printStackTrace();
        }

        return visitor;
    }

    /**
     * Method that gives data from a visit.
     *
     * @param id_visit visit's id.
     * @return visit's data
     */
    public Visit getVisitDataByID(int id_visit){
        Visit visit = new Visit();

        try{
            String query = "SELECT * FROM visit WHERE id_visit = " + id_visit;
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
            e.printStackTrace();
        }

        return visit;
    }

    /**
     * Method that gives data from a device.
     *
     * @param id_device device's id.
     * @return device's data
     */
    public Device getDeviceDataByID(int id_device){
        Device device = new Device();

        try{
            String query = "SELECT * FROM device WHERE id_device = " + id_device;
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            System.out.println(query.isEmpty());

            while(rs.next()){
                String deviceType = rs.getString("deviceType");
                String model = rs.getString("model");
                String deviceLocation = rs.getString("deviceLocation");
                String repairHistory = rs.getString("repair_history");
                device.setType(deviceType);
                device.setModel(model);
                device.setLocation(deviceLocation);
                device.setRepairHistory(repairHistory);


            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return device;
    }

    /**
     * Method that gives data from a alert.
     *
     * @param id_alert alert's id.
     * @return alert's data
     */
    public Alert getAlertDataByID(int id_alert){
        Alert alert = new Alert();

        try{
            String query = "SELECT * FROM alert WHERE id_alert = " + id_alert;
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
            e.printStackTrace();
        }

        return alert;
    }

    /**
     * Method that gives data from a occurrence.
     *
     * @param id_occurrence occurrence's id.
     * @return occurrence's data
     */
    public Occurrence getOccurrenceDataByID(int id_occurrence){
        Occurrence occurrence = new Occurrence();

        try{
            String query = "SELECT * FROM id_occurrence WHERE id_occurrence = " + id_occurrence;
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
            e.printStackTrace();
        }

        return occurrence;
    }

    /**
     * Method that gives data from a occurrence by alert.
     */
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
            e.printStackTrace();
        }
    }


    /**
     * Method that updates data from a recluse.
     *
     * @param id_recluse recluse's id that is updating from.
     * @param recluseName new recluse's name.
     * @param birthdate new recluse's birthdate.
     * @param genre new recluse's genre.
     * @param disease new recluse's disease.
     * @param cause new recluse's cause.
     * @param cell new recluse's cell.
     * @return updated recluse's date.
     */
    public Recluse updateRecluseDataByID(int id_recluse, String recluseName, LocalDate birthdate, String genre,
                                     String disease, String cause, String cell){
        Recluse recluse = new Recluse();

        try{
            //String query = "Update recluse Set recluse_name = " + recluseName + ", birthdate = " + java.sql.Date.valueOf(birthdate) +
              //      ", genre = " + genre + ", disease = " + disease + ", cause = " + cause + ", cell = " + cell + " " +
                //    "WHERE id_recluse = " + id_recluse + ";";
            String query = "Update recluse Set recluse_name = ?, birthdate = ?, genre = ?, disease = ?, cause = ?, " +
                    "cell = ? WHERE id_recluse = " + id_recluse + ";";

            preparedStmt = con.prepareStatement(query);

            preparedStmt.setString(1, recluseName);
            preparedStmt.setDate(2, java.sql.Date.valueOf(birthdate));
            preparedStmt.setString(3, genre);
            preparedStmt.setString(4, disease);
            preparedStmt.setString(5, cause);
            preparedStmt.setString(6, cell);

            preparedStmt.executeUpdate();

            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return recluse;
    }

    /**
     * Method that deletes all data from a table.
     *
     * @param id id from a table
     * @param table_name table name
     * @return a boolean that indicates if the query was executed.
     */
    public boolean deleteDataByID(int id, String table_name){
        boolean deleted = false;
        int countRows = getCountRows(table_name);
        int count = 0;

        try{
            String query = "DELETE FROM " + table_name  + " WHERE id_" + table_name + " = " + id + ";";
            preparedStmt = con.prepareStatement(query);

            preparedStmt.executeUpdate();
            count = getCountRows(table_name);

            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        int total = countRows - count;
        if(total == 1)
            return true;
        return false;
    }

    /**
     * Method that allows a officer to login.
     *
     * @param id officer's ID
     * @param password officer's password
     * @return Officer that logged in
     * @throws WrongCredentialsException if the credentials gaven do not matches to none registered officer.
     */
    public boolean login(String id, String password) throws WrongCredentialsException {
        Officer officer = new Officer(id, password);
        List<Officer> officers = getAllOfficers();

        if (officer == null)
            throw new WrongCredentialsException();

        for(Officer o : officers){
            if(id.equals(o.getIdOfficerLogin()) && password.equals(o.getPassword())){
                return true;
            }
        }

        throw new WrongCredentialsException();
    }
}
