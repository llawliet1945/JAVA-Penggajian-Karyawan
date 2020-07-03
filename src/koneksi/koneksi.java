package koneksi;

import java.sql.*;
public class koneksi {
    private static Connection connect;
    public static Connection koneksi(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection Succes");
        }catch(ClassNotFoundException ex){
            System.out.println("Connection Failed " + ex);
        }
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost/pegawai","root","");
            System.out.printf("Berhasil KONEK DB");
        }catch(SQLException ex){
            System.out.println("Connection Failed " + ex);
        }    return connect;
    }
}
