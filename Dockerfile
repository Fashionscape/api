FROM gradle:8 as BUILD
LABEL authors="alyxg"
LABEL maintainer="the_alyxg@proton.me"

COPY --chown-gradle:gradle . /home/gradle/src/
WORKDIR /home/gradle/src
RUN gradle clean --no-daemon
RUN gradle build --no-daemon

FROM openjdk:17

EXPOSE 8888

ARG DB_URI
ARG DB_PORT
ARG DB_USER
ARG DB_PASS
ARG DB_DATA

ENV DB_URI ${DB_URI?dburinotset}
ENV DB_PORT ${DB_PORT?dbportnotset}
ENV DB_USER ${DB_USER?dbusernotset}
ENV DB_PASS ${DB_PASS?dbpassnotset}
ENV DB_DATA ${DB_DATA?dbdatanotset}

ENV ENVIRONMENT=PROD

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/* /app/fashionscape-api.jar

ENTRYPOINT ["java", "-jar", "-Xmx3000m", "/app/fashionscape-api.jar"]