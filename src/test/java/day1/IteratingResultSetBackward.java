package day1;
 import java.sql.*;
public class IteratingResultSetBackward {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@54.159.102.128:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY) ;
        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM REGIONS") ;
        //first move to the after last location
        //then keep moving to previous row as long as there is more row above
        rs.afterLast();
        // rs.previous();
        //System.out.println(rs.getString(1)+" "+rs.getString(2));
        while(rs.previous()){
            System.out.println(rs.getString(1)+" "+rs.getString(2));
        }
        rs.absolute(2);
        System.out.println(rs.getString(1)+" "+rs.getString(2));
        rs.first();
        System.out.println(rs.getString(1) + " " + rs.getString(2));
        rs.last();
        System.out.println(rs.getString(1) + " " + rs.getString(2));
        //how do i know which row number i am right now at this location
        System.out.println("rs.getRow() = "+ rs.getRow());
        rs.close();
        stmnt.close();
        conn.close();
    }
}
