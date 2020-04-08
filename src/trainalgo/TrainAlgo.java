/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainalgo;

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
        
//        Stations s = new Stations();
//        
//        s.linkSampleData(200); //200 = no of random links

          try{
                Dataset ds = new Dataset();
                ds.initStationInfoDatastruct();
          }catch(Exception e){
              e.printStackTrace();
          }
          
    }
    
}
