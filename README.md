# monitorserver
An application that will collect data from sensor information coming from a Raspberry Pi.
## Network Diagram
![alt text](https://github.com/polinchw/monitorserver/blob/master/documentation/diagrams/vpc.png)
## Build
run mvn clean install
## Run
java -jar -Dspring.profiles.active=dev monitor-server.jar
## Swagger
Navigate to http://localhost:8080/swagger-ui.html# to view rest APIs.
## Docker Machine/Swarm Deployment on AWS

1. Create a <b>Docker Machine</b> (hopefully you an reuse one in your infrastructure).
2. Git clone this repo on your Docker Machine: https://github.com/polinchw/docker-tools
3. chmod u+x docker-tools/docker-machine/docker-swarm/aws/bash-scripts/create-swarm-instances.sh 
4. Create a <b>Docker Swarm</b> under the <u>control</u> of the <b>Docker Machine</b> to run the monitor-frontend on.  This will install the Docker Swarm on your selected AWS VPC and subnet.
    
 ./docker-tools/docker-machine/docker-swarm/aws/bash-scripts/create-swarm-instances.sh AKIAJB7DZD4I6QA2XBRA xxx vpc-9dc174e4 subnet-8102b5ad polinchw monitorserver 1 ami-8887be9e AppSecurityGroup
  
5. Create a <b>Docker Service</b>.  Run the monitor-frontend app in the Docker Swarm as a Docker Service by running this command <b>on</b> the Docker Machine.

  docker-machine ssh monitorserver-swarm-master 'docker service create -e "SPRING_PROFILES_ACTIVE=aws-dev" -e "JASYPT_ENCRYPTOR_PASSWORD=xxx" --replicas 2 --name monitor-server -p 8080:8080 polinchw/monitor-server'

6. You probably want to add a AWS load balancer to load balance the monitor-frontend at this point.

## Docker Compose

1. To run the app with docker compose with a targeted environment run:

    docker-compose build
    
    docker-compose -f docker-compose.yml -f dev-local.yml up
