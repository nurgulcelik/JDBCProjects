package day4;

import utility.DB_Utility;

public class My_SQL_Test {
    public static void main(String[] args) {
    /*
    host IP for all environements18.233.97.71host url for all environementsec2-18-233-97-71.compute-1.amazonaws.comport number3306
    database type mysqlqa1 database
    namelibrary1qa1
    usernamelibrary1_client
    qa1 passwordWVF4NdGXCKHeE6VQJDBC
    Connction Stringjdbc:mysql://18.233.97.71:3306/library1qa2 database
    namelibrary2qa2
    usernamelibrary2_clientqa2
    password6s2LQQTjBcGFfDhYJDBC Connction Stringjdbc:mysql://18.233.97.71:3306/library2qa3 database namelibrary3qa3
    usernamelibrary3_clientqa3
    passwordPzi75akktLC4BoI9
     */
        // added mysql pom dependency for mysql driver
        // we provided connection string , username password
        // and used the utility to make connection
        String connectionStr = "jdbc:mysql://18.233.97.71:3306/library1";
        String username = "library1_client" ;
        String password = "WVF4NdGXCKHeE6VQ" ;
        // String connectionStr = "jdbc:mysql://18.233.97.71:3306/library3";
        // String username = "library3_client";
        // String password = "Pzi75akktLC4BoI9";
        DB_Utility.createConnection(connectionStr,username,password);
        DB_Utility.destroy();
    }
}
