package day2;

import utility.DB_Utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Practice2 {
    public static void main(String[] args) throws SQLException {
        //print out all data from Jobs Table
        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("select * from regions");
        DB_Utility.displayAllData();
        rs.absolute(2);
    /*// in order to get whole result
    int colCount = DB_Utility.getColumnCNT();
    while(rs.next()) {//row iteration
        for (int i = 1; i <= colCount; i++) {
            System.out.print(rs.getString(i) + "\t");
        }
        System.out.println();
    }*/
        // DB_Utility.runQuery("SELECT * FROM EMPLOYEES WHERE SALARY>19000");
        DB_Utility.displayAllData();
        System.out.println(DB_Utility.getColumnDataAtRow(3, 2));
        System.out.println(DB_Utility.getColumnDataAtRow(3,"region_name"));
        System.out.println(DB_Utility.getRowDataAsList(4));
        System.out.println(DB_Utility.getRowCount());
        DB_Utility.runQuery("select* from employees");
        System.out.println(DB_Utility.getRowCount());
        System.out.println(DB_Utility.getColumnDataAsList(2));
        System.out.println(DB_Utility.getColumnDataAsList("EMPLOYEE_ID"));
        DB_Utility.destroy();
    }
}
