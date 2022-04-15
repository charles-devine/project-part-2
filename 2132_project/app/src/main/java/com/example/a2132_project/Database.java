package com.example.a2132_project;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private Connection connection;
    private final String host = "ec2-52-201-124-168.compute-1.amazonaws.com";
    private final String database = "d1ocutc4qmmtg5";
    private final int port = 5432;
    private final String user = "bzayemqizjaacm";
    private final String pass = "5c066b32fe076541c3845f6b76a62163a35d44de34b92f8e106799b080ca563b";
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;

    public Database() {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();
        System.out.println("connection status: " + status);
    }

    private void connect() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    System.out.println("connected: " + status);
                } catch (Exception e) {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }
    }

    public Connection getExtraConnection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
}
