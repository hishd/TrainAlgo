/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainalgo.stations;

import DB.StationDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Hishara
 */
public class Dataset {

    //Train Station Information Data Structure [TreeMap]
    private Map<Integer, String> stationDataHashMap;
    //Train Station Links Data Structure [Graphs] [Adjcent Matrix - 2D Array]
    private int[][] stationPaths;
    StationDB stationDB;
    ResultSet rs;

    
    //Load Train Station Data from DB to Application Data Structure
    public void initStationInfoDatastruct() throws SQLException {
        stationDataHashMap = new TreeMap<>();
        stationDB = new StationDB();
        rs = stationDB.retriveAllStationsInfo();

        while (rs.next()) {
            stationDataHashMap.put(rs.getInt(1), rs.getString(2));
        }
        
        //Test Code Snippet, Get all station information
//        for (Map.Entry<Integer, String> entry : stationDataHashMap.entrySet()) {
//            System.out.println();
//            System.out.print("Station ID : \t ");
//            System.out.print(entry.getKey());
//            System.out.print("\tStation Name : \t ");
//            System.out.print(entry.getValue());
//        }

    }

    //Load Train Station Links(Edges) from DB to Application Data Structure
    public void initStationPathDatastruct() throws SQLException {
        if (stationDB == null) {
            stationDB = new StationDB();
        }

        int stationCount = stationDB.getLastStationID();

        stationPaths = new int[stationCount][stationCount];

        rs = stationDB.retriveAllStationLinks();

        for (int row = 0; row < stationPaths.length; row++) {
            for (int col = 0; col < stationPaths[row].length; col++) {
                stationPaths[row][col] = 0;
            }
        }

        while (rs.next()) {
            stationPaths[rs.getInt(1)][rs.getInt(2)] = rs.getInt(3);
        }

        //Test Code Snippet, Get all links with distance
//        for (int row = 0; row < stationPaths.length; row++) {
//            for (int col = 0; col < stationPaths[row].length; col++) {
//                if(stationPaths[row][col] > 0)
//                {
//                    System.out.print("\n");
//                    System.out.print(row);
//                    System.out.print(" -> ");
//                    System.out.print(col);
//                    System.out.print(" = ");
//                    System.out.print(stationPaths[row][col]);
//                }
//            }
//        }
    }

}
