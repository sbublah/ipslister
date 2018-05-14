/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package barcodereader;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Nadun
 */
public class DBClass {

    static private Connection  connection;

    public static Connection getConnection() throws Exception{
        if(connection == null){
            //JDBC
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/barcodereader?zeroDateTimeBehavior=convertToNull", "ips", "ips");
        }
        return connection;
    }

}
