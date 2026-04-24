
package com.ml.coursework.restapi.w2092528.dao;

import com.ml.coursework.restapi.w2092528.Room;
import com.ml.coursework.restapi.w2092528.Sensor;
import com.ml.coursework.restapi.w2092528.SensorReading;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Database {
    public static final List<Room> ROOMS = new ArrayList<>();
    public static final List<Sensor> SENSORS = new ArrayList<>();
    public static final List<SensorReading> SENSORREADINGS = new ArrayList<>();

    static {
        // Initialise Rooms
        ROOMS.add(new Room("LIB-301", "Library", 10, Arrays.asList(new String[]{"TEMP-001"})));
        ROOMS.add(new Room("STU-103", "Study", 6, Arrays.asList(new String[]{"CO2-002"}))); 

        // Initialise Sensors
        SENSORS.add(new Sensor("TEMP-001", "Temperature", "LIB-301"));
        SENSORS.add(new Sensor("CO2-002", "CO2", "STU-103"));

        //SensorReadings should not be initialised (as sensor values start at zero)
    }
}

