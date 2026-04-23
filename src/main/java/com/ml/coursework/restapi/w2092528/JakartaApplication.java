package com.ml.coursework.restapi.w2092528; 

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.json.Json;
import jakarta.json.JsonObject;

@ApplicationPath("/api/v1")
public class JakartaApplication extends Application {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getDiscovery(){ //building manually for better control
        return Json.createObjectBuilder()
            .add("Version", "v1")
            .add("Contact", "w2092528@westminster.ac.uk")
            .add("rooms", "api/v1/rooms")
            .build();
    }
    
}
