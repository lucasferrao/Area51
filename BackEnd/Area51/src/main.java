import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {
    public static void main(String args[]){
        try{
            Class.forName("remotemysql.com");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mGSj7yInIt","mGSj7yInIt","YKEJ9H5Bdn");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Recluse");
            System.out.println(rs.getString(0));
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}

