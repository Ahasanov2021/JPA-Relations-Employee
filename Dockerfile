FROM openjdk:17-alpine
#COPY build/libs/*.jar /app/
ARG employee
ENV userName=$employee
#WORKDIR /app/
#RUN mv /app/*.jar /app/app.jar
#ENTRYPOINT ["java"]
#CMD ["-jar", "/app/app.jar"]
CMD ["sh", "-c", "echo ${userName}"]

#ARG employee
#ENV userName=$employee
##WORKDIR /app/
##RUN mv /app/*.jar /app/app.jar
##ENTRYPOINT ["java", "-jar", "/app/app.jar"]
#CMD ["sh", "-c", "echo $userName"]