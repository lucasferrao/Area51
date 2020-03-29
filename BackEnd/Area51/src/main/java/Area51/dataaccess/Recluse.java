package Area51.dataaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class Recluse {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Area51.business.Recluse getRecluseDataByID(int id_recluse){
        Area51.business.Recluse recluse = new Area51.business.Recluse();

        try{
            String query = "SELECT * FROM recluse WHERE id_recluse = " + id_recluse;
            rs = st.executeQuery(query);
            System.out.println("Records from Database");

            while(rs.next()){
                String recluse_name = rs.getString("recluse_name");
                LocalDate birthdate = rs.getObject("birthdate", LocalDate.class);
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
}
