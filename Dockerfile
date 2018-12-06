FROM java:8  
COPY ./PlikJava.java ./
COPY ./mysql-connector-java-8.0.13.jar /mysql-connector-java-8.0.13.jar
RUN javac PlikJava.java
CMD ["java", "-classpath", "mysql-connector-java-8.0.13.jar:.","PlikJava"]
