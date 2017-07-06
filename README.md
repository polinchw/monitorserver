# monitorserver
An application that will collect data from sensor information coming from a Raspberry Pi.
## Network Diagram
https://github.com/polinchw/monitorserver/blob/master/documentation/diagrams/vpc.png
## Swagger
Navigate to http://localhost:8080/swagger-ui.html# to view rest APIs.
## Run in a Docker Swarm
docker-machine ssh monitorserver-swarm-master 'sudo docker service create -e "SPRING_PROFILES_ACTIVE=aws-dev" -e "JASYPT_ENCRYPTOR_PASSWORD=xxx" --replicas 2 --name monitor-server -p 8080:8080 polinchw/monitor-server:latest'   

