# freelance_job_Service_To_Handle_Device
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
