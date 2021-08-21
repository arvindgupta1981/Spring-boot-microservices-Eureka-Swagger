FROM openjdk:8
VOLUME /tmp
EXPOSE 8585
ADD target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway-docker-app.jar
ENV JAVA_OPTS="-Xms128m -Xmx128m"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /api-gateway-docker-app.jar" ]
