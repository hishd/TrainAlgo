/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hishara
 */
public class StationDB {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3308/traindb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    Connection conn;
    PreparedStatement ps;

    public void initCon() {
        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addStation(String stationName) {
        if (conn == null) {
            initCon();
        }
        try {
            ps = conn.prepareStatement("INSERT INTO tbl_stations(station_name) VALUES('" + stationName + "') ");
            if (ps.executeUpdate() > 0) {
                System.out.println("Insertion Successful for Station name : " + stationName);
                return true;
            }

            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return false;
    }
    
    public boolean addStationLink(int stationA, int stationB) {
        if (conn == null) {
            initCon();
        }
        try {
            ps = conn.prepareStatement("INSERT INTO tbl_connections(station_1,station_2) VALUES(" + stationA + "," + stationB + ")");
            if (ps.executeUpdate() > 0) {
                System.out.println(stationA + " and " + stationB + " link established");
                return true;
            }

            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return false;
    }
    
    public int getStationCount(){
        ResultSet rs = null;

        if (conn == null) {
            initCon();
        }
        try {
            ps = conn.prepareStatement("SELECT COUNT(*) AS rowcount FROM tbl_stations");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt("rowcount");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return 0;
    }

    public ArrayList<String> retriveAllStations() {

        ResultSet rs = null;
        ArrayList<String> stations = new ArrayList<>();

        if (conn == null) {
            initCon();
        }
        try {
            ps = conn.prepareStatement("SELECT * FROM tbl_stations");
            rs = ps.executeQuery();
            
            while(rs.next())
                stations.add(rs.getString(0));
            
            return stations;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return stations;
    }

}
