package com.ml.coursework.restapi.w2092528.resources;

import com.ml.coursework.restapi.w2092528.Room;
import com.ml.coursework.restapi.w2092528.dao.Database;
import com.ml.coursework.restapi.w2092528.dao.GenericDAO;
import com.ml.coursework.restapi.w2092528.exception.ResourceConflictException;
import com.ml.coursework.restapi.w2092528.exception.LinkedResourceNotFoundException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/rooms")
public class SensorRoom {
    private static GenericDAO<Room> roomDAO = new GenericDAO<>(Database.ROOMS);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> getAllRooms(){return roomDAO.getAll();}
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addRoom(Room room) {
        roomDAO.add(room);
    }
    
    @GET
    @Path("/{roomId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Room GetRoomById(@PathParam("roomId") String roomId) {
        Room room = roomDAO.getById(roomId);
        if(room != null){
            return room;
        } else {
            throw new LinkedResourceNotFoundException("cannot get a room that does not exist");
        }
        
    }
    
    @DELETE
    @Path("/{roomId}")
    public void deleteRoom(@PathParam("roomId") String roomId) {
        Room existingRoom = roomDAO.getById(roomId);
        if(existingRoom == null) {
            throw new LinkedResourceNotFoundException("cannot delete a room that does not exist");
        }
        else if(existingRoom.getSensorIdList().isEmpty()) {
            roomDAO.delete(roomId);
        } else {
            throw new ResourceConflictException("This room still has sensors associated with it");
        }
        
    }
    
    public static boolean checkRoomExistance(String roomId){ //used in SensorResource
        Room room = roomDAO.getById(roomId);
        return room != null;
    }  
}
