FROM gradle:8 as BUILD
LABEL authors="alyxg"
LABEL maintainer="the_alyxg@proton.me"

COPY --chown=gradle:gradle . /home/gradle/src/
WORKDIR /home/gradle/src
RUN gradle clean --no-daemon
RUN gradle build --no-daemon

FROM openjdk:17

EXPOSE 8888

ENV DB_URI ${DB_URI}
ENV DB_PORT ${DB_PORT}
ENV DB_USER ${DB_USER}
ENV DB_PASS ${DB_PASS}
ENV DB_DATA ${DB_DATA}

ENV ENVIRONMENT=PROD

RUN mkdir /app

COPY --from=BUILD /home/gradle/src/build/libs/* /app/fashionscape-api.jar

ENTRYPOINT ["java", "-jar", "-Xmx3000m", "/app/fashionscape-api.jar"]