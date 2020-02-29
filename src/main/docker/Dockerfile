FROM openjdk:8-jdk

EXPOSE 8082

VOLUME /tmp
ADD maven/data-manipulation-0.0.1-SNAPSHOT.jar myapp.jar
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar"]