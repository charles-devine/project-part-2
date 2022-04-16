# CSI 2132 - Deliverable 2

## INCLUDED IN THE REPO: 
```
1. Project folder with all files used 
2. Folder with all Java and XML files (stylesheets, html for Android Studio)
3. APK "app-debug.apk", "output-metadata.json"
4. README.md
```

## NOTE: 
```
1. UI is functional 
2. Database is fully functional 
3. UI connection to Database is NOT functional 
4. Database calls within Android Studio (UI backend) is functional, but main connection does not work. 

See examples of DB connection and Connecting Android Studio values to the PostGreSQL server-side below. 
```

## DATABASE.JAVA
```java

package com.example.a2132_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        getExtraConnection();
        System.out.println("getExtraConnection status: " + status);
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

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected to the PostGreSQL server successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
 ```
## AddPatientInfo (Database instance usage): 
```java
        /* set appointment activity */
        add_patient = (Button) findViewById(R.id.add_patient_info_btn);
        add_patient.setOnClickListener(
            new View.OnClickListener() {
                public void onClick(View v) {
                    Database db = new Database();
                    validateCredentials();
                    Patient patient = new Patient(
                        firstName,
                        middleName,
                        lastName,
                        houseNumber,
                        street,
                        city,
                        province,
                        password,
                        ssn,
                        gender,
                        email,
                        dateOfBirth,
                        insurance
                    );
                    String SQLQuery = "INSERT INTO local.patient (user_id,first_name,middle_name,last_name,house_number,street,city,province,password,ssn,gender,email,date_of_birth,insurance) "
                            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    long id = 0;
                    try (Connection manager = db.getExtraConnection();
                         PreparedStatement pstmt = manager.prepareStatement(SQLQuery, Statement.RETURN_GENERATED_KEYS)) {
                        pstmt.setString(1, patient.getFirstName());
                        pstmt.setString(2, patient.getMiddleName());
                        pstmt.setString(3, patient.getLastName());
                        pstmt.setString(4, String.valueOf(patient.getHouseNumber()));
                        pstmt.setString(5, patient.getStreet());
                        pstmt.setString(6, patient.getCity());
                        pstmt.setString(7, patient.getProvince());
                        pstmt.setString(8, patient.getPassword());
                        pstmt.setString(9, String.valueOf(patient.getSsn()));
                        pstmt.setString(10, patient.getGender());
                        pstmt.setString(11, patient.getEmail());
                        pstmt.setString(12, patient.getDateOfBirth());
                        pstmt.setString(13, String.valueOf(patient.getInsurance()));

                        int affectedRows = pstmt.executeUpdate();
                        if (affectedRows > 0) {
                            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                                if (rs.next()) {
                                    id = rs.getLong(1);
                                }
                            } catch (SQLException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    } catch (SQLException e) {
                        Util.alert(e.getMessage(), AddPatientInfo.this);
                    }
//                    Util.alert("Patient added.", AddPatientInfo.this);
                }
            }
        );```
