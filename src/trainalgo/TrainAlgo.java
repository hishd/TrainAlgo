/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainalgo;

import Dijkstra.Algo;
import java.util.ArrayList;
import trainalgo.stations.Dataset;
import trainalgo.stations.Stations;

/**
 *
 * @author Hishara
 */
public class TrainAlgo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*Creating an object of the Stations Class*/
//        Stations s = new Stations();

        /*Generate Rancom Links*/
//        s.linkSampleData(200); //200 = no of random links
        try {

            Dataset ds = new Dataset();
            ds.initStationInfoDatastruct();
//            ds.addStationToStationInfoDatastruct("New Station 2");
//            ds.updateStationInStationInfoDatastruct("New Station", "B new Station");
//            ds.removeStationInStationInfoDatastructure("New Station 3");
//            ds.addStationToStationInfoDatastruct("New Station 4");

            ds.initStationPathDatastruct();
//            ds.addStationPathToDataStruct("Kurana", "Negombo", 100);
//            ds.updateStationPathInDataStructure("Kurana", "Negombo", 50);
//            ds.removeStationPathInDatastructure("Kurana", "Negombo");

            /*Creating a object from Algorithm (Djkstra) class with passing the Station information and Station links graph(paths,edges)*/
            Algo algo = new Algo(ds.getStationPaths(), ds.getStationDataTreeMap());
            /*Applying the Dijkstra algorithm to the station paths data structure with passing the source(start) station*/
            algo.applyDijkstra(ds.retrieveStationID("Ganemulla"));
            /*Retrieving the returned arraylist which contains the shortest path from source (start) station to destination station
            with using an arraylist, getShortestPath() will be called by passing the destination station*/
            ArrayList<String> shortestPath = algo.getShortestPath(ds.retrieveStationID("Kadigamuwa"));

            /*Displaying all paths(shortest path)*/
            System.out.println("\n\n==PATHS==\n");

            shortestPath.forEach((path) -> {
                System.out.println(path);
            });
            
            /*Displaying total distance(shortest path distance)*/
            System.out.println("Shortest Distance : " + String.valueOf(algo.getShortestDistance()));
            
            /*The shortestPath ArrayList contains the shortest path from source station to the destination station*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
