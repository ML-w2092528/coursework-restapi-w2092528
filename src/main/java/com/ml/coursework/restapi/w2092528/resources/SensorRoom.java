package com.ml.coursework.restapi.w2092528.resources;

import com.ml.coursework.restapi.w2092528.Room;
import com.ml.coursework.restapi.w2092528.dao.Database;
import com.ml.coursework.restapi.w2092528.dao.GenericDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.ArrayList;

@Path("/rooms")
public class SensorRoom {
    private GenericDAO<Room> roomDAO = new GenericDAO<>(Database.ROOMS);
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> getAllRooms(){return roomDAO.getAll();}
}
