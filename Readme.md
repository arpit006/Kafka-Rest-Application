This is a Kafka application framework code with Producer, Listeners and Consumer.
This application is helpful to get a better and deep understanding of the working of Kafka Producer and Consumers with 
the help of easy examples.

To run this app:- 
 1.) Download Kafka by following the steps in the given link
    *  https://kafka.apache.org/quickstart
    *  https://kafka.apache.org/downloads
 
 2.) Start the zookeeper server.
    go inside kafka folder
    bin/zookeeper-server-start.sh config/zookeeper.properties
 
 3.) Start the Kafka Server.
    go inside kafka folder
    bin/kafka-server-start.sh config/server.properties
    
 4.) Run this application.
    In application.properties file you can configure the port and extra information.(Default port is set 8281).
 
 5.) This is a kafka framework code which is kept segregated in the framework package, and an example package has been 
 provided so that it is easy to demonstrate how this code just needs to be extended to make it work.
 
 6.) test.http file is an example file to trigger the kafka producer and consumer which is maintained in the framework 
 and is called with REST-api's.
    