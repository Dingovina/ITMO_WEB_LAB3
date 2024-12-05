package app.managers;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import app.beans.PointBean;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named("dbManager")
@ManagedBean
@ApplicationScoped
public class DataBaseManager {
    private String HOST_NAME = "localhost";
    private String PORT = "5432";
    private String DB_NAME = "lab3storage";
    private String TABLE_NAME = "points";

    
    private String url = "jdbc:postgresql://" + HOST_NAME + ":" + PORT + "/" + DB_NAME;
    private Properties props = new Properties();
    
    private static Connection connection;
    private Statement statement;
    
    public DataBaseManager() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        Class.forName("org.postgresql.Driver");
        props.load(new FileInputStream("db.cfg"));
        if (connection == null){
            connection = DriverManager.getConnection(url, props);
        }
        statement = connection.createStatement();
        createTable();        
    }

    private void createTable() throws SQLException {
        System.out.println("Creating table...");
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (\n" +
                        "  id SERIAL PRIMARY KEY,\n" +
                        "  x double precision,\n" +
                        "  y double precision,\n" +
                        "  r double precision,\n" +
                        "  hit boolean,\n" +
                        "  drawn boolean\n" +
                        ")";
        statement.executeUpdate(query);
    }
    
    public void addPoint(PointBean point) throws SQLException {
        createTable();
        String query = "INSERT INTO " + TABLE_NAME + " (x, y, r, hit, drawn)\n" +
                        "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setDouble(1, point.getX());
            ps.setDouble(2, point.getY());
            ps.setDouble(3, point.getR());
            ps.setBoolean(4, point.isHit());
            ps.setBoolean(5, point.isDrawn());
            ps.executeUpdate();
        }
    }
    
    public ArrayList<PointBean> getPoints() throws SQLException {
        String query = "SELECT x, y, r, hit, drawn\n" +
                        "FROM " + TABLE_NAME;
        ArrayList<PointBean> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new PointBean(rs.getDouble(1), rs.getDouble(2), rs.getDouble(3), rs.getBoolean(4), rs.getBoolean(5)));
                }
            }
            catch (SQLException e) {
                return null;
            }
        }
        catch (SQLException e) {
            return null;
        }
        return list;
    }

    public String echo(){
        return "echo";
    }
}

