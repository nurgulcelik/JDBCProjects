package day2;

import utility.DB_Utility;

import java.sql.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DB_Practice3 {
    public static void main(String[] args) throws SQLException {
        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("SELECT * FROM REGIONS") ;
        rs.next();
        Map<String,String> rowMap = new HashMap<>();
        // rowMap.put("REGION_ID","1");
        // rowMap.put("REGION_NAME","Europe");
        //rowMap.put("REGION_ID",rs.getString(1));
        // rowMap.put("REGION_NAME",rs.getString(2));
        ResultSetMetaData rsmd= rs.getMetaData();
        for(int i=1; i<= rsmd.getColumnCount(); i++){
            //System.out.println(rsmd.getColumnName(i));
            rowMap.put(rsmd.getColumnName(i), rs.getString(i));
        }
        System.out.println("rowMap = "+ rowMap);
        DB_Utility.destroy();
    }
}
