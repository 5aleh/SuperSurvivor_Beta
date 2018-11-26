package supersurviver;

import java.awt.*;
import java.io.Serializable;
import java.sql.*;

public class DatabaseBean<pubic> implements Serializable {

    private static String url = "jdbc:sqlite:SuperSurvivorDB.db";
//    private static String url = "jdbc:sqlite:C:\\Users\\Nkwabo Saleh\\Documents\\Windowing class\\SuperSurvivor_Beta\\SuperSurvivor_Beta\\SuperSurvivorDB.db";

    public DatabaseBean(){

        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite Database has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void WriteUser(User usr){
        String u = usr.getUname();
        String p = usr.getPass();
        String sql = "INSERT INTO User(uname,pass) VALUES(?,?)";
        try (Connection conn = DriverManager.getConnection(url)) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, u);
                pstmt.setString(2, p);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void WriteScenes(Scenes scn){
        String n = scn.getSname();
        int img = scn.getIid();
        String t = scn.getText();
        int op = scn.getOptions();
        String sql = "INSERT INTO Scenes(sname,iid,text,options) VALUES(?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url)) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, n);
                pstmt.setInt(2, img);
                pstmt.setString(3,t);
                pstmt.setInt(4,op);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void WriteDeath(Death d){
        int u = d.getUid();
        int s = d.getSid();
        int num = d.getDeaths();
        String sql = "INSERT INTO Deaths(uid,sid,deaths) VALUES(?,?,?)";
        try (Connection conn = DriverManager.getConnection(url)) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, u);
                pstmt.setInt(2,s);
                pstmt.setInt(3,num);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static User RetrieveUser(int id){
        String sql = "SELECT id,uname,pass FROM User WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            int tid = rs.getInt("id");
            String tname = rs.getString("uname");
            String tpass = rs.getString("pass");
            User temp = new User(tid,tname,tpass);
            return temp;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            User temp = new User(-1,"fail","fail");
            return temp;
        }
    }

    public static Death RetrieveDeath(int id){
        String sql = "SELECT uid,sid,deaths FROM Death WHERE uid = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            int tuid = rs.getInt("uid");
            int tsid = rs.getInt("sid");
            int tdeaths = rs.getInt("deaths");
            Death temp = new Death(tuid,tsid,tdeaths);
            return temp;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Death temp = new Death(-1,-1,-1);
            return temp;
        }
    }

    public static Scenes RetrieveScenes(int id){
        String sql = "SELECT sid,sname,iid,text,options FROM Scenes WHERE sid = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            int tsid = rs.getInt("sid");
            String tsname = rs.getString("sname");
            int tiid = rs.getInt("iid");
            String ttext = rs.getString("text");
            int top = rs.getInt("id");
            Scenes temp = new Scenes(tsid,tsname,tiid,ttext,top);
            return temp;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Scenes temp = new Scenes(-1,"",-1,"",-1);
            return temp;
        }
    }

    public static Images RetrieveImages(int id){
        String sql = "SELECT iid,ipath FROM Images WHERE iid = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            int tiid = rs.getInt("iid");
            String tpath = rs.getString("ipath");
            Images temp = new Images(tiid,tpath);
            return temp;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
           Images temp = new Images(-1,"");
            return temp;
        }
    }


}
