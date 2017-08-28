FROM openjdk:8u131-jdk

VOLUME /tmp
ADD target/monitor-server.jar /opt/monitor-server/
EXPOSE 8080
WORKDIR /opt/monitor-server/
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xms512m", "-Xmx1g", "-jar", "monitor-server.jar"]
