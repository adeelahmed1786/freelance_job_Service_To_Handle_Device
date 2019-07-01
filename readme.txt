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