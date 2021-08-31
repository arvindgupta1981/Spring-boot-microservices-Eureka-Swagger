FROM openjdk:8
VOLUME /tmp
EXPOSE 8181
ADD target/CandidateServices-0.0.1-SNAPSHOT.jar candidate-service-docker-app.jar
ENV JAVA_OPTS="-Xms128m -Xmx128m"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /candidate-service-docker-app.jar" ]
