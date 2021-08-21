FROM openjdk:8
VOLUME /tmp
EXPOSE 8681
ADD target/applyjobservice-0.0.1-SNAPSHOT.jar applyjobservice-docker-app.jar
ENV JAVA_OPTS="-Xms128m -Xmx128m"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /applyjobservice-docker-app.jar" ]
