import java.sql.*;

import static java.lang.Class.forName;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","TIGER");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("Select * from BankCustomer01");
            System.out.println("---------------Customer Details--------------");
            while(rs.next()){
                System.out.println(rs.getLong(1)+"   \t"+rs.getString(2)+"      \t"+rs.getLong(3)+"     \t"+rs.getString(4));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}