/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainalgo.stations;

import DB.StationDB;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Hishara
 */
public class Stations {

    //Testing Code Snippet
    //Inserting Test Values
    private String fileName = "stations.txt";

    //inserting some sample data fetched from a txt file
    public void insertSampleData() {
        File file = new File(fileName);

        try {
            Scanner s = new Scanner(file);
            StationDB db = new StationDB();
            int i = 0;

            while (s.hasNextLine()) {
                if (db.addStation(s.nextLine())) {
                    i++;
                }
            }

            if (i > 0) {
                System.out.println("\n\nRead Success, Total Stations : " + String.valueOf(i));
            } else {
                System.out.println("\n\nNo Stations Found");
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //generate random links between stations
    public void linkSampleData(int noOfLinks) {
        StationDB db = new StationDB();
        Random rand = new Random();
        int stationA, stationB;
        int stationCount = db.getLastStationID();
        int generatedLinksCount = 0;

        if (stationCount < 1) {
            return;
        }

        if (noOfLinks > (stationCount * (stationCount - 2))) {
            System.out.println("Cant Generate Links due to lack of Station Data | Possible links = " + String.valueOf(((stationCount * (stationCount - 2)))));
        } else {
            ArrayList<String> insertedStations = new ArrayList<>(stationCount);
            
            

            while (generatedLinksCount < noOfLinks) {
                stationA = rand.nextInt(stationCount);
                stationB = rand.nextInt(stationCount);

                while (stationA==0 || stationB==0 ||stationA == stationB || insertedStations.contains(String.valueOf(stationA) + String.valueOf(stationB))) {
                    stationA = rand.nextInt(stationCount);
                    stationB = rand.nextInt(stationCount);
                    System.out.println("GENERATING");
                }
                
                insertedStations.add(String.valueOf(stationA) + String.valueOf(stationB));
                insertedStations.add(String.valueOf(stationB) + String.valueOf(stationA));

                db.addStationLink(stationA, stationB, rand.nextInt(100)+5);

                generatedLinksCount++;
            }
        }
    }
    
}
