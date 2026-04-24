package com.ml.coursework.restapi.w2092528.resources;

import com.ml.coursework.restapi.w2092528.Sensor;
import com.ml.coursework.restapi.w2092528.SensorReading;
import com.ml.coursework.restapi.w2092528.dao.Database;
import com.ml.coursework.restapi.w2092528.dao.GenericDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Path("/sensors")
public class SensorResource {
    public static GenericDAO<Sensor> sensorDAO = new GenericDAO<>(Database.SENSORS);
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sensor> getAllSensors(@DefaultValue("any") @QueryParam("type") String type){
        List<Sensor> sensorList = sensorDAO.getAll();
        if(type.equals("any")){
            return sensorList;
        } else {
            List<Sensor> filteredList = new ArrayList<>();
            for(int i = 0; i < sensorDAO.getAll().size(); i++){
            if(type.equals(sensorList.get(i).getType())){
                filteredList.add(sensorList.get(i));
            }
        } return filteredList;   
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addSensor(Sensor sensor){
        if((sensor.getRoomId()  != null) && SensorRoom.checkRoomExistance(sensor.getRoomId())){
            sensorDAO.add(sensor);
        }
    }
    
    @Path("{sensorId}/read")
    public SensorReadingResource sensorReading(@PathParam("sensorId") String sensorId){
        List<Sensor> sensorList = sensorDAO.getAll();
        for(int i = 0; i < sensorDAO.getAll().size(); i++){
            double random = ThreadLocalRandom.current().nextDouble(0, 20);
            if(sensorList.get(i).getStatus() != "MAINTENANCE"){
                sensorList.get(i).setValue(random);
                sensorList.get(i).setStatus("ONLINE");
            }
            sensorDAO.update(sensorList.get(i));
        }
        SensorReadingResource sensorReadingResource = new SensorReadingResource(sensorId);
        return sensorReadingResource;
    }
    
}
