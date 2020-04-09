# TrainAlgo

An application created to find the shortest paths between two railway stations.

# Creating Database

* Install WAMP Server
* Create a database named "traindb" using phpMyAdmin
* Create tables as <br>
	- tbl_stations(station_id[INT, PRIMARY KEY , ENABLE AUTO INCREMRNT], station_name[VARCHAR 100]) <br>
	- tbl_connections(station_1[INT], station_2[INT], distance[INT])
* Sample data dump is included on the Sample Data directory
	- After creating database use the import feature inorder to add the table to the database
