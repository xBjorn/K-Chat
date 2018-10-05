/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kchatfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bw
 */
public class ConnectionK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String connectString = "jdbc:mysql://localhost:3306/bjornwebsite?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=nova123";
        String query = "SELECT * FROM accounts";
        //Test the driver on the url
        try (Connection con = DriverManager.getConnection(connectString);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query)) {
            //If query succeeds
            if (rs.next()) {
                
                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {
            
            Logger lgr = Logger.getLogger(ConnectionK.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } 
    }
}
    

