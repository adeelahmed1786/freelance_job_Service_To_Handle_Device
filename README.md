# Service to Handle Device
A device profile should be a record containing the following information:

Radio ID (a unique integer)

Radio alias (a string name)

List of allowed locations (each location being a simple string id)

Additionally each device has a location (a string), that initially is set to undefined.
The service should fulfill the following requirements:

Implement a REST API that allows the following:

Storage of radio profiles
POST /radios/{id}

Payload should be JSON following this schema:
{
“alias”: string,
“allowed_locations”: array<string>
}

Setting a location of a radio that is accepted if the location is on the radio’s list of allowed locations and rejected otherwise. If location change is rejected radio’s location remains the last accepted location
POST /radios/{id}/location	

Payload should be JSON following this schema:
{
“location”: string
}

Returns 200 OK for valid location

Returns 403 FORBIDDEN for invalid location

Retrieval of a radio’s location
GET /radios/{id}/location

Returns 200 OK with location in JSON form following the schema
{
“location”: string
}

Returns 404 NOT FOUND if no location exists

How the service stores data is up to you. 

You can also use any programming language you want 

Bonus points if you include a Dockerfile with all the dependencies that allows us to run your code inside a Docker container
first of all, we need to make jar 
for that we use 
1)mvn clean install
this will create a jar file in target folder
cool.
then we run command 
2)docker build --tag andrew .
where andrew will be my image name later on we will run this image with its name
this command should run in project root directory where DockerFile is present,
done
now we have created an image in docker now we need to run it,
to run it all we need is this command
docker run -p 8083:8083 andrew
