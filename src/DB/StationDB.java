/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.*;

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

    
    //Initialize connection with DB
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

    //Add new Train Station information to DB
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

    
    //Add a link between Train Stations
    public boolean addStationLink(int stationA, int stationB, int distance) {
        if (conn == null) {
            initCon();
        }
        try {
            ps = conn.prepareStatement("INSERT INTO tbl_connections(station_1,station_2,distance) VALUES(" + stationA + "," + stationB + "," + distance + ")");
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

    //Retrieves the last station ID from DB
    public int getLastStationID() {
        ResultSet rs = null;

        if (conn == null) {
            initCon();
        }
        try {
            ps = conn.prepareStatement("SELECT station_id FROM tbl_stations ORDER BY station_id DESC LIMIT 1");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);

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

    //Retrieve all Train Station information from DB
    public ResultSet retriveAllStationsInfo() {
        if (conn == null) {
            initCon();
        }
        try {
            ps = conn.prepareStatement("SELECT station_id,station_name FROM tbl_stations ORDER BY station_id ASC");
            return ps.executeQuery();

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Retrieve all Train Station links from DB
    public ResultSet retriveAllStationLinks() {
        if (conn == null) {
            initCon();
        }
        try {
            ps = conn.prepareStatement("SELECT station_1,station_2,distance FROM tbl_connections");
            return ps.executeQuery();

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
