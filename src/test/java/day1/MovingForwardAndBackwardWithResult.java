package day1;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
public class MovingForwardAndBackwardWithResult {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@54.159.102.128:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        // if we create the Statement in this way , this will generate a forward only resultSet
        // meaning we can only move forward with next() and can not move backward with previous
        //Statement stmnt = conn.createStatement();
        // ResultSet.TYPE_SCROLL_INSENSITIVE will make the resultSet created from this statement
        // be able to move forward and backward ,
        // ResultSet.CONCUR_READ_ONLY  will make resultSet readonly and that's what we need
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY) ;
        //ResultSet rs   =   stmnt.executeQuery("SELECT * FROM COUNTRIES WHERE REGION_ID = 1") ;
        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM COUNTRIES") ;
        rs.next() ;
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));
        rs.next() ;
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));
        rs.previous();
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));
        // rs.previous();
        //   System.out.println(rs.getString("country_id")+" "+rs.getString("country_name"));
        //moving to the last row directly
        rs.last();//this will move the cursor to the last location
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));
        rs.first();//this will move the cursor to the first location
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));
        rs.absolute(5);
//this will move the cursor to the fifth location
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));
        //how to move to before first row location
        rs.beforeFirst();
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));
        // how to move to after last row location
        rs.afterLast();
        rs.close();
        stmnt.close();
        conn.close();
        System.out.println("THE END");
    }
}
