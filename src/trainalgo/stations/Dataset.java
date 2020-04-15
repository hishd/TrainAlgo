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
import trainalgo.Codes;
import static trainalgo.TrainAlgo.REVERSED_LINKS;

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
    long startTime;
    long endTime;
    long executionTime;

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
        //getting the current time in nanoseconds
        startTime = System.nanoTime();
        while (rs.next()) {
            stationDataTreeMap.put(rs.getInt(1), rs.getString(2));
        }
        //getting the end time in nanoseconds
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("\n\n==Time Duration for Loading information to Dataset: " + (executionTime) + " nanoseconds==\n\n");

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

    public long getExecutionTime() {
        return executionTime;
    }

    //adding new Station Information to application data structure and adding the new information to DB
    public int addStationToStationInfoDatastruct(String StationName) throws SQLException {
        if (stationDataTreeMap == null) {
            initStationInfoDatastruct();
        }

        if (stationDB == null) {
            stationDB = new StationDB();
        }

        if (stationDataTreeMap.containsValue(StationName)) {
            return Codes.STATION_ALREADY_EXSISTS;
        }

        int stationID = lastStationID != 0 ? lastStationID + 1 : stationDB.getLastStationID() + 1;

        //getting the current time in nanoseconds
        startTime = System.nanoTime();
        stationDataTreeMap.put(stationID, StationName);
        //getting the end time in nanoseconds
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("\n\n==Time Duration for Inserting information to Dataset: " + (executionTime) + " nanoseconds==\n\n");

        //Test Code Snippet, Get all station information
//        for (Map.Entry<Integer, String> entry : stationDataTreeMap.entrySet()) {
//            System.out.println();
//            System.out.print("Station ID : \t ");
//            System.out.print(entry.getKey());
//            System.out.print("\tStation Name : \t ");
//            System.out.print(entry.getValue());
//        }
        if (stationDB.addStation(StationName)) {
            return Codes.STATION_ADDED;
        }
        return Codes.DB_NOT_UPDATED;

    }

    //update the old station information with the new station information on the application dataset
    public int updateStationInStationInfoDatastruct(String oldStation, String newStation) {

        int stationID = retrieveStationID(oldStation);

        if (stationID == 0) {
            return Codes.INVALID_STATION;
        }

        if (stationDB == null) {
            stationDB = new StationDB();
        }

        if (!stationDataTreeMap.containsValue(oldStation)) {
            return Codes.STATION_DOESNT_EXSISTS;
        }

        //getting the current time in nanoseconds
        startTime = System.nanoTime();
        stationDataTreeMap.put(stationID, newStation);
        //getting the end time in nanoseconds
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("\n\n==Time Duration for Updating information in Dataset: " + (executionTime) + " nanoseconds==\n\n");
        if (stationDB.updateStation(stationID, newStation)) {
            return Codes.STATION_UPDATED;
        } else {
            return Codes.DB_NOT_UPDATED;
        }
    }

    //Remove the station information from the application data structure and remove from DB
    public int removeStationInStationInfoDatastructure(String stationName) {

        int stationID = retrieveStationID(stationName);

        if (stationID == 0) {
            return Codes.INVALID_STATION;
        }

        if (stationDB == null) {
            stationDB = new StationDB();
        }

        if (!stationDataTreeMap.containsValue(stationName)) {
            return Codes.STATION_DOESNT_EXSISTS;
        }

        if (lastStationID == 0) {
            lastStationID = stationDB.getLastStationID();
        } else {
            lastStationID++;
        }
        //getting the current time in nanoseconds
        startTime = System.nanoTime();
        stationDataTreeMap.remove(stationID, stationName);
        //getting the end time in nanoseconds
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("\n\n==Time Duration for Deleting information in Dataset: " + (executionTime) + " nanoseconds==\n\n");
        if (stationDB.removeStation(stationID)) {
            return Codes.STATION_REMOVED;
        } else {
            return Codes.DB_NOT_UPDATED;
        }

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

        int stationCount = stationDB.getLastStationID()+1;

        stationPaths = new int[stationCount][stationCount];

        rs = stationDB.retriveAllStationLinks();

        //getting the current time in nanoseconds
        startTime = System.nanoTime();
        for (int row = 0; row < stationPaths.length; row++) {
            for (int col = 0; col < stationPaths[row].length; col++) {
                stationPaths[row][col] = 0;
            }
        }

        while (rs.next()) {
            stationPaths[rs.getInt(1)][rs.getInt(2)] = rs.getInt(3);
            if(REVERSED_LINKS)
                stationPaths[rs.getInt(2)][rs.getInt(1)] = rs.getInt(3);
        }

        //getting the end time in nanoseconds
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("\n\n==Time Duration for Loading information to Dataset: " + (executionTime) + " nanoseconds==\n\n");

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
        //getting the current time in nanoseconds
        startTime = System.nanoTime();
        stationPaths[stationAID][stationBID] = distance;
        //Reverse the connection
        if(REVERSED_LINKS)
            stationPaths[stationBID][stationAID] = distance;
        //getting the end time in nanoseconds
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("\n\n==Time Duration for Inserting information to Dataset: " + (executionTime) + " nanoseconds==\n\n");

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
        //getting the current time in nanoseconds
        startTime = System.nanoTime();
        stationPaths[stationAID][stationBID] = distance;
        if(REVERSED_LINKS)
            stationPaths[stationBID][stationAID] = distance;
        //getting the end time in nanoseconds
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("\n\n==Time Duration for Updating information in Dataset: " + (executionTime) + " nanoseconds==\n\n");

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

        //getting the current time in nanoseconds
        startTime = System.nanoTime();
        stationPaths[stationAID][stationBID] = 0;
        if(REVERSED_LINKS)
            stationPaths[stationBID][stationAID] = 0;
        //getting the end time in nanoseconds
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("\n\n==Time Duration for Deleting information in Dataset: " + (executionTime) + " nanoseconds==\n\n");

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
