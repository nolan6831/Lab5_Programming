package server;

import common.City;

public class CollectionManager {
    private java.util.Vector<City> collection;
    private java.time.LocalDateTime creationDate;
    private Long currentId = 1L;


    public CollectionManager(java.util.Vector<City> collection){
        this.collection = collection;
        this.creationDate = java.time.LocalDateTime.now();
    }

    public java.util.Vector<City> getCollection(){
        return this.collection;
    }

    public void setCollection(java.util.Vector<City> collection){
        this.collection = collection;
    }

    public java.time.LocalDateTime getCreationDate(){
        return this.creationDate;

    }

    public void setCreationDate(java.time.LocalDateTime creationDate){
        this.creationDate = creationDate;
    }

    public String info(){
        return "Vector: " + this.collection.getClass().getName() +
                "\nCreation date: " + this.creationDate.toString() +
                "\nAmount of elements: " + this.collection.size();
    }

    public String show(){
        return this.collection.toString();
    }

    public void add(City city){ // needs and argument
        city.setId(currentId);
        currentId++;
        city.setCreationDate(java.time.LocalDateTime.now());
        this.collection.add(city);
    }

    public boolean updateId(Long id, City newCity){ // needs an argument and an element
        for (int i = 0; i < this.collection.size(); i++){
            City currentCity = this.collection.get(i);
            if (currentCity.getId().equals(id)){
                newCity.setId
            }
        }
    }

    public boolean removeById(Long id){ // needs an argument
        for (int i = 0; i < this.collection.size(); i++){
            City currentCity = this.collection.get(i);
            if (currentCity.getId().equals(id)){
                this.collection.remove(i);
                return true;
            }
        }
        return false;

    }

    public void clear(){
        this.collection.clear();
    }

    public boolean removeFirst(){
        if (!this.collection.isEmpty()){
            this.collection.remove(0);
            return true;
        }
        else{
            return false;
        }
    }

    public void reorder(){

    }

    public void removeAllByGovernment(common.Government government){ // needs an argument

    }

    public String groupCountingById(){
        return "";
    }

    public String filterStartsWithName(String name){ // needs an argument
        return "";
    }
}

