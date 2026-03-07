package server;

import common.City;

public class CollectionManager {
    private java.util.Vector<City> cities;
    private java.time.LocalDateTime creationDate;

    public CollectionManager(java.util.Vector<City> cities){
        java.util.Vector<City> city = cities;
        java.time.LocalDateTime time = java.time.LocalDateTime.now();
    }


}

