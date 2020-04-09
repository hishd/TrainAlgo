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
    private static Map<Integer, String> stationDataTreeMap;

    //Train Station Links Data Structure [Graphs] [Adjcent Matrix - 2D Array]
    private int[][] stationPaths;

    StationDB stationDB;
    ResultSet rs;
    int lastStationID = 0;

    /*
    *
    *   Station Information dataset
    *
     */
    //Load Train Station Data from DB to Application Data Structure
    public void initStationInfoDatastruct() throws SQLException {
        stationDataTreeMap = new TreeMap<>();
        stationDB = new StationDB();
        rs = stationDB.retriveAllStationsInfo();

        while (rs.next()) {
            stationDataTreeMap.put(rs.getInt(1), rs.getString(2));
        }

        //Test Code Snippet, Get all station information
//        for (Map.Entry<Integer, String> entry : stationDataTreeMap.entrySet()) {
//            System.out.println();
//            System.out.print("Station ID : \t ");
//            System.out.print(entry.getKey());
//            System.out.print("\tStation Name : \t ");
//            System.out.print(entry.getValue());
//        }
    }

    public Map<Integer, String> getStationDataTreeMap() {
        return stationDataTreeMap;
    }

    //adding new Station Information to application data structure and adding the new information to DB
    public boolean addStationToStationInfoDatastruct(String StationName) throws SQLException {
        if (stationDataTreeMap == null) {
            initStationInfoDatastruct();
        }

        if (stationDB == null) {
            stationDB = new StationDB();
        }

        int stationID = lastStationID != 0 ? lastStationID + 1 : stationDB.getLastStationID() + 1;

        stationDataTreeMap.put(stationID, StationName);

        //Test Code Snippet, Get all station information
//        for (Map.Entry<Integer, String> entry : stationDataTreeMap.entrySet()) {
//            System.out.println();
//            System.out.print("Station ID : \t ");
//            System.out.print(entry.getKey());
//            System.out.print("\tStation Name : \t ");
//            System.out.print(entry.getValue());
//        }
        return stationDB.addStation(StationName);

    }

    //update the old station information with the new station information on the application dataset
    public boolean updateStationInStationInfoDatastruct(String oldStation, String newStation) {

        int stationID = retrieveStationID(oldStation);

        if (stationID == 0) {
            return false;
        }

        if (stationDB == null) {
            stationDB = new StationDB();
        }

        stationDataTreeMap.put(stationID, newStation);

        return stationDB.updateStation(stationID, newStation);
    }

    //Remove the station information from the application data structure and remove from DB
    public boolean removeStationInStationInfoDatastructure(String stationName) {

        int stationID = retrieveStationID(stationName);

        if (stationID == 0) {
            return false;
        }

        if (stationDB == null) {
            stationDB = new StationDB();
        }

        if (lastStationID == 0) {
            lastStationID = stationDB.getLastStationID();
        }

        stationDataTreeMap.remove(stationID, stationName);

        return stationDB.removeStation(stationID);
    }

    /*
    *
    *   Station Links(edges) dataset
    *
     */
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

    public int[][] getStationPaths() {
        return stationPaths;
    }

    //adding new station links(edges) to application data structure and adding new path information to DB
    public boolean addStationPathToDataStruct(String stationA, String stationB, int distance) throws SQLException {

        int stationAID = retrieveStationID(stationA);
        int stationBID = retrieveStationID(stationB);

        if (stationAID == 0 || stationBID == 0) {
            return false;
        }

        if (stationPaths == null) {
            initStationPathDatastruct();
        }

        if (stationDB == null) {
            stationDB = new StationDB();
        }

        stationPaths[stationAID][stationBID] = distance;

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
        return stationDB.addStationLink(stationAID, stationBID, distance);
    }

    //updating existing station links(edges) in application data structutre and adding updated information to DB
    public boolean updateStationPathInDataStructure(String stationA, String stationB, int distance) {

        int stationAID = retrieveStationID(stationA);
        int stationBID = retrieveStationID(stationB);

        if (stationAID == 0 || stationBID == 0) {
            return false;
        }

        if (stationDB == null) {
            stationDB = new StationDB();
        }

        stationPaths[stationAID][stationBID] = distance;

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
        return stationDB.updateStationLink(stationAID, stationBID, distance);
    }

    //removes the station links(edges) in application data structure and remove the link from DB
    public boolean removeStationPathInDatastructure(String stationA, String stationB) {

        int stationAID = retrieveStationID(stationA);
        int stationBID = retrieveStationID(stationB);

        if (stationAID == 0 || stationBID == 0) {
            return false;
        }

        stationPaths[stationAID][stationBID] = 0;

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
        return stationDB.removeStationLink(stationAID, stationBID);
    }

    //Get the stationID from the Application Datastructure
    public int retrieveStationID(String stationName) {

        for (Map.Entry<Integer, String> entry : stationDataTreeMap.entrySet()) {
            if (entry.getValue().equals(stationName)) {
                return entry.getKey();
            }
        }

        System.out.println("Station : " + stationName + " not found");
        return 0;
    }
}
