FROM openjdk:8  
VOLUME /tmp
EXPOSE 8761
ADD target/netflix-eureka-server-0.0.1-SNAPSHOT.jar discovery-service-docker-app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /configurations-service-docker-app.jar" ]