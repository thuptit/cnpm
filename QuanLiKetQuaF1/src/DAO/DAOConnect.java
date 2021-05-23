/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author thu
 */
public class DAOConnect {
    public static Connection cnn;
    public static String dbName = "qlkqf1";
    public static String username = "root";
    public static String password = "123456a@";

    public DAOConnect() {
        if(cnn == null){
            String dbUrl = "jdbc:mysql://localhost:3306/"+ dbName + "?autoReconnect=true&useSSL=false";
            String dbClass = "com.mysql.cj.jdbc.Driver";
            try {
                Class.forName(dbClass);
                cnn = DriverManager.getConnection (dbUrl, username, password);
                System.out.println(cnn);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
