package Area51;

import Area51.business.Recluse;
import Area51.dataaccess.DBConnection;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class main {
    public static void main(String args[]) {

       DBConnection connect = new DBConnection();
       //String recluse = connect.getRecluseDataByID(1).toString();
       //String officer = connect.getOfficerDataByID(1).toString();
       //String visitor = connect.getVisitorDataByID(1).toString();
       //System.out.println(recluse);
       //System.out.println(officer);
       //System.out.println(visitor);


       String recluse2 = connect.updateRecluseDataByID(1, "Lucas", 1-8-1998,
               "masculino", "Não", "Atropelou uma velha", "000").toString();



      System.out.println(recluse2);

        /**
       Recluse newRecluse = connect.newRecluse("Lenda", LocalDate.now(), "masculino", "Sim",
               "Roubo", "A20");
       System.out.println(newRecluse);**/





        //System.out.println(connect.deleteRecluseDataByID(5));
    }
}
