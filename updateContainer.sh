#!/bin/bash


#stopping the container 
docker stop executor-server-container
docker rm executor-server-container



# rebuilding the image
docker build --network=host -t executor-server .



# run container from image

docker run --network=host --name executor-server-container -d executor-server



#checking the logs
docker logs -f executor-server-container  