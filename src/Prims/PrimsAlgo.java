/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prims;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Hishara
 */
public class PrimsAlgo {

    int dataSetGraph[][];
    Map<Integer, String> stationDataTreeMap;
    int mst[];
    long startTime;
    long endTime;
    long executedTime;
    Map<String, Integer> minimumSpan;

    public PrimsAlgo(int dataSetGraph[][], Map<Integer, String> stationDataTreeMap) {
        this.dataSetGraph = dataSetGraph;
        this.stationDataTreeMap = stationDataTreeMap;
    }

    public void applyPrims() {
        //getting the current time in nanoseconds
        startTime = System.nanoTime();
        //array to store the minimum spaning tree information
        mst = new int[dataSetGraph.length];
        //array to store the closest distances(closest edges)
        int cDistances[] = new int[dataSetGraph.length];
        //array to store all the visited nodes(edges)
        boolean visited[] = new boolean[dataSetGraph.length];

        //values used in the 2nd inner for loop
        int minVertex;
        int minDistance;

        for (int i = 0; i < dataSetGraph.length; i++) {
            //initialize all the edge distance as infinite
            cDistances[i] = Integer.MAX_VALUE;
            //initialize all the visited edges as false
            visited[i] = false;
        }

        //the first vertex will be selected when the distance is lesser than the infinite
        //essential step
        cDistances[1] = 0;
        //the first index is the starting point so theres no paths before
        mst[1] = -1;

        //Traversing through all the vertices of the graph
        for (int i = 0; i < dataSetGraph.length; i++) {
            //for each of the iteration initializing the value of minimum vertex index as -1
            minVertex = -1;
            //for each of the iteration initializing the minimum distance as INFINITE
            minDistance = Integer.MAX_VALUE;

            //Traversing through the dataset
            for (int j = 1; j < dataSetGraph.length; j++) {
                //here the minimum vertex is found and the distance will be set based on
                //the vertex is not previously visited
                //the distance of the current path is lesser than the least distance found
                if (visited[j] == false && cDistances[j] < minDistance) {
                    minDistance = cDistances[j];
                    minVertex = j;
                }
            }

            if (minVertex != -1) {
                //if visited a minimum distanced vertex set value as true
                visited[minVertex] = true;
            }

            for (int k = 1; k < dataSetGraph.length; k++) {

                if (minVertex == -1) {
                    break;
                }

                //here the minimum span vertices is selected based on
                //there should be a edge between vertices which is not equal to 0
                //it should be not visited earlier
                //the weight of the current edge (distance) of the vertex should be lesser than the minimum distance found so far
                if (dataSetGraph[minVertex][k] != 0 && visited[k] == false && dataSetGraph[minVertex][k] < cDistances[k]) {
                    //selecting the vertex as a minimum span vertex
                    mst[k] = minVertex;
                    cDistances[k] = dataSetGraph[minVertex][k];
                }
            }
        }

        //getting the end time in nanoseconds
        endTime = System.nanoTime();
        executedTime = endTime - startTime;
        System.out.println("\n\n==Time Duration for Prims Execution : " + (executedTime) + " nanoseconds==\n\n");
    }

    public Map<String, Integer> getMinimumConnectors() {
        //getting the current time in nanoseconds
        startTime = System.nanoTime();
        minimumSpan = new TreeMap<>();
        System.out.println("\n==Minimum Railway Tracks between stations==\n");
        int minDistance = 0;
        for (int i = 1; i < dataSetGraph.length; i++) {
            if (mst[i] != -1&&mst[i]!=0) {
                minimumSpan.put(i + " to " + mst[i], dataSetGraph[mst[i]][i]);
//                System.out.println("Station : " + mst[i] + " to " + i + "\t=" + dataSetGraph[mst[i]][i]);
                minDistance = minDistance + dataSetGraph[mst[i]][i];
            }
        }
        System.out.println("Min Weight = " + minDistance);
        //getting the end time in nanoseconds
        endTime = System.nanoTime();

        System.out.println("\n\n==Time Duration for Retrieving Minimum Connectors : " + (endTime - startTime) + " nanoseconds==\n\n");
//        getPaths();
        return minimumSpan;
    }
    
    public long getExecutionTime(){
        return executedTime;
    }

}
