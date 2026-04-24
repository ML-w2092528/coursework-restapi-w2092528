# coursework-restapi-w2092528

client server architecture coursework. a small REST API that can be used to read and track sensors and rooms.

## Install

### 1. Clone this repo using git (into a directory of your choice

`git clone https://github.com/ML-w2092528/coursework-restapi-w2092528`

### 2. install a glassfish server

open **apache netbeans**, navigate to *tools* -> *servers* -> *add server* -> *glassfish server* -> accept the agreement and download *glassfish server 7.0.3* -> *next* -> setup a domain (recommend leaving username and password blank)

### 3. open the project in netbeans

navigate to *file* -> *open project...* -> find the directory that you cloned the repo in -> *open project*

### 4. configuration check

once the project is open right click the project in netbeans -> *properties* -> *Run* -> check the following settings:

Server: *glassfish server* (this will have a unique name, please use the one created earlier)
Java EE Version: *Jakarta EE 10 Web*
Context Path: *"/api"*


# Curl commands (can be done with a web browser)

return discovery JSON
`localhost:8080/api/v1`

return all rooms
`localhost:8080/api/v1/rooms`

return room by ID
`localhost:8080/api/v1/rooms/{roomId}`

return all sensors
`localhost:8080/api/v1/sensors`

return all sensors of a type
`localhost:8080/api/v1/sensors?type=(type)`


# Questions

### 1.1

By default, all JAX-RS resourse classes are instantiated per request. data is frequently split between classes, as that forces the garbage collector to keep using the same data between requests. data also needs to be structured in a way that race conditions can't affect the data (e.g. having an ArrayList that can add data at any time, preventing 2 different requests getting in the way of each other)

### 1.2

Linked documentation can make it easier to navigate and by extension, easier to read and understand. unlinked documentation can also cause issues with scalability as larger systems may have large amounts of documentation, which can cause a problem if all the documentation has to be kept on a single page.

### 2.1

Returning a room by ID will use much less bandwidth than returning all rooms, and the difference in bandwidth becomes much higher with more data. returning all the rooms at once when it is not necessary poses a large problem for scalability, both for the server to handle multiple requests for large amounts of data but also clients, for processing large amounts of unnecessary data.

### 2.2

The delete operation is not idempotent as by default nothing is returned with a successful deletion, but a JSON error message is returned if there was a problem completing the command (e.g. the room doesn't exist, there are still sensors associated)

### 3.1

JAX-RS will handle the mismatch by trying to fit Java datatypes into the desired format as much as possible. with formats like `text/plain` this may look like a list converted to a string, or with `application/xml` it may look like variables being matched to tags and values being placed inside said tags.

### 3.2

It uses less pathing and is more similar to the default pathing for sensors, which fits better for an optional variable that's only used as a filter.

### 4.1

This can create very long pathways for data which can be confusing to use, which presents a problem for scalability, as adding just one more nested path would use 6 path arguments alongside the context path, application path, as well as the URL.

### 5.2

Error codes are generally used more to describe internal issues during development, so the client (which in this case, is not managed by the developer) is not considered; the internal resource can't be found, so 422 makes sense to the developer.

### 5.4

Giving internal stack traces can expose the way a system works by seeing what doesn't have much error handling, how functions are structured, what syntax the app works by, and many other things that bad actors could use to try and trick the system. giving as little information as possible can prevent this, as it can hide what's actually happening in the background.

### 5.5

Attaching Logger to each statement in a resource opens up more chances for human error and also presents an issue in scalability, as adding extra code to each statement can take up time. Code would be harder to read which could cause problems for maintaining the system.
