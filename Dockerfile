FROM anapsix/alpine-java
WORKDIR /
ADD target/user-mysql-docker.jar user-mysql-docker.jar
EXPOSE 5000
CMD java -jar user-mysql-docker.jar
