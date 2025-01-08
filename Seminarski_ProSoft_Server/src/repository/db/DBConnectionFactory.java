/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author janja
 */
public class DBConnectionFactory {

    private static DBConnectionFactory instance;
    private Connection connection;

    private DBConnectionFactory() {
        connect();
    }

    public static DBConnectionFactory getInstance() {
        if (instance == null) {
            instance = new DBConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() {
        connect();
        return connection;
    }

    public void connect() {
        try {
            if (connection == null || connection.isClosed()) {
                String url = konfiguracija.Konfiguracija.getInstanca().getProperty("url");
                String username = konfiguracija.Konfiguracija.getInstanca().getProperty("username");
                String password = konfiguracija.Konfiguracija.getInstanca().getProperty("password");

                connection = DriverManager.getConnection(url, username, password);
                connection.setAutoCommit(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
