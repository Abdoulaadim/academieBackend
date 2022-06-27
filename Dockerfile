FROM openjdk
EXPOSE 8080
ADD target/academie.jar academie.jar
ENTRYPOINT ["java","-jar","/academie.jar"]