package com.ml.coursework.restapi.w2092528;

import java.util.UUID;

public class SensorReading implements BaseModel{
private String id; // Unique reading event ID (UUID recommended )
private long timestamp ; // Epoch time (ms) when the reading was captured
private double value; // The actual metric value recorded by the hardware
// Constructors , getters , setters ...
public SensorReading(double value){
    id = UUID.randomUUID().toString(); //converting to string for easier api use
    timestamp = System.currentTimeMillis();
    this.value = value;
}
@Override
public String getId(){return id;}
public long getTimestamp(){return timestamp;}
public double getValue(){return value;}

@Override
public void setId(String id){this.id = id;}
public void setTimestamp(long timestamp){this.timestamp = timestamp;}
public void setValue(double value){this.value = value;}
}
