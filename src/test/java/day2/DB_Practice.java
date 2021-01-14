package day2;

import utility.DB_Utility;
import java.sql.*;
public class DB_Practice {
    public static void main(String[] args) throws SQLException {
        //print out all data from Jobs Table
        DB_Utility.createConnection();
        ResultSet rs= DB_Utility.runQuery("select * from jobs");
        DB_Utility.displayAllData();
        //iterate over the resultSet
        // rs.next();
        // System.out.println(rs.getString(1));
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
        //what if we want to print out everything in the resultSet
        //without knowing the column names
        System.out.println( "colCount= "+ DB_Utility.getColumnCNT());
        //get the first row data | without knowing the column names
        int colCount = DB_Utility.getColumnCNT();
        rs.first();
        for(int i=1; i<= colCount; i++){
            System.out.print(rs.getString(i) + "\t");
        }
        DB_Utility.destroy();
    }
}
