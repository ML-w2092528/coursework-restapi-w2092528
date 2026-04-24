package com.ml.coursework.restapi.w2092528.resources;


import com.ml.coursework.restapi.w2092528.SensorReading;
import com.ml.coursework.restapi.w2092528.Sensor;
import com.ml.coursework.restapi.w2092528.exception.SensorUnavailableException;
import com.ml.coursework.restapi.w2092528.dao.Database;
import com.ml.coursework.restapi.w2092528.dao.GenericDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;


public class SensorReadingResource {
    private static GenericDAO<SensorReading> sensorReadingDAO = new GenericDAO<>(Database.SENSORREADINGS);
    private String sensorId;
    
    public SensorReadingResource(String sensorId){
        this.sensorId = sensorId;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SensorReading> getAllReadings(){return sensorReadingDAO.getAll();}
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void readSensor(){
        Sensor toRead = SensorResource.sensorDAO.getById(sensorId);
        if(toRead.getType() == "MAINTENANCE"){
            throw new SensorUnavailableException("sensors under maintenance cannot be read");
        }else {
            sensorReadingDAO.add(new SensorReading(toRead.getValue()));
        }
        
    }
}
