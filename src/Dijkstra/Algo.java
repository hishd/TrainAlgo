/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Hishara
 */
public class Algo {

    private int vertices;
    private int distances[];
    private boolean visited[];
    private int paths[];
    int dataSetGraph[][];
    Map<Integer, String> trainStationInfo;
    ArrayList<String> shortestPath;
    int shortestDistance = -1;

    public Algo(int dataSetGraph[][], Map<Integer, String> trainStationInfo) {
        this.dataSetGraph = dataSetGraph;
        this.trainStationInfo = trainStationInfo;
    }

    //main algorithm
    public void applyDijkstra(int sourceStation) {

        //retrieving the number of vertices in the data set to travel each iteration
        vertices = dataSetGraph.length;
        //this array will hold the shortest distances from source to destimation
        distances = new int[vertices];
        //this array will hold the visited nodes
        visited = new boolean[vertices];

        //the loop will initilize the distances and visited arrays as
        //whole visited indexed as FALSE
        //all distances as INFINITE(maximum int value) before traversing
        for (int i = 0; i < vertices; i++) {
            distances[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        //The distance from shource vertex to source vertex should be 0
        distances[sourceStation] = 0;

        //The array to store the shortest paths
        paths = new int[vertices];

        //the source node does not have a previous path (it's the starting point of the traversal)
        //therefore assigning a FLAG value of -1
        paths[sourceStation] = -1;

        //Traversing through all the vertices of the graph
        for (int i = 1; i < vertices; i++) {

            //cVertex holds closest vertex
            //distance holds the closest deistance
            int cVertex = -1;
            int distance = Integer.MAX_VALUE;

            for (int vIndex = 0; vIndex < vertices; vIndex++) {
                //Pick a vertex which is not visited
                //Pick a next minimum distance vertex (closest vertex)
                if (!visited[vIndex] && distances[vIndex] < distance) {
                    cVertex = vIndex; //If so closest vertex should be the current vertexIndex of the for loop
                    distance = distances[vIndex]; //If so the closest distance should be in the distances array of the current verText Index of for loop
                }
            }

            //set the vertex as visited
            System.out.println("Vertex : " + i + " cVertex : " + cVertex);
            //visited[cVertex] = true;
            if (cVertex != -1) {
                visited[cVertex] = true;
            }

            for (int vIndex = 0; vIndex < vertices; vIndex++) {

                if (cVertex == -1) {
                    break;
                }
                //getting the distance of the path from the dataset
                int pathDistance = dataSetGraph[cVertex][vIndex];

                //setting the distance value of the selected vertex whenever the distance is closer than the previous path distance
                if (pathDistance > 0 && ((pathDistance + distance) < distances[vIndex])) {
                    distances[vIndex] = (pathDistance + distance);
                    paths[vIndex] = cVertex;
                }
            }

        }

    }
    
    public int getShortestDistance(){
        return shortestDistance;
    }
    
    public ArrayList<String> getShortestPath(int destinationStation){
        shortestDistance = distances[destinationStation];
        shortestPath = new ArrayList<>();
        findShortestPath(destinationStation);
        return shortestPath;
    }

    //get the shortest path between the source Station and destination Station
    public void findShortestPath(int vertex) {

        //ignore the source vertex if found
        if (vertex == -1) {
            return;
        }

        findShortestPath(paths[vertex]);
        System.out.print(" Station :" + trainStationInfo.get(vertex) + " (" + vertex + ") >>");
        shortestPath.add(trainStationInfo.get(vertex));
    }

}
