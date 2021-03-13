FROM openjdk:8  
VOLUME /tmp
EXPOSE 8282
ADD target/configurations-server-0.0.1-SNAPSHOT.jar configurations-service-docker-app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /configurations-service-docker-app.jar" ]