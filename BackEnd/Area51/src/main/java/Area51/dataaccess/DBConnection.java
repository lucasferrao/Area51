package Area51.dataaccess;

import Area51.business.*;
import Area51.business.Recluse;

import java.sql.*;
import java.time.LocalDate;

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
    public Recluse newRecluse(String recluse_name, Date birthdate, String genre, String disease,
                              String cause, String cell){
        Recluse recluse = new Recluse();

        try {
            String query = "INSERT INTO recluse (recluse_name, birthdate, genre, disease, cause, cell)" +
                    " VALUES (?, ?, ?, ?, ?, ?);";
            preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, recluse_name);
            preparedStmt.setDate(2, birthdate);
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
                String recluseName = rs.getString("recluseName");
                System.out.println(recluseName);
                return recluses;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return getAllRecluses(); //?????
    }
     **/



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
            System.out.println(e);
        }

        return officer;
    }

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
            System.out.println(e);
        }

        return visitor;
    }

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
            System.out.println(e);
        }

        return visit;
    }


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
            System.out.println(e);
        }

        return device;
    }


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
            System.out.println(e);
        }

        return alert;
    }

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
    public Recluse updateRecluseDataByID(int id_recluse, String recluseName, Date birthdate, String genre,
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
            preparedStmt.setDate(2, birthdate);
            preparedStmt.setString(3, genre);
            preparedStmt.setString(4, disease);
            preparedStmt.setString(5, cause);
            preparedStmt.setString(6, cell);

            preparedStmt.executeUpdate();

            con.close();
        }catch(Exception e){
            System.out.println(e);
        }

        return recluse;
    }

    /**
     * Method that deletes all data from a recluse.
     *
     * @param id_recluse recluse's id
     * @return a boolean that indicates if the query was executed.
     */
    public boolean deleteRecluseDataByID(int id_recluse){
        boolean deleted = false;
        int worked = 0;


        try{
            String query = "DELETE FROM recluse WHERE id_recluse = ?;";
            preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, id_recluse);

            worked = preparedStmt.executeUpdate();

            con.close();
            return deleted;

        }catch(Exception e){
            System.out.println(e);
        }


        if(worked == 1){
            deleted = true;
        } else {
            deleted = false;
        }


        return deleted;
    }
}
