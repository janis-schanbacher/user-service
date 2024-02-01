# Start with a base image containing Java runtime
FROM openjdk:21-jdk-slim

# Add Maintainer Info
LABEL maintainer="janis.schanbacher@gmx.net"

# Make port 9000 available to the world outside this container
# Change to 9000, when using the prod profile
EXPOSE 8000

# The application's jar file
ARG JAR_FILE=build/libs/*SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/app.jar"]