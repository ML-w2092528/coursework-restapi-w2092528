package com.ml.coursework.restapi.w2092528.resources;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Path;

@Path("/")
public class DiscoveryResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject DiscoveryResource(){
        JsonObject discovery = Json.createObjectBuilder()
            .add("Version", "1.0")
            .add("Contact", "w2092528@westminster.ac.uk")
            .add("Rooms", "api/v1/rooms")
            .add("Sensors", "api/v1/sensors")
            .add("Sensor query by type", "api/v1/sensors?type=[query]")
            .build();
        return discovery;
    }
}
