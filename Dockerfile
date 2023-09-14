FROM openjdk:17
EXPOSE 9090
ADD build/libs/AllInOne-1.0.0.jar AllInOne-1.0.0.jar
ENTRYPOINT ["java","-jar","/AllInOne-1.0.0.jar"]
