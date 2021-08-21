FROM openjdk:8
VOLUME /tmp
EXPOSE 8090
ADD target/central-oauth2-server-0.0.1-SNAPSHOT.jar central-oauth2-server-docker-app.jar
ENV JAVA_OPTS="-Xms128m -Xmx128m"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /central-oauth2-server-docker-app.jar" ]
