package org.example.persistence.util;

import org.example.Main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CheckConnection {

    public void checkConnection() {
        Properties prop = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            // Load a properties file from class path, inside static method
            prop.load(input);
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");
            try (Connection conn = DriverManager.getConnection(url, user,
                    password)) {
                System.out.println("Connected to the database successfully");
                conn.close();

            } catch (SQLException e) {

                System.out.println("Error connecting to the database");

                e.printStackTrace();


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
