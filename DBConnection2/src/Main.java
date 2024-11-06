import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter the customer AccNo to reterive details: ");
           long aNo = sc.nextLong();
           Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","TIGER");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("Select * from BankDetails02 where AccNo = "+aNo+" ");
            if(rs.next()){
                System.out.println("Customer AccNo: "+rs.getLong(1));
                System.out.println("Customer Name: "+rs.getString(2));
                System.out.println("Customer AccNo: "+rs.getFloat(3));
                System.out.println("Customer AccNo: "+rs.getString(4));
            }else{
                System.out.println("Invalid Account Number . Please check your Account Number.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}