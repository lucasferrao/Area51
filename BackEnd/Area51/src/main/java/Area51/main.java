package Area51;

import Area51.business.Recluse;
import Area51.business.exceptions.WrongCredentialsException;
import Area51.dataaccess.DBConnection;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class main {
    public static void main(String args[]) throws WrongCredentialsException {

       DBConnection connect = new DBConnection();

            /**
             * Get recluse's date from database.
             **/
            //String recluse = connect.getRecluseDataByID(1).toString();
            //System.out.println(recluse);

            /**
             * Get officer's data from database.
             **/
            //String officer = connect.getOfficerDataByID(1).toString();
            //System.out.println(officer);


        /**
         * Update recluse
         */
        //String recluse2 = connect.updateRecluseDataByID(1, "Lucas", 1998-15-08,
          //     "masculino", "Não", "Atropelou uma velha", "000").toString();


        /**
         * Create recluse
         */
      // Recluse newRecluse = connect.newRecluse("Lenda", LocalDate.now(), "masculino", "Sim",
        //       "Roubo", "A20");
       //System.out.println(newRecluse);


        /**
         * Delete recluse
         */
        //System.out.println(connect.deleteDataByID(7, "recluse"));


        /**
         * Login
         */
        //System.out.println(connect.login("17342", "security17342"));






        //String visitor = connect.getVisitorDataByID(1).toString();
        //System.out.println(visitor);


    }
}
