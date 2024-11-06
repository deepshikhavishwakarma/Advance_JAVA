
/*
* Construct JDBC Application to read BankDetails and insert into Database table.
* JDBC perform Auto commit operation
* */

package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class DBCon3 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("=================Read Coutomer Details==================");

            System.out.println("Enter the Customer Account Number");
            long accNo = Long.parseLong(sc.nextLine());
             System.out.println("Enter the Customer Name");
            String custName = sc.nextLine();
             System.out.println("Enter the Customer Amount ");
            long bal = Long.parseLong(sc.nextLine());
             System.out.println("Enter the Customer Account Type");
            String accType = sc.nextLine();

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","TIGER");
            Statement stm = con.createStatement();
            int k = stm.executeUpdate("insert into BankDetails02 values("+accNo+",'"+custName+"',"+bal+",'"+accType+"')");
           if(k>0){
               System.err.println("Customer details added successfully.");
           }


           ResultSet rs = stm.executeQuery("Select * from BAnkDetails02");
            System.out.println("\n=================Bank-Details===============");
           while (rs.next()){
               System.out.print("        "+rs.getLong(1));
               System.out.print("        "+rs.getString(2));
               System.out.print("        "+rs.getFloat(3));
               System.out.print("        "+rs.getString(4));
               System.out.println();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
