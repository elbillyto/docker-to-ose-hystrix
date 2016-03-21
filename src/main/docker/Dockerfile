FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD docker-to-ose-hystrix-0.0.1.jar app.jar
RUN touch /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
