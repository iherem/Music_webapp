/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Computer
 */
public class ConnectionBuilder {
    public static Connection getConnectionBuilder() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        boolean reconectDB = false;
        do {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://54.254.240.46:3306/annymusic?zeroDateTimeBehavior=convertToNull&characterEncoding=UTF-8", "annymusic", "annymusic");
                reconectDB = false;
            } catch (com.mysql.jdbc.CommunicationsException cm) {
                reconectDB = true;
                
            } catch(com.mysql.jdbc.exceptions.jdbc4.CommunicationsException ex){
                reconectDB = true;
            }
        } while (reconectDB);
        return conn;
    }
    
    public static void main(String[] args) {
        try {

            Connection conn = ConnectionBuilder.getConnectionBuilder();
            System.out.println("can connect to database");
            //getColsName(conn, "APP", "CUSTOMER");
            System.out.println("----------------");
            
            conn.close();
        } catch (Exception ex) {
            System.out.println("cant connect to database");
        }
    }
    
    
}
