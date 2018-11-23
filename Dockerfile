FROM ubuntu:latest 
RUN apt-get update
RUN apt-get install apache2
RUN service apache2 start
EXPOSE 80

