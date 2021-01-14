package day3;

import utility.DB_Utility;

import static utility.DB_Utility.*;

public class SpartanDB_Practice {

    public static void main(String[] args) {
        // please create a package called utility
        // and move your DB_Utility under that package
        //  String url = "jdbc:oracle:thin:@54.159.102.128:1521:XE";
        //  DB_Utility.createConnection(url,"SP","SP");
        // DB_Utility.createConnection();
        DB_Utility.createConnection("dev");
//    Run query "SELECT * FROM SPARTANS"
        DB_Utility.runQuery("SELECT * FROM SPARTANS");
//    1. Display all data in console
        displayAllData();
//    2. Print column count
        System.out.println("column count is \n"+ getColumnCNT());
//    3. Print row count
        System.out.println( "row count is \n"+getRowCount());
//    4. Print out 3rd row data as a list
        System.out.println("3rd  row data as list \n"+ getRowDataAsList(3));
//    5. Print out 2nd column data as a list
        System.out.println("2nd column as a list \n"+ getColumnDataAsList(3));
//    6, Print out Name column data as a list
        System.out.println("NAME column as a list \n" + getColumnDataAsList("NAME"));
//    7, Print out 4th row as a Map
        System.out.println("4th row as a map \n"+ getRowMap(4));
//    8, Print out the data at row 5, column 1
        System.out.println("DATA at row 5 column 1 \n" + getColumnDataAtRow(5,1));
//    9, Print out the data at row 53, phone column
        System.out.println("Data at row 53 phone column \n"+getColumnDataAtRow(53,"PHONE"));
//    10. Print out all the data as List of Map
        //WE ARE STORING EACH ROW AS MAP OBJECT
        //and we have 108 row, so can store this 100 map object into one collection
        // list of these map object List<Map>String, String>>
        System.out.println("Data as a list of map \n"+ getAllDataAsListOfMap());
//
        destroy();
    }
}
