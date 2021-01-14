package day1;

import java.sql.*;

public class IteratingPractice {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@54.159.102.128:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement();
        ResultSet rs = stmnt.executeQuery("SELECT * FROM COUNTRIES");
        while(rs.next()){
            System.out.println(rs.getString("COUNTRY_ID")
                    +" "+ rs.getString("COUNTRY_NAME")
                    +" "+rs.getInt("REGION_ID"));
        }
        //order we created
        //connection --. statement --> resultset
        // order when we close
        //resultSet--> statement --> connection
        //TO AVOID ISSUE , WE NEED TO CLOSE OPPOSITE OF THE ORDER
        rs.close();
        stmnt.close();
        conn.close();
        System.out.println("THE END");
    }
}
