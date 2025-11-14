# Notes and Changes from the original project before executing the tasks

1.Reversed engineer the entire project because meduim has a paywall to read the article provided
2.added comments through out the project to reflect on code understanding
3.changed the Dockerfile so i run the WebServerHttp instead of the socket one because it is way cleaner 






# Steps To run the project


1.editing the base image because it no longer exist to this in the Dockerfile

    FROM eclipse-temurin:8-jdk-alpine


2.Building the docker image from Dockerfile using this command

    docker build --network=host -t executor-server .  


3. Running a container from the image

    docker run --network=host --name executor-server-container -d executor-server
