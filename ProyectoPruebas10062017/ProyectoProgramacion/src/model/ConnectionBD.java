package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionBD {
    public static Connection connection;
    
    public ConnectionBD(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:BD/VideoClub.bd");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnectionBD(){
        if ( connection == null)
            new ConnectionBD();
        return connection;
    }
}
