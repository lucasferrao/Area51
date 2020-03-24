package Area51;

import Area51.dataaccess.DBConnection;

public class main {
    public static void main(String args[]) {

       DBConnection connect = new DBConnection();
       String recluse = connect.getRecluseDataByID(1).toString();
       String officer = connect.getOfficerDataByID(1).toString();
       System.out.println(recluse);
       System.out.println(officer);



    }
}
