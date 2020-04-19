package area51;

import area51.business.exceptions.WrongCredentialsException;
import area51.dataaccess.DBConnection;

public class main {
    public static void main(String args[]) throws WrongCredentialsException {

       DBConnection connect = new DBConnection();

            /**
             * Get recluse's date from database.
             **/
            /**
            String recluse = connect.getRecluseDataByID(1).toString();
            System.out.println(recluse);
             **/

            /**
             * Get officer's data from database.
             **/
            /**
            String officer = connect.getOfficerDataByID(1).toString();
            System.out.println(officer);
             **/


        /**
         * Update recluse
         */
        /**
        String recluse2 = connect.updateRecluseDataByID(1, "Lucas", LocalDate.ofEpochDay(1999-10-01),
               "masculino", "Não", "roubo", "A10").toString();
         **/


        /**
         * Create recluse
         */
        /**
       Recluse newRecluse = connect.newRecluse("Lenda", LocalDate.now(), "masculino", "Sim",
               "Roubo", "A20");
       System.out.println(newRecluse);
         **/


        /**
         * Delete recluse
         */
        //System.out.println(connect.deleteDataByID(7, "recluse"));


        /**
         * Login
         */
        //System.out.println(connect.login("17342", "security17342"));











        /**
         * Get data from a table
         */
        /**
        String visitor = connect.getVisitorDataByID(1).toString();
        System.out.println(visitor);
         **/


    }
}
