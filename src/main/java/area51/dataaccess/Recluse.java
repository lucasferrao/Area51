package area51.dataaccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class Recluse {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    /**
     * Method that gives data from a recluse.
     *
     * @param id_recluse recluse's id
     * @return recluse's data
     */
    public area51.business.Recluse getRecluseDataByID(int id_recluse){
        area51.business.Recluse recluse = new area51.business.Recluse();

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
}
