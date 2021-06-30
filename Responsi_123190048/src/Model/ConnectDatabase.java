package Model;

import java.sql.*;

public class ConnectDatabase {

    static String DBurl = "jdbc:mysql://localhost/movie_db";
    static String DBusername = "root";
    static String DBpass = "";
    static Connection koneksi;
    Statement statement;

    public static Connection Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpass);
            System.out.println("Koneksi Berhasil");
        } catch (Exception ex) {
            System.out.println("Koneksi gagal");
        }
        return koneksi;
    }
    
    
}
