package com.ml.coursework.restapi.w2092528;

import java.util.ArrayList;
import java.util.List;

public class Room implements BaseModel{
private String id; // Unique identifier , e.g., "LIB -301"
private String name; // Human - readable name , e.g., " Library, Quiet, Study"
private int capacity ; // Maximum occupancy for safety regulations
private List<String> sensorIds = new ArrayList<>(); // Collection of IDs of sensors deployed in this room
// Constructors , getters , setters ...
public Room(String id, String name, int capacity){
    this.id = id; 
    this.name = name;
    this.capacity = capacity;
}
@Override
public String getId(){return id;}
public String getName(){return name;}
public int getCapacity(){return capacity;}
public List<String> getSensorIdList(){return sensorIds;}

@Override
public void setId(String id){this.id = id;}
public void setName(String name){this.name = name;}
public void setCapacity(int capacity){this.capacity = capacity;}
}